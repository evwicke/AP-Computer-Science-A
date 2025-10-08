package src.MyCoolGraphicPic.src;

//package src.MyCoolGraphicPic.src;

/*
 * Write a description of class CanvasGUI here.
 *
 * @dlynch1
 * @version 9.23.24
 */
import javax.swing.*;
import java.awt.*;


public class MyPanelViewer{
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(1600,900);
        MyPanel myPanel = new MyPanel();
        frame.setLocationRelativeTo(null);
        
        frame.add(myPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}