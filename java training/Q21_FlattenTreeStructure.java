// Question 21: Flatten a tree structure (like categories with subcategories).

import java.util.*;
import java.util.stream.*;

class Category {
    String name;
    List<Category> children = new ArrayList<>();

    Category(String name) { this.name = name; }

    List<Category> getChildren() { return children; }
    String getName() { return name; }

    static Stream<Category> flatten(Category root) {
        return Stream.concat(
                Stream.of(root),
                root.getChildren().stream().flatMap(Category::flatten)
        );
    }
}

public class Q21_FlattenTreeStructure {
    public static void main(String[] args) {
        Category root = new Category("Electronics");
        Category laptop = new Category("Laptop");
        Category mobile = new Category("Mobile");
        Category gaming = new Category("Gaming");

        laptop.children.add(gaming);
        root.children.add(laptop);
        root.children.add(mobile);

        List<String> result = Category.flatten(root)
                .map(Category::getName)
                .toList();

        System.out.println(result);
    }
}
