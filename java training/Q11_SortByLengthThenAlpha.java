// Question 11: Sort strings by length, then alphabetically.

import java.util.*;

public class Q11_SortByLengthThenAlpha {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Java", "C", "Python", "Go", "Ruby");

        List<String> result = list.stream()
                .sorted(Comparator.comparingInt(String::length)
                        .thenComparing(String::compareTo))
                .toList();

        System.out.println(result);
    }
}
