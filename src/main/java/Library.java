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
}
