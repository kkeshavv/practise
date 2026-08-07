// Question 8: Split sentences into individual words and collect all unique words.

import java.util.*;
import java.util.stream.*;

public class Q8_UniqueWordsFromSentences {
    public static void main(String[] args) {
        List<String> sentences = Arrays.asList(
                "Java is powerful",
                "Stream API is useful"
        );

        List<String> words = sentences.stream()
                .flatMap(s -> Arrays.stream(s.split(" ")))
                .distinct()
                .toList();

        System.out.println(words);
    }
}
