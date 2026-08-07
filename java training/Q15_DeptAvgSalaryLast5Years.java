// Question 15: Employee Analysis: Given employees (id, name, department, salary, joining date),
// find the department-wise average salary of employees hired in the last 5 years.

import java.time.*;
import java.util.*;
import java.util.stream.*;

class Employee {
    int id;
    String name, department;
    double salary;
    LocalDate joiningDate;

    Employee(int id, String name, String department, double salary, LocalDate joiningDate) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.joiningDate = joiningDate;
    }

    String getDepartment() { return department; }
    double getSalary() { return salary; }
    LocalDate getJoiningDate() { return joiningDate; }
}

public class Q15_DeptAvgSalaryLast5Years {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "A", "IT", 70000, LocalDate.of(2023, 1, 1)),
                new Employee(2, "B", "IT", 60000, LocalDate.of(2022, 5, 10)),
                new Employee(3, "C", "HR", 50000, LocalDate.of(2018, 1, 1))
        );

        LocalDate limit = LocalDate.now().minusYears(5);

        Map<String, Double> result = employees.stream()
                .filter(e -> e.getJoiningDate().isAfter(limit))
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));

        System.out.println(result);
    }
}
