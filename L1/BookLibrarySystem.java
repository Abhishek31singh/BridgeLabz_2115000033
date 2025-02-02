class Book{
    public String isbn;
    protected String title;
    private String author;

    Book(String isbn, String title, String author){
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }
    public String getAuthor(){
        return author;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public void displayBookDetails(){
        System.out.println("EBook ISBN: "+isbn);
        System.out.println("TItle: "+title);
        System.out.println("Auhtor: "+author);
    }
}
class EBook extends Book{
    public EBook(String isbn, String title, String author){
        super(isbn, title, author);
    }
    public void displayEBookDetails(){
        System.out.println("EBook ISBN: "+isbn);
        System.out.println("TItle: "+title);
    }
}
public class BookLibrarySystem{
    public static void main(String[] args) {
        Book book = new Book("123-456-789", "can we strangers again?", "John Doe");
        System.out.println("------Book details------");
        book.displayBookDetails();
        System.out.println("Author name: "+book.getAuthor());
        book.setAuthor("Prabhat");
        System.out.println("Author Changed to: "+book.getAuthor());
        EBook ebook = new EBook("987-654-321", "Merchant of Venice", "William Shakespear");
        System.out.println("--------EBook Details---------");
        ebook.displayEBookDetails();
    }
}