//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Scanner;
//
//class Book {
//    public String title, author;
//    public int bookId, copiesAvailable,totalCopies;
//    public boolean isBorrowed = false;
//
//
//
//    public int borrowed;
//
//    public void borrowBook() {
//        if (copiesAvailable > 0) {
//            this.copiesAvailable--;
//            if (this.copiesAvailable == 0) {
//                this.isBorrowed = true;
//            }
//        }
//    }
//
//    public void returnBook() {
//        this.copiesAvailable++;
//        if (this.copiesAvailable > 0) {
//            this.isBorrowed = false;
//        }
//    }
//
//    public boolean isAvailable() {
//        return copiesAvailable > 0;
//    }
//
//    public Book(String title, String author, int bookId, int copiesAvailable) {
//        this.title = title;
//        this.author = author;
//        this.bookId = bookId;
//        this.copiesAvailable = copiesAvailable;
//        this.totalCopies = copiesAvailable;
//    }
//}
//
//class Library {
//    ArrayList<Book> books;
//    private HashMap<Integer, Integer> borrowedBooks;
//
//    public Library() {
//        books = new ArrayList<>();
//        borrowedBooks = new HashMap<>();
//    }
//
//    public void addBook(String title, String author, int bookId, int copiesAvailable) {
//        books.add(new Book(title, author, bookId, copiesAvailable));
//    }
//
//    public void displayBooks() {
//        System.out.println("Books Available currently:");
//        if (books.isEmpty()){
//            System.out.println("There are no books currently in the lab Please add some books to access them!");
//        }
//        for (Book book : books) {
//            String status = book.isAvailable() ? "Available (" + book.copiesAvailable + " copies)" : "All copies Borrowed (Not Available)";
//            System.out.println("Title: "+book.title +" by "+book.author + " Status: " + status);
//        }
//    }
//
//    public void removeBook(int bookId) {
//
//        boolean isRemoved = books.removeIf(book -> book.bookId == bookId && book.copiesAvailable == book.totalCopies);
//        if(isRemoved){
//            System.out.println("Book removed successfully!!");
//        }
//        else {
//            System.out.println("Book cannot be removed from library as some of its copies are borrowed");
//        }
//
//    }
//
//    public void borrowBook(int bookId) {
//        for (Book book : books) {
//            if (book.bookId == bookId && book.isAvailable()) {
//                book.borrowBook();
//                borrowedBooks.put(bookId, 0);
//                System.out.println("Book borrowed successfully!");
//                return;
//            }
//        }
//        System.out.println("Book you are trying to borrow is not available");
//    }
//
//    public void returnBook(int bookId, int returnedOn) {
//        int returnPeriod = 10;
//        int fineAmount = 3;
//
//
//
//        for (Book book : books) {
//            if (book.bookId == bookId) {
//                if (book.copiesAvailable == book.totalCopies){
//                    System.out.println("Cannot return book is not borrowed");
//                    return;
//                }
//
//                if (returnedOn <= returnPeriod) {
//                    System.out.println("Book returned on time, no fine issued!");
//                } else {
//                    int extra = returnedOn - returnPeriod;
//                    int fine = extra * fineAmount;
//                    System.out.println("Book returned after " + extra + " days. Fine of $ " + fine + " is issued!");
//                }
//
//                book.returnBook();
////                borrowedBooks.remove(bookId);
//                System.out.println("Book returned successfully!");
//                return;
//            }
//
//        }
//
//
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        Library library = new Library();
//
//
//
//        Scanner scanner = new Scanner(System.in);
//
//        while (true) {
//            System.out.println("\nLibrary Management System:");
//            System.out.println("1. Add Book");
//            System.out.println("2. Remove Book");
//            System.out.println("3. Borrow Book");
//            System.out.println("4. Return Book");
//            System.out.println("5. List Books");
//            System.out.println("6. Exit");
//            System.out.print("Choose an option: ");
//
//            int choice = scanner.nextInt();
//            scanner.nextLine();  // Consume newline
//
//            switch (choice) {
//                case 1:
//                    System.out.print("Enter book title: ");
//                    String titleToAdd = scanner.nextLine();
//                    System.out.println("Enter Author name: ");
//                    String author = scanner.nextLine();
//                    System.out.println("Enter book ID (UNIQUE: )");
//                    int bookId = scanner.nextInt();
//                    System.out.println("Enter number of copies available: ");
//                    int copies = scanner.nextInt();
//                    library.addBook(titleToAdd,author,bookId,copies);
//                    break;
//                case 2:
//                    System.out.print("Enter book Id : ");
//                    int bookIdRemove = scanner.nextInt();
//                    library.removeBook(bookIdRemove);
//                    break;
//                case 3:
//                    System.out.print("Enter book Id: ");
//                    int idToBorrow = scanner.nextInt();
//                    library.borrowBook(idToBorrow);
//                    break;
//                case 4:
//                    System.out.print("Enter book id: ");
//                    int returnid = scanner.nextInt();
//                    System.out.print("Enter the day on which the book is being returned: ");
//                    int returnDay = scanner.nextInt();
//                    library.returnBook(returnid, returnDay);
//                    break;
//                case 5:
//                    library.displayBooks();
//                    break;
//                case 6:
//                    System.out.println("Exiting...");
//                    scanner.close();
//                    return;
//                default:
//                    System.out.println("Invalid choice. Try again.");
//            }
//        }
//    }
//}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

class Book {
    public String title, author;
    public int bookId, copiesAvailable, totalCopies;
    public boolean isBorrowed = false;

    public Book(String title, String author, int bookId, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.bookId = bookId;
        this.copiesAvailable = copiesAvailable;
        this.totalCopies = copiesAvailable;
    }

    public void borrowBook() {
        if (copiesAvailable > 0) {
            copiesAvailable--;
            if (copiesAvailable == 0) {
                isBorrowed = true;
            }
        }
    }

    public void returnBook() {
        copiesAvailable++;
        if (copiesAvailable > 0) {
            isBorrowed = false;
        }
    }

    public boolean isAvailable() {
        return copiesAvailable > 0;
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

    public String displayBooks() {
        StringBuilder booksInfo = new StringBuilder("Books Available currently:\n");
        if (books.isEmpty()) {
            booksInfo.append("There are no books currently in the library. Please add some books to access them!\n");
        } else {
            for (Book book : books) {
                String status = book.isAvailable() ? "Available (" + book.copiesAvailable + " copies)" : "All copies Borrowed (Not Available)";
                booksInfo.append("Title: ").append(book.title).append(" by ").append(book.author).append(" Status: ").append(status).append("\n");
            }
        }
        return booksInfo.toString();
    }

    public boolean removeBook(int bookId) {
        return books.removeIf(book -> book.bookId == bookId && book.copiesAvailable == book.totalCopies);
    }

    public boolean borrowBook(int bookId) {
        for (Book book : books) {
            if (book.bookId == bookId && book.isAvailable()) {
                book.borrowBook();
                borrowedBooks.put(bookId, 0);
                return true;
            }
        }
        return false;
    }

    public String returnBook(int bookId, int returnedOn) {
        int returnPeriod = 10;
        int fineAmount = 3;

        for (Book book : books) {
            if (book.bookId == bookId) {
                if (book.copiesAvailable == book.totalCopies) {
                    return "Cannot return book. It is not borrowed.";
                }
                String message;
                if (returnedOn <= returnPeriod) {
                    message = "Book returned on time, no fine issued!";
                } else {
                    int extra = returnedOn - returnPeriod;
                    int fine = extra * fineAmount;
                    message = "Book returned after " + extra + " days. Fine of $" + fine + " is issued!";
                }
                book.returnBook();
                return message + "\nBook returned successfully!";
            }
        }
        return "Book not found!";
    }
}

public class Main {
    private Library library;
    private JFrame frame;
    private JPanel mainPanel;
    private CardLayout cardLayout;

    public Main() {
        library = new Library();
        frame = new JFrame("Library Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Add all pages to the main panel
        mainPanel.add(createHomePage(), "Home");
        mainPanel.add(createAddBookPage(), "Add Book");
        mainPanel.add(createRemoveBookPage(), "Remove Book");
        mainPanel.add(createBorrowBookPage(), "Borrow Book");
        mainPanel.add(createReturnBookPage(), "Return Book");
        mainPanel.add(createListBooksPage(), "List Books");

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    private JPanel createHomePage() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));
        JLabel label = new JLabel("Library Management System", SwingConstants.CENTER);
        panel.add(label);

        JButton addBookButton = new JButton("Add Book");
        addBookButton.addActionListener(e -> cardLayout.show(mainPanel, "Add Book"));
        panel.add(addBookButton);

        JButton removeBookButton = new JButton("Remove Book");
        removeBookButton.addActionListener(e -> cardLayout.show(mainPanel, "Remove Book"));
        panel.add(removeBookButton);

        JButton borrowBookButton = new JButton("Borrow Book");
        borrowBookButton.addActionListener(e -> cardLayout.show(mainPanel, "Borrow Book"));
        panel.add(borrowBookButton);

        JButton returnBookButton = new JButton("Return Book");
        returnBookButton.addActionListener(e -> cardLayout.show(mainPanel, "Return Book"));
        panel.add(returnBookButton);

        JButton listBooksButton = new JButton("List Books");
        listBooksButton.addActionListener(e -> cardLayout.show(mainPanel, "List Books"));
        panel.add(listBooksButton);

        return panel;
    }

    private JPanel createAddBookPage() {
        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.add(new JLabel("Book Title:"));
        JTextField titleField = new JTextField();
        panel.add(titleField);

        panel.add(new JLabel("Author:"));
        JTextField authorField = new JTextField();
        panel.add(authorField);

        panel.add(new JLabel("Book ID:"));
        JTextField bookIdField = new JTextField();
        panel.add(bookIdField);

        panel.add(new JLabel("Copies:"));
        JTextField copiesField = new JTextField();
        panel.add(copiesField);

        JButton addButton = new JButton("Add Book");
        addButton.addActionListener(e -> {
            String title = titleField.getText();
            String author = authorField.getText();
            int bookId = Integer.parseInt(bookIdField.getText());
            int copies = Integer.parseInt(copiesField.getText());
            library.addBook(title, author, bookId, copies);
            titleField.setText("");
            authorField.setText("");
            bookIdField.setText("");
            copiesField.setText("");
            JOptionPane.showMessageDialog(frame, "Book added successfully!");
            cardLayout.show(mainPanel, "Home");
        });
        panel.add(addButton);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Home"));
        panel.add(backButton);

        return panel;
    }

    private JPanel createRemoveBookPage() {
        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Book ID:"));
        JTextField bookIdField = new JTextField();
        panel.add(bookIdField);

        JButton removeButton = new JButton("Remove Book");
        removeButton.addActionListener(e -> {
            int bookId = Integer.parseInt(bookIdField.getText());
            boolean isRemoved = library.removeBook(bookId);
            if (isRemoved) {
                JOptionPane.showMessageDialog(frame, "Book removed successfully!");
            } else {
                JOptionPane.showMessageDialog(frame, "Book cannot be removed as some copies are borrowed.");
            }
            bookIdField.setText("");
            cardLayout.show(mainPanel, "Home");
        });
        panel.add(removeButton);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Home"));
        panel.add(backButton);

        return panel;
    }

    private JPanel createBorrowBookPage() {
        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Book ID:"));
        JTextField bookIdField = new JTextField();
        panel.add(bookIdField);

        JButton borrowButton = new JButton("Borrow Book");
        borrowButton.addActionListener(e -> {
            int bookId = Integer.parseInt(bookIdField.getText());
            boolean isBorrowed = library.borrowBook(bookId);
            if (isBorrowed) {
                JOptionPane.showMessageDialog(frame, "Book borrowed successfully!");
            } else {
                JOptionPane.showMessageDialog(frame, "Book is not available for borrowing.");
            }
            bookIdField.setText("");
            cardLayout.show(mainPanel, "Home");
        });
        panel.add(borrowButton);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Home"));
        panel.add(backButton);

        return panel;
    }

    private JPanel createReturnBookPage() {
        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(new JLabel("Book ID:"));
        JTextField bookIdField = new JTextField();
        panel.add(bookIdField);

        panel.add(new JLabel("Return Day:"));
        JTextField returnDayField = new JTextField();
        panel.add(returnDayField);

        JButton returnButton = new JButton("Return Book");
        returnButton.addActionListener(e -> {
            int bookId = Integer.parseInt(bookIdField.getText());
            int returnDay = Integer.parseInt(returnDayField.getText());
            String message = library.returnBook(bookId, returnDay);
            JOptionPane.showMessageDialog(frame, message);
            bookIdField.setText("");
            returnDayField.setText("");
            cardLayout.show(mainPanel, "Home");
        });
        panel.add(returnButton);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Home"));
        panel.add(backButton);

        return panel;
    }

    private JPanel createListBooksPage() {
        JPanel panel = new JPanel(new BorderLayout());
        JTextArea displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        JButton listButton = new JButton("List Books");
        listButton.addActionListener(e -> displayArea.setText(library.displayBooks()));
        panel.add(listButton, BorderLayout.NORTH);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Home"));
        panel.add(backButton, BorderLayout.SOUTH);

        return panel;
    }

    public static void main(String[] args) {
        new Main();
    }
}
