package src.Liberry;


/**
 * Write a description of class Book here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Book{
    
    private String title;
    private String author;
    
    public Book(String title, String author){
        this.title = title;
        this.author = author;
    }
    
    public String getTitle(){
        return title;
    }
    
    public String toString(){
        return title + " by " + author;
    }
}
