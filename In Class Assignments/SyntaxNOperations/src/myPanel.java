package src;

/**
 * Write a description of class LynchPaznel here.
 *
 * @dlynch1
 * @version 9.23.24
 */
import javax.swing.*; //JFrame and JPanel
import java.awt.*; //color and containers
public class myPanel extends JPanel //isA relationship
//"extends" gets all public methods from a JPanel
{
    /**
     * Constructor for objects of class LynchPaznel
     * ...we'll talk more later but for now, it basically initializes the
     * object when it gets constructed from a main method elsewhere
     */
    public myPanel(Color myColor)
    {
        this.setBackground(myColor); //"this" means is a relationship
    }
    //Override the parent paintComponent method
    public void paintComponent(Graphics g) //graphics class has methods to
    //draw inside a panel, runs when the object is created or refreshed
    //(notice there is no "static" keyword
    //note the application never calls the paintComponent directly
    //(triggered by JVM-Java Virtual Machine) in response to certain events
    //dealing with drawing
    {
        super.paintComponent(g); //more on this later but super calls the parent's version
        
        String word = "Hello World is a great place to start";
        int x = (getWidth() - word.length()*5) / 2; //pixels
        int y = getHeight()/2;
        g.drawString(word,x,y);
        
        //make a rectangle
        g.setColor(Color.black);
        g.fillRect(x-50,y-60,80,20);
        g.drawRect(x-50,y-60,80,20); //x,y,width,height
        
        //draw a line
        g.setColor(Color.red);
        g.drawLine(getWidth(),0,0,getHeight()); //x1,y1,x2,y2
        g.drawLine(0,0,200,100); //x1,y1,x2,y2
        Rectangle myRect = new Rectangle(100,200,100,100); //square 100x100
        
        //Oval (x,y,widght,height)
        g.drawOval(myRect.x,myRect.y,myRect.width,myRect.height);
        g.fillOval(myRect.x,myRect.y,myRect.width,myRect.height);
        
        //Custom Color
        Color newColor = new Color(204,100,187);
        g.setColor(newColor);
        g.drawRoundRect(10,25,100,30,60,30); //x,y,w,h,arcWidth,arcHeight
        g.drawArc(10,300,130,230,45,-180); //x,y,w,h,start angle, angle size
        g.fillArc(10,300,130,230,45,-90);
        
        //make the lines thicker
        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(7.0f)); //"f" is for float
        g2.setPaint(Color.orange); //think of a brush stroke
        
        //g2.drawTriangle(30,30,60,60,100,100); isnt a thing, but g2.drawPolygon(); is.
    }
}