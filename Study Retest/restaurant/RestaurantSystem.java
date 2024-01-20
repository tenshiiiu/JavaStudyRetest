// File: restaurant/RestaurantSystem.java
package restaurant;

public class RestaurantSystem {
    public static void main(String[] args) {
        // Create menu items
        MenuItem appetizer1 = new MenuItem("Nachos", 8.99, MenuCategory.APPETIZER);
        MenuItem mainCourse1 = new MenuItem("Chicken Alfredo", 15.99, MenuCategory.MAIN_COURSE);
        MenuItem dessert1 = new MenuItem("Chocolate Cake", 6.99, MenuCategory.DESSERT);
        MenuItem beverage1 = new MenuItem("Soda", 2.49, MenuCategory.BEVERAGE);

        // Display menu items
        System.out.println("Menu Items:");
        displayMenuItemDetails(appetizer1);
        displayMenuItemDetails(mainCourse1);
        displayMenuItemDetails(dessert1);
        displayMenuItemDetails(beverage1);

        // Create an order
        Order customerOrder = new Order();
        customerOrder.addItem(appetizer1);
        customerOrder.addItem(mainCourse1);
        customerOrder.addItem(beverage1);

        // Display the customer's order
        customerOrder.displayOrder();
    }

    // Display details of a menu item
    private static void displayMenuItemDetails(MenuItem item) {
        System.out.println(item.getItemName() + " (" + item.getCategory() + "): $" + item.getPrice());
    }
}
