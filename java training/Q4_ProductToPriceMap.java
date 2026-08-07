// Question 4: Convert a list of products to a map (product name → price).

import java.util.*;
import java.util.stream.*;

class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
}

public class Q4_ProductToPriceMap {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", 70000),
                new Product("Phone", 25000),
                new Product("Mouse", 800)
        );

        Map<String, Double> map = products.stream()
                .collect(Collectors.toMap(Product::getName, Product::getPrice));

        System.out.println(map);
    }
}
