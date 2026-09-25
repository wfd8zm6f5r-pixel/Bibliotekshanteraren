import java.util.Locale;

public class Library {
    private Book[] books = new Book[100];
    private Member[] members = new Member[100];
    private Member[] borrowedBy = new Member[100];

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
            System.out.println("Library is full!");
            return false;
        }
  }

  public boolean addMember(Member member) {
        if (memberCount < members.length) {
            members[memberCount] = member;
            memberCount++;
            return true;
        } else {
            System.out.println("Member list full!");
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
            System.out.println("Book not found!");
            return false;
        }
        Member member = findMemberById(memberId);
        if (member == null) {
            System.out.println("Member not found!");
            return false;
        }
        if (!member.canBorrowMore()) {
            System.out.println("Member cannot borrow more books!");
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
            System.out.println("Book is already borrowed!");
            return false;
        }
        borrowedBy[bookIndex] = member;
        member.setActiveLoans(member.getActiveLoans() + 1);
        return true;
    }
    public boolean returnBook(String isbn, int memberId) {
        Book book = findBookByIsbn(isbn);
        if (book == null) {
            System.out.println("Book not found!");
            return false;
        }
        Member member = findMemberById(memberId);
        if (member == null) {
            System.out.println("Member not found!");
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
            System.out.println("This book is not borrowed by this member!");
            return false;
        }
        borrowedBy[bookIndex] = null;
        member.setActiveLoans(member.getActiveLoans() -1);
        return true;
    }

    public void searchBooks(String searchTerm) {
        String lowerSearch = searchTerm.toLowerCase();
        for (int i = 0; i < bookCount; i++) {
            Book book = books[i];
            String title = book.title().toLowerCase();
            String author = book.author().toLowerCase();
            if (title.contains(lowerSearch) || author.contains(lowerSearch)) {
                System.out.println(book);
            }
        }
    }

    public void showAllBooks() {
        for (int i = 0; i < bookCount; i++) {
            Book book = books[i];
            Member borrower = borrowedBy[i];
            if (borrower == null) {
                System.out.println(book + " - Available");
            } else {
                System.out.println(book + " - BorrowedBy:" + borrower.getName());
            }
        }
    }
}
