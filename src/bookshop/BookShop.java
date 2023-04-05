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
 * @author f
 */
public class BookShop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("----Main Menu----");
            System.out.println("1- Display all book");
            System.out.println("2- Add Book");
            System.out.println("3- Update Book book");
            System.out.println("4- Delete book");
            System.out.println("5- Search book");
            System.out.println("6- Exit");
            System.out.println("Enter your choise: ");
            int choiceNumber;
            try {
                choiceNumber = in.nextInt();
                switch (choiceNumber) {
                    case 1:
                        Book.displayAllBooks();
                        break;
                    case 2:
                        Book.addBooks(in);
                        break;
                    case 3:
                        Book.updateBooks(in);
                        break;
                    case 4:
                        Book.deleteBooks(in);
                        break;
                    case 5:
                       Book.search(in);
                        break;
                    case 6:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number");
                in.next();
            }

        }

    }

}
