package GUI.src.MullerLyer;

/*
 * Write a description of class CanvasGUI here.
 *
 * @dlynch1
 * @version 9.23.24
 */
import javax.swing.*;
import java.awt.*;


public class MyPanelViewer{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setSize(1000,750);
        MyPanel myPanel = new MyPanel(new Color(255,255,255));
        frame.setLocationRelativeTo(null);
        
        frame.add(myPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}