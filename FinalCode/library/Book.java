public class Book {
    private String isbn;
    private String title;
    private String author;
    private boolean available;
    private Loan activeLoan;
    
    public Book(String isbn, String title) {
        this(isbn, title, "Unknown Author");
    }
    
    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.available = true;
        this.activeLoan = null;
    }
    
    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
    public Loan getActiveLoan() { return activeLoan; }
    public void setActiveLoan(Loan activeLoan) { this.activeLoan = activeLoan; }
    
    @Override
    public String toString() {
        return String.format("Book[ISBN=%s, Title='%s', Author='%s', Available=%s]",
                isbn, title, author, available);
    }
}