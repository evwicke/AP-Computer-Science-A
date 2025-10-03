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
        
        double[] topMountainsX = {20.35, 14.75 ,3.6, 0, 0 ,5.35, 9.3, 13.5, 20.7, 25.2,
            29.8, 35.2, 45.1, 39.5, 34.7, 31.4, 26.96, 23.2 };
        double[] topMountainsY = {23.96 ,19.8 ,27.3, 24.85, 22.7, 24.3, 19.5, 16.7, 9.7 ,9.4, 12.4 ,13.9, 19.9, 22.7,
            20.1, 22.45, 18.36, 21 };
        g.drawPolygon(desmosToPixX(topMountainsX),desmosToPixY(topMountainsY),19);
        
        
        
    }
    public int[] desmosToPixX(double[] array){
        double desmosX = 60;
        int[] pixList = {};
        
        for(double f : array){
            double percentage = (double)(f / desmosX);
            int pixel = (int)(percentage * getWidth());
            pixList.add(pixel);
        }
    }
    public int[] desmosToPixY(double[] array){
        double desmosY = 34;
        int[] pixList = {};
        
        for(float f : array){
            double percentage = (double)(f / desmosY);
            int pixel = (int)(percentage * getHeight());
            pixList = push(
        }
    }
    
}
    
    
}