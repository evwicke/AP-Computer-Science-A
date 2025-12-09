package src.Astroknot;

/**
 * Write a description of class AstroknotClient here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AstroknotClient{
    public static void main(String[] args){
        Planet Earth = new Planet("Earth", 12756, 5.976e24);
        Planet Jupiter = new Planet("Jupiter", 139820, 1.898e27);
        

        Astronaut Bob = new Astronaut("Bob", 65, 10, Earth);
        System.out.println(Bob);
        System.out.println("  -------- Travel Planets --------  ");
        
        
        
    }
}
