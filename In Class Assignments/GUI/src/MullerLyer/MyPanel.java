package src.MullerLyer;

/*
 * Write a description of class LynchPaznel here.
 *
 * @dlynch1
 * @version 9.23.24
 */
import javax.swing.*; //JFrame and JPanel
import java.awt.*; //color and containers
public class MyPanel extends JPanel //isA relationship
//"extends" gets all public methods from a JPanel
{
    public MyPanel(Color myColor){
        this.setBackground(myColor); //"this" means is a relationship
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        int x = getWidth();
        int y = getHeight();
        
        Graphics2D gT = (Graphics2D)g;
        gT.setStroke(new BasicStroke(7.0f)); //"f" is for float
        gT.setPaint(Color.BLACK);
        
        gT.drawLine((int)(x*.05), getHeight()/2, (int)(x*.30), getHeight()/2);
        
        
       
    }
}