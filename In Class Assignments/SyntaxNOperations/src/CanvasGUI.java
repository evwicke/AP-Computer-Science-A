package src;

/**
 * Write a description of class CanvasGUI here.
 *
 * @dlynch1
 * @version 9.23.24
 */
import javax.swing.*;
import java.awt.*;
public class CanvasGUI
{
    public static void Main()
    {
        JFrame theGUI2 = new JFrame();
        theGUI2.setSize(400,500);
        myPanel lynchy = new myPanel(Color.cyan);
        
        
        theGUI2.add(lynchy);
       
        theGUI2.setVisible(true);
    }
}