/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookshop;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @HassanKoriam
 */
public class Book {

    static ArrayList<Book> BooksList = new ArrayList();
    private String name;
    private double price;
    private String author;

    Book() {

    }

    public Book(String name, double price, String author) {
        this.name = name;
        this.price = price;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public static void displayAllBooks() {
        ArrayList<Book> listBook = Book.BooksList;
        if (listBook.isEmpty()) {
            System.out.println("There is no data !!");
        } else {
            for (Book book : listBook) {
                System.out.println("Name        Price         Author");
                System.out.println(book.getName() + "         "
                        + book.getPrice()+ "          " 
                        + book.getAuthor());
            }
        }
    }

    public static void addBooks(Scanner in) {
        System.out.println("Enter The count of Books");
        int countBooks = in.nextInt();
        for (int i = 0; i < countBooks; i++) {
            System.out.println("Enter The name of Book " + (i + 1));
            String nameBook = in.next();
            System.out.println("Enter The author of Book " + (i + 1));
            String authorBook = in.next();
            System.out.println("Enter The price of Book " + (i + 1));
            double priceBook = in.nextDouble();
            Book b = new Book();
            b.setName(nameBook);
            b.setPrice(priceBook);
            b.setAuthor(authorBook);
            Book.BooksList.add(b);
        }
    }

    public static Book getBookByName(String name) {
        for (Book book : BooksList) {
            if (book.name.equals(name)) {
                return book;
            }
        }
        return null;
    }

    public static boolean updateBook(Book newBook, Book oldBook) {
        int index = -1;
        if (BooksList.size() > 0) {
            for (int i = 0; i < BooksList.size(); i++) {
                if (BooksList.get(i).getName().equals(oldBook.getName())) {
                    index = i;
                    break;
                }
            }
            if (index != -1) {
                BooksList.get(index).setName(newBook.getName());
                BooksList.get(index).setAuthor(newBook.getAuthor());
                BooksList.get(index).setPrice(newBook.getPrice());
                return true;
            }
        }

        return false;
    }

    public static boolean deleteBook(Book book) {
        int index = -1;
        if (BooksList.size() > 0) {
            BooksList.remove(book);
            return true;
        }
        return false;
    }

    public static void deleteBooks(Scanner in) {
        System.out.println("Enter your name of book: ");
        String nameBook = in.next();
        Book book = Book.getBookByName(nameBook);
        //You can use this to check the book exists or not 
        if (book == null) {
            System.out.println("No book found !!");
        } else {
            // deleteBook methon return boolean true or false
            if (Book.deleteBook(book)) {
                System.out.println("Deleted Succeessfuly");
            } else {
                System.out.println("Deleted fails ");
            }
        }

    }

    public static void updateBooks(Scanner in) {
        boolean isMenu = true;
        while (isMenu) {
            System.out.println("-----Update Menu-----");
            System.out.println("1- Update Book name");
            System.out.println("2- Update Book author");
            System.out.println("3- Update Book Price");
            System.out.println("4- Back to Menu");
            System.out.println("5- Exit Program ");
            System.out.println("Enter your choice: ");
            int choiceNum = in.nextInt();
            switch (choiceNum) {
                case 1:
                    System.out.println("Enter your name of book: ");
                    String nameBook = in.next();
                    Book oldBook = Book.getBookByName(nameBook);
                    Book newBook = Book.getBookByName(nameBook);
                    if (oldBook == null) {
                        System.out.println("No book with this name !");
                    } else {
                        System.out.println("Enter the new name : ");
                        String newNameBook = in.next();
                        newBook.setName(newNameBook);
                        if (Book.updateBook(newBook, oldBook)) {
                            System.out.println("Updated succeessfuly");
                        } else {
                            System.out.println("Updated fails");
                        }
                    }
                    break;
                case 2:
                    System.out.println("Enter your name of book: ");
                    String nameBook1 = in.next();
                    Book oldBook1 = Book.getBookByName(nameBook1);
                    Book newBook1 = Book.getBookByName(nameBook1);
                    if (oldBook1 == null) {
                        System.out.println("No book with this name !");
                    } else {
                        System.out.println("Enter the new author : ");
                        String newAuthorBook = in.next();
                        newBook1.setAuthor(newAuthorBook);
                        if (Book.updateBook(newBook1, oldBook1)) {
                            System.out.println("Updated succeessfuly");
                        } else {
                            System.out.println("Updated fails");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Enter your name of book: ");
                    String nameBook2 = in.next();
                    Book oldBook2 = Book.getBookByName(nameBook2);
                    Book newBook2 = Book.getBookByName(nameBook2);
                    if (oldBook2 == null) {
                        System.out.println("No book with this name !");
                    } else {
                        System.out.println("Enter the new price : ");
                        double newPriceBook = in.nextDouble();
                        newBook2.setPrice(newPriceBook);
                        if (Book.updateBook(newBook2, oldBook2)) {
                            System.out.println("Updated succeessfuly");
                        } else {
                            System.out.println("Updated fails");
                        }
                    }
                    break;
                case 4:
                    isMenu = false;
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }

    public static void search(Scanner in) {
        System.out.println("Enter the name of book");
        String nameBook = in.next();
        Book book = Book.getBookByName(nameBook);
        if (book == null) {
            System.out.println(nameBook + " isn't found !");
        } else {
            System.out.println("Name        Price         Author");
                System.out.println(book.getName() + "         "
                        + book.getPrice()+ "          " 
                        + book.getAuthor());
        }
    }
}
