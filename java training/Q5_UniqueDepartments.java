// Question 5: Transform a list of employees to a list of their departments (unique).

import java.util.*;

class Employee {
    String name;
    String department;

    Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getDepartment() { return department; }
}

public class Q5_UniqueDepartments {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("A", "IT"),
                new Employee("B", "HR"),
                new Employee("C", "IT"),
                new Employee("D", "Finance")
        );

        List<String> departments = employees.stream()
                .map(Employee::getDepartment)
                .distinct()
                .toList();

        System.out.println(departments);
    }
}
