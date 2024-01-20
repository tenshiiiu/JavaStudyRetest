// File: restaurant/Order.java
package restaurant;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<MenuItem> items;

    // Constructor
    public Order() {
        items = new ArrayList<>();
    }

    // Add item to the order
    public void addItem(MenuItem item) {
        items.add(item);
    }

    // Calculate the total cost of the order
    public double calculateTotal() {
        double total = 0.0;
        for (MenuItem item : items) {
            total += item.getPrice();
        }
        return total;
    }

    // Display the items in the order
    public void displayOrder() {
        System.out.println("Order Details:");
        for (MenuItem item : items) {
            System.out.println(item.getItemName() + " (" + item.getCategory() + "): $" + item.getPrice());
        }
        System.out.println("Total: $" + calculateTotal());
    }
}
