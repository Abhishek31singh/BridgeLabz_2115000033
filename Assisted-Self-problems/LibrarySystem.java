import java.util.*;
class Book {
    private String title;
    private String author;
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    @Override
    public String toString() {
        return "Book{" + "title='" + title + '\'' + ", author='" + author + '\'' + '}';
    }
}

class Library {
    private String name;
    private Book[] books;
    private int bookCount;

    public Library(String name, int capacity) {
        this.name = name;
        this.books = new Book[capacity];
        this.bookCount = 0;
    }

    public void addBook(Book book) {
        if (bookCount < books.length) {
            books[bookCount++] = book;
        } else {
            System.out.println("Library is full, cannot add more books.");
        }
    }

    public void displayBooks() {
        System.out.println("Library: " + name);
        for (int i = 0; i < bookCount; i++) {
            System.out.println(books[i]);
        }
    }
}
public class LibrarySystem {
    public static void main(String[] args) {
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee");
        Book book3 = new Book("1984", "George Orwell");
        Library library1 = new Library("Central Library", 5);
        Library library2 = new Library("Community Library", 5);
        library1.addBook(book1);
        library1.addBook(book2);
        library2.addBook(book2);
        library2.addBook(book3);
        library1.displayBooks();
        System.out.println();
        library2.displayBooks();
    }
}
