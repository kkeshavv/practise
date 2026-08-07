// Question 14: Library System: Given a list of books (title, author, year, genre),
// find the most published genre and the author with most books.

import java.util.*;
import java.util.stream.*;

class Book {
    String title, author, genre;
    int year;

    Book(String title, String author, int year, String genre) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.genre = genre;
    }

    String getAuthor() { return author; }
    String getGenre() { return genre; }
}

public class Q14_LibrarySystemAnalysis {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("A", "John", 2020, "Tech"),
                new Book("B", "John", 2021, "Tech"),
                new Book("C", "Mike", 2022, "Novel"),
                new Book("D", "John", 2023, "Novel")
        );

        String genre = books.stream()
                .collect(Collectors.groupingBy(Book::getGenre, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .get().getKey();

        String author = books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .get().getKey();

        System.out.println(genre);
        System.out.println(author);
    }
}
