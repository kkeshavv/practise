// Question 7: Flatten a list of arrays of strings.

import java.util.*;
import java.util.stream.*;

public class Q7_FlattenListOfArrays {
    public static void main(String[] args) {
        List<String[]> list = Arrays.asList(
                new String[]{"Java", "SQL"},
                new String[]{"Spring", "HTML"}
        );

        List<String> result = list.stream()
                .flatMap(Arrays::stream)
                .toList();

        System.out.println(result);
    }
}
