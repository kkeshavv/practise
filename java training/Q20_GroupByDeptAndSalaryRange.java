// Question 20: Group employees by department and then by their salary range
// (e.g., < 50000, 50000-100000, > 100000).

import java.util.*;
import java.util.stream.*;

class Employee {
    String name, department;
    double salary;

    Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    String getDepartment() { return department; }
    double getSalary() { return salary; }
}

public class Q20_GroupByDeptAndSalaryRange {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("A", "IT", 45000),
                new Employee("B", "IT", 90000),
                new Employee("C", "HR", 120000)
        );

        Map<String, Map<String, List<Employee>>> result = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.groupingBy(e -> {
                            if (e.getSalary() < 50000) return "<50000";
                            else if (e.getSalary() <= 100000) return "50000-100000";
                            else return ">100000";
                        })
                ));

        System.out.println(result);
    }
}
