import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books;
    private List<Member> members;
    private List<Loan> loans;
    
    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
        this.loans = new ArrayList<>();
    }
    
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Added: " + book.getTitle());
    }
    
    public void registerMember(Member member) {
        members.add(member);
        System.out.println("Registered: " + member.getName());
    }
    
    public boolean lendBook(String isbn, String memberId) {
        Book book = findBookByIsbn(isbn);
        if (book == null) {
            System.out.println("Error: Book not found.");
            return false;
        }
        
        // BUSINESS RULE: Book must be available
        if (!book.isAvailable()) {
            System.out.println("Error: Book '" + book.getTitle() + "' is already on loan.");
            return false;
        }
        
        Member member = findMemberById(memberId);
        if (member == null) {
            System.out.println("Error: Member not found.");
            return false;
        }
        
        LocalDate borrowDate = LocalDate.now();
        LocalDate dueDate = borrowDate.plusDays(30);
        Loan loan = new Loan(book, member, borrowDate, dueDate);
        loans.add(loan);
        
        System.out.println("Success: '" + book.getTitle() + "' lent to " + member.getName());
        return true;
    }
    
    public boolean returnBook(String isbn) {
        Book book = findBookByIsbn(isbn);
        if (book == null) {
            System.out.println("Error: Book not found.");
            return false;
        }
        
        if (book.isAvailable()) {
            System.out.println("Error: Book is not on loan.");
            return false;
        }
        
        Loan activeLoan = book.getActiveLoan();
        if (activeLoan != null) {
            activeLoan.closeLoan();
            System.out.println("Success: '" + book.getTitle() + "' returned.");
            return true;
        }
        
        return false;
    }
    
    public List<Book> searchByTitle(String title) {
        return books.stream()
                .filter(b -> b.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }
    
    private Book findBookByIsbn(String isbn) {
        return books.stream()
                .filter(b -> b.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
    }
    
    private Member findMemberById(String memberId) {
        return members.stream()
                .filter(m -> m.getMemberId().equals(memberId))
                .findFirst()
                .orElse(null);
    }
    
    public void displayState() {
        System.out.println("\n=== LIBRARY STATE ===");
        System.out.println("\n--- BOOKS ---");
        for (Book b : books) {
            System.out.println("  " + b);
        }
        System.out.println("\n--- MEMBERS ---");
        for (Member m : members) {
            System.out.println("  " + m);
        }
        System.out.println("\n--- ACTIVE LOANS ---");
        for (Loan l : loans) {
            if (l.isActive()) {
                System.out.println("  " + l);
            }
        }
        System.out.println("====================\n");
    }
}