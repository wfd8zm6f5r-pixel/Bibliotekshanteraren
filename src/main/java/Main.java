import java.util.Scanner;
public class Main {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        boolean running = true;
        while (running) {
            System.out.println("\n=== Bibliotekshanteraren ===");
            System.out.println("i. Lägg till bok");
            System.out.println("2. Registrera medlem");
            System.out.println("3. Låna bok");
            System.out.println("4. Lämna tillbaka bok");
            System.out.println("5. Sök bok");
            System.out.println("6. Visa alla böcker");
            System.out.println("e. Avsulta");
            System.out.print("Välj ett alternativ: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.print("ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Titel: ");
                    String title = scanner.nextLine();
                    System.out.print("Författare: ");
                    String author = scanner.nextLine();
                    Book book = new Book(isbn, title, author);
                    library.addBook(book);
                    System.out.println("Boken har lagts till!");
                    break;

                case "2":
                    try {

                    System.out.print("Medlems-ID: ");
                    int memberId = Integer.parseInt(scanner.nextLine());
                    System.out.print("Namn: ");
                    String name = scanner.nextLine();
                    Member member = new Member(memberId, name);
                    library.addMember(member);
                    System.out.println("Medlem har registrerats!");
            }
                    catch (NumberFormatException e) {
                        System.out.println("Medlems-ID måste vara ett nummer!");
                    }
                break;

                case "3":
                    try {

                        System.out.print("ISBN: ");
                        String borrowIsbn = scanner.nextLine();
                        System.out.print("Medlems-ID: ");
                        int borrlowMemberId = Integer.parseInt(scanner.nextLine());
                        library.borrowBook(borrowIsbn, borrlowMemberId);
                    }
                    catch (NumberFormatException e) {
                        System.out.println("Medlems-ID måste vara ett nummer!");
                    }
                break;

                case "4":
                    try {

                        System.out.print("ISBN: ");
                        String returnIsbn = scanner.nextLine();
                        System.out.print("Medlems-ID: ");
                        int returnMemberId = Integer.parseInt(scanner.nextLine());
                        library.returnBook(returnIsbn, returnMemberId);
                    }
                    catch (NumberFormatException e) {
                        System.out.println("Medlems-ID måste vara ett nummer!");
                    }
                    break;

                case "5":
                    System.out.print("Tiel eller författare: ");
                    String searchTerm = scanner.nextLine();
                    library.searchBooks(searchTerm);
                    break;

                case "6":
                    library.showAllBooks();
                    break;

                case "e":
                    running = false;
                    break;

                default:
                    System.out.println("Ogiltigt val!");
                    break;
            }
        }
    }
}
