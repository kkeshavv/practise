// Question 22: Convert CSV data (List of String arrays) into objects and perform analysis.

import java.util.*;
import java.util.stream.*;

class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    double getSalary() { return salary; }
}

public class Q22_CsvToObjectsAnalysis {
    public static void main(String[] args) {
        List<String[]> csv = Arrays.asList(
                new String[]{"1", "Alice", "50000"},
                new String[]{"2", "Bob", "70000"},
                new String[]{"3", "Charlie", "60000"}
        );

        List<Employee> employees = csv.stream()
                .map(a -> new Employee(Integer.parseInt(a[0]), a[1], Double.parseDouble(a[2])))
                .toList();

        double avgSalary = employees.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));

        System.out.println(avgSalary);
    }
}
