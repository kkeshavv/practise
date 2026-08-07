// Question 19: Convert a nested Map (Map<String, Map<String, Integer>>) to a flat list of entries.

import java.util.*;

public class Q19_FlattenNestedMap {
    public static void main(String[] args) {
        Map<String, Map<String, Integer>> map = new HashMap<>();

        Map<String, Integer> m1 = new HashMap<>();
        m1.put("A", 10);
        m1.put("B", 20);

        Map<String, Integer> m2 = new HashMap<>();
        m2.put("C", 30);

        map.put("First", m1);
        map.put("Second", m2);

        List<Map.Entry<String, Integer>> result = map.values().stream()
                .flatMap(inner -> inner.entrySet().stream())
                .toList();

        System.out.println(result);
    }
}
