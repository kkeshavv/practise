// Question 18: Flatten a Map of String → List<Integer> into a list of all integers.

import java.util.*;

public class Q18_FlattenMapStringToIntList {
    public static void main(String[] args) {
        Map<String, List<Integer>> map = new HashMap<>();
        map.put("A", Arrays.asList(1, 2));
        map.put("B", Arrays.asList(3, 4));

        List<Integer> result = map.values().stream()
                .flatMap(List::stream)
                .toList();

        System.out.println(result);
    }
}
