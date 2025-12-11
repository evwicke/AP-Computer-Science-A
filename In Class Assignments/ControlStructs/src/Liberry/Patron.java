package src.Liberry;

/**
 * Write a description of class Patron here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class Patron{

    private String name;
    private ArrayList<Book> books = new ArrayList<Book>();

    public Patron(String name){
        this.name = name;
        books.add(null);books.add(null);books.add(null); // set the first 3 books to null.

    }

    public boolean borrow(Book bookTaken){
        for(int i = 0; i<3; i++){
            if(books.get(i) == null) {
                books.set(i, bookTaken);
                return true;
            }
        }
        return false;
    }

    public boolean returnBook(Book bookReturning){
        for(int i = 0; i<3; i++){
            if(books.get(i).getTitle().equals(bookReturning.getTitle())) {
                books.set(i, null);
                return true;
            }
        }
        return false;
    }

    public String toString(){
        String returner = "";
        returner += "Patron: " + name;
        for(int i = 0; i<3; i++){
            returner += "\n Book "+(i+1)+" : " + books.get(i);
        }
        return returner;
    }
}
