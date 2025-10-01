package src.Centerpoint.src;

/*
 * Centerpoint project
 * @Evan Wicke
 * @Tuesday Sep 30
 */

import javax.swing.*;
import java.awt.*;


public class CenterpointViewer {
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setSize(400,500);
        CenterpointPanel myPanel = new CenterpointPanel(new Color(0, 0, 0));
        frame.setLocationRelativeTo(null);
        frame.setTitle("Centerpoint");

        frame.add(myPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}