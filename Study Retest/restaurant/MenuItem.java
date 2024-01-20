// File: restaurant/MenuItem.java
package restaurant;

public class MenuItem {
    private String itemName;
    private double price;
    private MenuCategory category;

    // Constructor
    public MenuItem(String itemName, double price, MenuCategory category) {
        this.itemName = itemName;
        this.price = price;
        this.category = category;
    }

    // Getter methods
    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public MenuCategory getCategory() {
        return category;
    }
}
