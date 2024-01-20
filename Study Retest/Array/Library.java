//Library.java
class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    //Complete the method to display the details of the book
    public void displayBookDetails() {
        System.out.println(title + " by " + author);
        
    }
}

public class Library {
    public static void main(String[] args) {
        
        // Create an array of three objects from the Book Class
        Book[] books = new Book[3];

        // Populate the array defined above with Book Objects
        books[0] = new Book("Effective Java", "Joshua Bloch");
        books[1] = new Book("Java Concurrency in Practice", "Brian Goetz");
        books[2] = new Book("Thinking in Java", "Bruce Eckel");

        // Display the details of each Book Object in the array
        for (Book book : books) {
            book.displayBookDetails();//System.out.println();  // Add a blank line between books for better readability
        }
    }
}
