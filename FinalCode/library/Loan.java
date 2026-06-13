import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Loan {
    private static int nextId = 1;
    private int loanId;
    private Book book;
    private Member member;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private boolean active;
    
    public Loan(Book book, Member member, LocalDate borrowDate, LocalDate dueDate) {
        this.loanId = nextId++;
        this.book = book;
        this.member = member;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.active = true;
        
        book.setAvailable(false);
        book.setActiveLoan(this);
        member.addLoan(this);
    }
    
    public int getLoanId() { return loanId; }
    public Book getBook() { return book; }
    public Member getMember() { return member; }
    public LocalDate getBorrowDate() { return borrowDate; }
    public LocalDate getDueDate() { return dueDate; }
    public boolean isActive() { return active; }
    
    public void closeLoan() {
        this.active = false;
        book.setAvailable(true);
        book.setActiveLoan(null);
        member.removeLoan(this);
    }
    
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("Loan[ID=%d, Book='%s', Member='%s', Due=%s]",
                loanId, book.getTitle(), member.getName(), dueDate.format(formatter));
    }
}