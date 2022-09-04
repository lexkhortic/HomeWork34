import java.util.ArrayList;

public class Reader extends Thread {

    private String nameReader;
    private ArrayList<Book> books;
    private Library library;

    @Override
    public void run() {
        try {
            Book book = library.takeBooks(this);
            sleep(5000);
            library.returnBook(this, book);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Reader(String nameReader, Library library) {
        this.nameReader = nameReader;
        this.library = library;
    }

    public Reader(String nameReader, ArrayList<Book> books) {
        this.nameReader = nameReader;
        this.books = books;
    }

    public String getNameReader() {
        return nameReader;
    }

    public void setNameReader(String nameReader) {
        this.nameReader = nameReader;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public void setOneBook(Book book) {
        books.add(book);
    }
}
