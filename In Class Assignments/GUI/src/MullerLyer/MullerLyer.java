package GUI.src.MullerLyer;

/*
 * Creates a panel with a muller-lyer effect to be displayed on the screen with helper class MullerLyer.MyPanelViewer.
 *
 * @evanwicke
 * @version 10.1.25
 */
import javax.swing.*; //JFrame and JPanel
import java.awt.*; //color and containers
public class MullerLyer extends JPanel //isA relationship
//"extends" gets all public methods from a JPanel
{
    public MullerLyer(Color myColor){
        this.setBackground(myColor); //"this" means is a relationship
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int x = getWidth(); //getting the width and height of the panel
        int y = getHeight();

        Graphics2D gT = (Graphics2D)g; //making new graphics object to draw with
        gT.setStroke(new BasicStroke(5.0f)); // setting it to be thicker
        gT.setPaint(Color.BLACK); //set it to be black.

        gT.drawLine((int) (x * .15), (int) (y * 0.50), (int) (x * .45), (int) (y * 0.50)); //makes initial left line

        gT.drawLine((int) (x * .05), (int) (y * 0.40), (int) (x * .15), (int) (y * 0.50)); //makes the 4 "arms" for the muller-lyer effect.
        gT.drawLine((int) (x * .05), (int) (y * 0.60), (int) (x * .15), (int) (y * 0.50));
        gT.drawLine((int) (x * .55), (int) (y * 0.40), (int) (x * .45), (int) (y * 0.50));
        gT.drawLine((int) (x * .55), (int) (y * 0.60), (int) (x * .45), (int) (y * 0.50));



        gT.drawLine((int) (x * .65), (int) (y * 0.50), (int) (x * .95), (int) (y * 0.50)); //makes initial right line, identical to left line , but at a different x value

        gT.drawLine((int) (x * .75), (int) (y * 0.40), (int) (x * .65), (int) (y * 0.50)); //makes the 4 "arms" for the muller-lyer effect.
        gT.drawLine((int) (x * .75), (int) (y * 0.60), (int) (x * .65), (int) (y * 0.50));
        gT.drawLine((int) (x * .95), (int) (y * 0.50), (int) (x * .85), (int) (y * 0.40));
        gT.drawLine((int) (x * .95), (int) (y * 0.50), (int) (x * .85), (int) (y * 0.60));

    }
}