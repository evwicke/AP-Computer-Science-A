package src;


/**
 * Write a description of class newPanel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import javax.swing.*; // for jpanels and jframes
import java.awt.*; // for colors and containers

public class newPanel
{
    /*
     * Making a constructor, Used in OOP. Need this when you create your own class.
     * It basically initializes the object when it is created in the main method or the driver class.
     */
    public newPanel(Color myColor){

        this.setBackground(myColor);
        
        
    }
   public void paintComponent(Graphics g){
       /*
        * Has methods built in to draw inside a panel, run when the object is created or refreshed from the driver class.
        * 
        */
       super.paintComponent(g); //super calls the parent's version of the built in paintComponent method.
       
       
    }
    
    
}
