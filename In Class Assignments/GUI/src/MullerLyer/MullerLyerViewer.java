package GUI.src.MullerLyer;

/*
 * Write a description of class CanvasGUI here.
 *
 * @dlynch1
 * @version 9.23.24
 */
import javax.swing.*;
import java.awt.*;


public class MullerLyerViewer {
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setSize(1000,750);
        MullerLyer mullerLyer = new MullerLyer(new Color(255,255,255));
        frame.setLocationRelativeTo(null);
        
        frame.add(mullerLyer);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}