// Question 6: Flatten a list of lists of integers.

import java.util.*;

public class Q6_FlattenListOfLists {
    public static void main(String[] args) {
        List<List<Integer>> list = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4),
                Arrays.asList(5, 6)
        );

        List<Integer> result = list.stream()
                .flatMap(List::stream)
                .toList();

        System.out.println(result);
    }
}
