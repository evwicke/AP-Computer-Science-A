package GUI.src.MullerLyer;

/*
 * Displays the Muller-Lyer panel to the screen with certain attributes like background color, size, and initial location.
 *
 * @evwicke
 * @version 10.1.25
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