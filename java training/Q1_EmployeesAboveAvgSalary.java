// Question 1: Extract names of employees earning more than average salary.

import java.util.*;
import java.util.stream.*;

class Employee {
    String name;
    double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() { return name; }
    public double getSalary() { return salary; }
}

public class Q1_EmployeesAboveAvgSalary {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 50000),
                new Employee("Bob", 70000),
                new Employee("Charlie", 60000),
                new Employee("David", 90000)
        );

        double avgSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);

        List<String> result = employees.stream()
                .filter(e -> e.getSalary() > avgSalary)
                .map(Employee::getName)
                .toList();

        System.out.println(result);
    }
}
