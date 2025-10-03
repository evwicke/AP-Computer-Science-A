package src.MyCoolGraphicPic.src;

/*
 * Write a description of class LynchPaznel here.
 *
 * @dlynch1
 * @version 9.23.24
 */
import javax.swing.*; //JFrame and JPanel
import java.awt.*; //color and containers
import java.util.*;

public class MyPanel extends JPanel{
    public MyPanel(Color myColor)
    {
        this.setBackground(myColor); 
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(14.0f));
      
        
        g2.setColor(Color.yellow);
        g2.fillOval(getWidth()/2 - (int)(.25*getHeight()), getHeight()/2 -(int)(.25*getHeight()), (int)(.09*getWidth()* 2.5), (int)(.16*getHeight() * 2.5));
        g2.setColor(Color.orange);
        g2.drawOval(getWidth()/2 - (int)(.25*getHeight()), getHeight()/2 -(int)(.25*getHeight()), (int)(.09*getWidth()* 2.5), (int)(.16*getHeight() * 2.5));
        
        //ground
        g2.setColor(Color.black);
        g2.fillRect((0),(getHeight()/2),(getWidth()),(getHeight()/2));
        
          
        Graphics2D gThin = (Graphics2D) g;
        gThin.setStroke(new BasicStroke(2.5f));

        // top mountains
        double[] topMountainsX = {20.35, 14.75 ,3.6, 0, 0 ,5.35, 9.3, 13.5, 20.7, 25.2,
            29.8, 35.2, 50.1, 39.5, 34.7, 31.4, 26.96, 23.2 };
        double[] topMountainsY = {23.96 ,19.8 ,27.3, 24.85, 22.7, 24.3, 19.5, 12.7, 9.7 ,6.4, 9.4 ,13.9, 19.9, 22.7,
            20.1, 22.45, 18.36, 21 };
        Polygon topMountains = new Polygon(desmosToPixX(topMountainsX),desmosToPixY(topMountainsY),topMountainsX.length);
        g2.setColor(new Color(98,78,141));
        g2.fillPolygon(topMountains);
        gThin.setColor(Color.black);
        gThin.drawPolygon(topMountains);
       
        //bottom mountains
        double[] bottomMountainsX = {54.2,49.8,44.1,32.7,25.3,21,12.5,9.4,5.54,0,0,8.6,26.6,38.7,50.2,60,60,60};
        double[] bottomMountainsY = {21.9,25.4,18.94,13.66,8.8,9.94,17,19.66,24.4,22.75,12.5,8.5,3.96,4.2,6.8,9.8,19.2,25.5};
        Polygon bottomMountains = new Polygon(desmosToPixX(bottomMountainsX),desmosToPixY(bottomMountainsY), bottomMountainsX.length);
        g2.setColor(Color.gray);
        g2.fillPolygon(bottomMountains);
        gThin.setColor(Color.black);
        gThin.drawPolygon(bottomMountains);
        
        
    }
    public int[] desmosToPixX(double[] array){
        double desmosX = 60;
        ArrayList<Integer> pixList = new ArrayList<>();
        
        for(double f : array){
            double percentage = (double)(f / desmosX);
            int pixel = (int)(percentage * getWidth());
            pixList.add(pixel);
        }
        return pixList.stream().mapToInt(i->i).toArray();
    }
    public int[] desmosToPixY(double[] array){
        double desmosY = 34;
        ArrayList<Integer> pixList = new ArrayList<>();
        
        for(double f : array){
            double percentage = (double)(Math.abs(34-f) / desmosY);
            int pixel = (int)(percentage * getHeight());
            pixList.add(pixel);
        }
        return pixList.stream().mapToInt(i->i).toArray();
    }
    
}