package src.Liberry;

import java.util.*;

/**
 * Write a description of class Liberry here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Liberry{
    public static void main(String[] args) {
        Book book1 = new Book("Book 1", "author 1");
        Book book2 = new Book("Book 2", "author 2");
        Book book3 = new Book("Book 3", "author 3");
        Book book4 = new Book("Book 4", "author 4");

        List<Book> inventory = new ArrayList<>();
        inventory.add(book1);
        inventory.add(book2);
        inventory.add(book3);
        inventory.add(book4);



        Patron john = new Patron("john");
        System.out.println(john);

        System.out.println("---- Check out a book! -----");
        attemptBorrow(john, john.borrow(book1.getTitle(), inventory));

        System.out.println("---- Check out a book! -----");
        attemptBorrow(john, john.borrow(book2.getTitle(), inventory));

        System.out.println("---- Check out a book! -----");
        attemptBorrow(john, john.borrow(book3.getTitle(), inventory));

        System.out.println("---- Check out a book! -----");
        attemptBorrow(john, john.borrow(book4.getTitle(), inventory));

        System.out.println("---- Return " + book1 + "! -----");
        attemptReturn(john, john.returnBook(book1.getTitle(), inventory));

        System.out.println("---- Return " + book1 + "! -----");
        attemptReturn(john, john.returnBook(book1.getTitle(), inventory));

        System.out.println("---- Return " + book3 + "! -----");
        attemptReturn(john, john.returnBook(book3.getTitle(), inventory));

        System.out.println("---- Return " + book2 + "! -----");
        attemptReturn(john, john.returnBook(book2.getTitle(), inventory));
    }

    public static void attemptBorrow(Patron patron, boolean success){
        if(success){
            System.out.println(patron);
        } else {
            System.out.println("You have reached your book limit");
        }
    }

    public static void attemptReturn(Patron patron, boolean success){
        if(success){
            System.out.println(patron);
        } else {
            System.out.println("You dont have that book.");
        }
    }
}
