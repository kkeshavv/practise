// Question 12: Sort numbers by their absolute value.

import java.util.*;

public class Q12_SortByAbsoluteValue {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(-10, 5, -2, 8, -1);

        List<Integer> result = list.stream()
                .sorted(Comparator.comparingInt(Math::abs))
                .toList();

        System.out.println(result);
    }
}
