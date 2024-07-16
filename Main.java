import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Book {
    public String title, author;
    public int bookId, copiesAvailable,totalCopies;
    public boolean isBorrowed = false;



    public int borrowed;

    public void borrowBook() {
        if (copiesAvailable > 0) {
            this.copiesAvailable--;
            if (this.copiesAvailable == 0) {
                this.isBorrowed = true;
            }
        }
    }

    public void returnBook() {
        this.copiesAvailable++;
        if (this.copiesAvailable > 0) {
            this.isBorrowed = false;
        }
    }

    public boolean isAvailable() {
        return copiesAvailable > 0;
    }

    public Book(String title, String author, int bookId, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.bookId = bookId;
        this.copiesAvailable = copiesAvailable;
        this.totalCopies = copiesAvailable;
    }
}

class Library {
    ArrayList<Book> books;
    private HashMap<Integer, Integer> borrowedBooks;

    public Library() {
        books = new ArrayList<>();
        borrowedBooks = new HashMap<>();
    }

    public void addBook(String title, String author, int bookId, int copiesAvailable) {
        books.add(new Book(title, author, bookId, copiesAvailable));
    }

    public void displayBooks() {
        System.out.println("Books Available currently:");
        if (books.isEmpty()){
            System.out.println("There are no books currently in the lab Please add some books to access them!");
        }
        for (Book book : books) {
            String status = book.isAvailable() ? "Available (" + book.copiesAvailable + " copies)" : "All copies Borrowed (Not Available)";
            System.out.println("Title: "+book.title +" by "+book.author + " Status: " + status);
        }
    }

    public void removeBook(int bookId) {

        boolean isRemoved = books.removeIf(book -> book.bookId == bookId && book.copiesAvailable == book.totalCopies);
        if(isRemoved){
            System.out.println("Book removed successfully!!");
        }
        else {
            System.out.println("Book cannot be removed from library as some of its copies are borrowed");
        }

    }

    public void borrowBook(int bookId) {
        for (Book book : books) {
            if (book.bookId == bookId && book.isAvailable()) {
                book.borrowBook();
                borrowedBooks.put(bookId, 0);
                System.out.println("Book borrowed successfully!");
                return;
            }
        }
        System.out.println("Book you are trying to borrow is not available");
    }

    public void returnBook(int bookId, int returnedOn) {
        int returnPeriod = 10;
        int fineAmount = 3;



        for (Book book : books) {
            if (book.bookId == bookId) {
                if (book.copiesAvailable == book.totalCopies){
                    System.out.println("Cannot return book is not borrowed");
                    return;
                }

                if (returnedOn <= returnPeriod) {
                    System.out.println("Book returned on time, no fine issued!");
                } else {
                    int extra = returnedOn - returnPeriod;
                    int fine = extra * fineAmount;
                    System.out.println("Book returned after " + extra + " days. Fine of $ " + fine + " is issued!");
                }

                book.returnBook();
//                borrowedBooks.remove(bookId);
                System.out.println("Book returned successfully!");
                return;
            }

        }


    }
}

public class Main {
    public static void main(String[] args) {
        Library library = new Library();



        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System:");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. List Books");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String titleToAdd = scanner.nextLine();
                    System.out.println("Enter Author name: ");
                    String author = scanner.nextLine();
                    System.out.println("Enter book ID (UNIQUE: )");
                    int bookId = scanner.nextInt();
                    System.out.println("Enter number of copies available: ");
                    int copies = scanner.nextInt();
                    library.addBook(titleToAdd,author,bookId,copies);
                    break;
                case 2:
                    System.out.print("Enter book Id : ");
                    int bookIdRemove = scanner.nextInt();
                    library.removeBook(bookIdRemove);
                    break;
                case 3:
                    System.out.print("Enter book Id: ");
                    int idToBorrow = scanner.nextInt();
                    library.borrowBook(idToBorrow);
                    break;
                case 4:
                    System.out.print("Enter book id: ");
                    int returnid = scanner.nextInt();
                    System.out.print("Enter the day on which the book is being returned: ");
                    int returnDay = scanner.nextInt();
                    library.returnBook(returnid, returnDay);
                    break;
                case 5:
                    library.displayBooks();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
