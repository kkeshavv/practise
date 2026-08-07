// Question 2: Get the length of the longest string in a list.

import java.util.*;

public class Q2_LongestStringLength {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Java", "Programming", "Stream", "API");

        int longest = list.stream()
                .mapToInt(String::length)
                .max()
                .orElse(0);

        System.out.println(longest);
    }
}
