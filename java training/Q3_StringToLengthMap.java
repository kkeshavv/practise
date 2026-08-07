// Question 3: Convert a list of strings to a map (string → length).

import java.util.*;
import java.util.stream.*;

public class Q3_StringToLengthMap {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Java", "Spring", "SQL");

        Map<String, Integer> map = list.stream()
                .collect(Collectors.toMap(s -> s, String::length));

        System.out.println(map);
    }
}
