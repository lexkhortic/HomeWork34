public class Book {

    private int id;
    private String nameBook;
    private WhereRead whereRead;

    public Book() {
    }

    Book(int id, String nameBook, WhereRead whereRead) {
        this.id = id;
        this.nameBook = nameBook;
        this.whereRead = whereRead;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public WhereRead getWhereRead() {
        return whereRead;
    }

    public void setWhereRead(WhereRead whereRead) {
        this.whereRead = whereRead;
    }
}
