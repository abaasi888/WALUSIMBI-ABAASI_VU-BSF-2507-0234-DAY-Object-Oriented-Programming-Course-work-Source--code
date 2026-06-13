public class LibraryDemo {
    public static void main(String[] args) {
        Library library = new Library();
        
        System.out.println("=== CREATING BOOKS ===");
        Book book1 = new Book("978-0134685991", "Effective Java", "Joshua Bloch");
        Book book2 = new Book("978-0596009205", "Head First Java", "Kathy Sierra");
        Book book3 = new Book("978-1617291999", "Java: The Complete Reference", "Herbert Schildt");
        
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        
        System.out.println("\n=== REGISTERING MEMBERS ===");
        Member member1 = new Member("M001", "Alice");
        Member member2 = new Member("M002", "Bob");
        
        library.registerMember(member1);
        library.registerMember(member2);
        
        library.displayState();
        
        System.out.println("=== LENDING OPERATIONS ===");
        library.lendBook("978-0134685991", "M001");
        library.lendBook("978-0596009205", "M002");
        
        library.displayState();
        
        System.out.println("=== BUSINESS RULE: ATTEMPT TO LEND ALREADY BORROWED BOOK ===");
        library.lendBook("978-0134685991", "M002");
        
        System.out.println("\n=== RETURNING A BOOK ===");
        library.returnBook("978-0134685991");
        
        library.displayState();
        
        System.out.println("=== SEARCH EXAMPLE ===");
        System.out.println("Search for 'Java':");
        for (Book b : library.searchByTitle("Java")) {
            System.out.println("  Found: " + b.getTitle());
        }
    }
}