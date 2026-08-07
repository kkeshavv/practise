// Question 9: Given a list of orders (each with list of items), get all item names.

import java.util.*;

class Item {
    String name;

    Item(String name) { this.name = name; }
    public String getName() { return name; }
}

class Order {
    List<Item> items;

    Order(List<Item> items) { this.items = items; }
    public List<Item> getItems() { return items; }
}

public class Q9_AllItemNamesFromOrders {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
                new Order(Arrays.asList(new Item("Laptop"), new Item("Mouse"))),
                new Order(Arrays.asList(new Item("Phone"), new Item("Keyboard")))
        );

        List<String> names = orders.stream()
                .flatMap(order -> order.getItems().stream())
                .map(Item::getName)
                .toList();

        System.out.println(names);
    }
}
