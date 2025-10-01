package src.Centerpoint.src;

/*
 * Centerpoint project
 * @Evan Wicke
 * @Tuesday Sep 30
 */

import javax.swing.*;
import java.awt.*;


public class CenterpointPanel extends JPanel{

    public CenterpointPanel(Color myColor) {
        this.setBackground(myColor); //"this" means is a relationship
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int x = getWidth()/2;
        int y = getHeight()/2;

        // Draw the X at the center point
        drawX(g, x, y, Color.BLUE, 10, 5);

        // Create the coordinate text
        String coordinates = "(" + x + "," + y + ")";


        FontMetrics fm = g.getFontMetrics();
        int textWidth = fm.stringWidth(coordinates);
        int textHeight = fm.getHeight();
        int textAscent = fm.getAscent();

        // Calculate position to center the text exactly at (x, y)
        int textX = x - (textWidth / 2);
        int textY = y - (textHeight / 2) + textAscent;

        // Draw the coordinates text at the exact center
        g.setColor(Color.WHITE);
        g.drawString(coordinates, textX, textY);
    }

    public void drawX(Graphics g, int x, int y, Color color, int size, int thickness) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(color);
        g2.setStroke(new BasicStroke(thickness));
        g2.drawLine(x - size, y - size, x + size, y + size);
        g2.drawLine(x - size, y + size, x + size, y - size);
    }


}