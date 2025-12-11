package src.Liberry;


/**
 * Write a description of class Liberry here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Liberry{
    Book book1 = new Book("Book 11", "author 11");
    Book book1 = new Book("Book 12", "author 12");
    Book book1 = new Book("Book 13", "author 13");
    
    Patron john = new Patron(john);
    System.out.println(john);
    
    Patron.borrow(book1);
    Patron.borrow(book2);
    System.out.println(john);
}
