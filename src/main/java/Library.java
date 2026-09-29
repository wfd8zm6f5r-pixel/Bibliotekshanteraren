public class Library {
    private Book[] books = new Book[10];
    private Member[] members = new Member[10];
    private Member[] borrowedBy = new Member[10];

    private int bookCount = 0;
    private int memberCount = 0;

    public Library() {
    }

  public boolean addBook(Book book) {
        if (bookCount < books.length) {
            books[bookCount] = book;
            bookCount++;
            return true;
        } else {
            System.out.println("Boklistan är full!");
            return false;
        }
  }

  public boolean addMember(Member member) {
        if (memberCount < members.length) {
            members[memberCount] = member;
            memberCount++;
            return true;
        } else {
            System.out.println("Medlemlistan är full!");
            return false;
        }
  }
    public Member findMemberById(int id) {
        for (int i = 0; i < memberCount; i++)
        if (members[i].getId() == id) {
            return members[i];
        }
        return null;
    }
    public Book findBookByIsbn(String isbn) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].isbn().equalsIgnoreCase(isbn)) {
                return books[i];
            }
        }
        return null;
    }
    public boolean borrowBook(String isbn, int memberId) {
        Book book = findBookByIsbn(isbn);
        if (book == null) {
            System.out.println("Boken hittades ej!");
            return false;
        }
        Member member = findMemberById(memberId);
        if (member == null) {
            System.out.println("Medlemmen hittades ej!");
            return false;
        }
        if (!member.canBorrowMore()) {
            System.out.println("Medlem kan inte låna fler böcker!");
            return false;
        }
        int bookIndex = -1;
        for (int i = 0; i < bookCount; i++) {
            if (books[i] == book) {
                bookIndex = i;
                break;
            }
        }
        if (borrowedBy[bookIndex] != null) {
            System.out.println("Boken är redan utlånad!");
            return false;
        }
        borrowedBy[bookIndex] = member;
        member.setActiveLoans(member.getActiveLoans() + 1);
        return true;
    }
    public boolean returnBook(String isbn, int memberId) {
        Book book = findBookByIsbn(isbn);
        if (book == null) {
            System.out.println("Boken hittades ej!");
            return false;
        }
        Member member = findMemberById(memberId);
        if (member == null) {
            System.out.println("Medlemmen hittades ej!");
            return false;
        }
        int bookIndex = -1;
        for (int i = 0; i < bookCount; i++) {
            if (books[i] == book) {
                bookIndex = i;
                break;
            }
        }
        if (borrowedBy[bookIndex] != member) {
            System.out.println("Den här boken är inte lånad av den här medlemmen!");
            return false;
        }
        borrowedBy[bookIndex] = null;
        member.setActiveLoans(member.getActiveLoans() -1);
        return true;
    }

    public void searchBooks(String searchTerm) {
        String lowerSearch = searchTerm.toLowerCase();
        boolean found = false;
        for (int i = 0; i < bookCount; i++) {
            Book book = books[i];
            String title = book.title().toLowerCase();
            String author = book.author().toLowerCase();
            if (title.contains(lowerSearch) || author.contains(lowerSearch)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Boken hittades ej!");
        }
    }

    public void showAllBooks() {
        for (int i = 0; i < bookCount; i++) {
            Book book = books[i];
            Member borrower = borrowedBy[i];
            if (borrower == null) {
                System.out.println(book + " - Tillgänglig");
            } else {
                System.out.println(book + " - Utlånad till: " + borrower.getName());
            }
        }
    }
}
