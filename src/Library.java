import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

public class Library {

    public static HashMap<Book, Boolean> library = new HashMap<>();

    Library() {
        Book b1 = new Book(1, "\"Harry Potter\"", WhereRead.HOME);
        Book b2 = new Book(2, "\"Lord of Rings\"", WhereRead.HOME);
        Book b3 = new Book(3, "\"Hobbit\"", WhereRead.LIBRARY);
        Book b4 = new Book(4, "\"Think Java\"",WhereRead.LIBRARY);
        Book b5 = new Book(5, "\"ORACLE Doc.\"", WhereRead.HOME);
        library.put(b1, true);
        library.put(b2, true);
        library.put(b3, true);
        library.put(b4, true);
        library.put(b5, true);
    }

    public synchronized Book takeBooks(Reader reader) throws InterruptedException {
        Book book = choiceBook();
        while (!library.get(book)) {
            try {
                System.out.println(reader.getNameReader() + " ждет книгу " + book.getNameBook() + " "
                        +  Thread.currentThread().getName());
                wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        library.replace(book, true, false);
        System.out.println(reader.getNameReader() + " берет и читает книгу " + book.getNameBook() + " "
                + book.getWhereRead().getWhere() + " "
                +  Thread.currentThread().getName());
        notify();
        return book;
    }

    public synchronized void returnBook(Reader reader, Book book) {
        library.replace(book, false, true);
        System.out.println(reader.getNameReader() + " вернул(а) книгу " + book.getNameBook() + " "
                +  Thread.currentThread().getName());
        notify();
    }

    private int randomBook() {
        return (int) (Math.random() * 5) + 1;
    }

    public Book choiceBook() {
        int numberBook = randomBook();
        AtomicReference<Book> book = new AtomicReference<>(new Book());
        library.forEach((k, v) -> {
            if (numberBook == k.getId()) {
                book.set(k);
            }
        });
        return book.get();
    }
}
