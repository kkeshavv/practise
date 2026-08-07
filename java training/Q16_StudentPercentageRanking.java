// Question 16: Student Report: Given students (name, marks in 5 subjects),
// calculate each student's percentage and rank them.

import java.util.*;

class Student {
    String name;
    List<Integer> marks;

    Student(String name, List<Integer> marks) {
        this.name = name;
        this.marks = marks;
    }

    String getName() { return name; }
    double getPercentage() {
        return marks.stream().mapToInt(Integer::intValue).average().orElse(0);
    }
}

public class Q16_StudentPercentageRanking {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Alice", Arrays.asList(90, 95, 88, 92, 91)),
                new Student("Bob", Arrays.asList(80, 82, 84, 81, 83)),
                new Student("Charlie", Arrays.asList(96, 94, 97, 95, 98))
        );

        List<Student> ranked = students.stream()
                .sorted(Comparator.comparingDouble(Student::getPercentage).reversed())
                .toList();

        int rank = 1;
        for (Student s : ranked) {
            System.out.println(rank++ + " " + s.getName() + " " + s.getPercentage());
        }
    }
}
