// Question 13: Shopping Cart: Given a list of orders (each with customer name and list of items with prices),
// calculate total amount spent by each customer.

import java.util.*;
import java.util.stream.*;

class Item {
    String name;
    double price;

    Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    double getPrice() { return price; }
}

class Order {
    String customer;
    List<Item> items;

    Order(String customer, List<Item> items) {
        this.customer = customer;
        this.items = items;
    }

    String getCustomer() { return customer; }
    List<Item> getItems() { return items; }
}

public class Q13_ShoppingCartTotalPerCustomer {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
                new Order("Alice", Arrays.asList(new Item("A", 100), new Item("B", 200))),
                new Order("Bob", Arrays.asList(new Item("C", 300))),
                new Order("Alice", Arrays.asList(new Item("D", 150)))
        );

        Map<String, Double> result = orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getCustomer,
                        Collectors.summingDouble(o -> o.getItems().stream()
                                .mapToDouble(Item::getPrice)
                                .sum())
                ));

        System.out.println(result);
    }
}
