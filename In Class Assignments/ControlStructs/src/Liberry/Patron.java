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
    private ArrayList<Book> books = new ArrayList<Book>(); // make a list of the books the patron has out

    public Patron(String name){
        this.name = name;
        books.add(null); books.add(null); books.add(null); // 3 slots empty.
    }


    public boolean borrow(String title, List<Book> inventory){
        if (title == null || inventory == null) return false; // if the title is empty, or the inventory is empty, it fails.

        int openSlot = -1; // -1 means no open slot.
        for (int i = 0; i < 3; i++) {
            if (books.get(i) == null) { openSlot = i; break; } // if there is an empty slot, set openSlot equal to its index and get out of the loop.
        }
        if (openSlot == -1) return false; // if there STILL isnt any empty slots, return false.

        for (int i = 0; i < inventory.size(); i++) { // go through the inventory and check to see if any of the titles match what is being requested.
            Book b = inventory.get(i); // get the candidate book
            if (b != null && title.equals(b.getTitle())) {  // if its not empty and its title matches, put it in the books taken out array.
                books.set(openSlot, b);
                inventory.remove(i); // checked out from library
                return true;
            }
        }
        return false; // not in inventory
    }

    public boolean returnBook(String title, List<Book> inventory){
        if (title == null) return false;

        for (int i = 0; i < 3; i++) {
            Book b = books.get(i);
            if (b != null && title.equals(b.getTitle())) {
                books.set(i, null);
                inventory.add(b); // put it back into the library
                return true;
            }
        }
        return false;
    }

    public String toString(){
        String returner = "";
        returner += "Patron: " + name;
        for(int i = 0; i < 3; i++){
            String slot = (books.get(i) == null) ? "empty" : books.get(i).toString();
            returner += "\n Book " + (i+1) + " : " + slot;
        }
        return returner;
    }
}
