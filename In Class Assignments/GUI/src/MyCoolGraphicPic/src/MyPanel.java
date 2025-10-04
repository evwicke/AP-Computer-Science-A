package GUI.src.MyCoolGraphicPic.src;

/*
 * Makes a drawing of a landscape
 *
 * @evwicke
 * @version 10.3.25
 */
import javax.swing.*; //JFrame and JPanel
import java.awt.*; //color and containers
import java.util.*; //for arraylists (just better arrays)


public class MyPanel extends JPanel{

    public void paintComponent(Graphics g){
    super.paintComponent(g);
    
    Graphics2D g2 = (Graphics2D) g;
    // antialiasing. yes.
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    int uH = getHeight();
    int uW = getWidth();
        drawGradientSky(g2);
        g2.setStroke(new BasicStroke(14.0f));
        

        int sunSize = (int)(0.25 * Math.min(uW, uH));
        int sunX = uW/2 - sunSize/2;
        int sunY = (int)(uH/3.5) - sunSize/2; // Higher position

        g2.setColor(new Color(255, 250, 220)); // Soft yellow-white
        g2.fillOval(sunX, sunY, sunSize, sunSize);

        //ground
        g2.setColor(new Color(6, 0, 20));
        g2.fillRect((0),(uH/2),(uW),(uH/2));


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


        //bottom mountains
        double[] bottomMountainsX = {54.2,49.8,44.1,32.7,25.3,21,12.5,9.4,5.54,0,0,8.6,26.6,38.7,50.2,60,60,60};
        double[] bottomMountainsY = {21.9,25.4,18.94,13.66,8.8,9.94,17,19.66,24.4,22.75,12.5,8.5,3.96,4.2,6.8,9.8,19.2,25.5};
        Polygon bottomMountains = new Polygon(desmosToPixX(bottomMountainsX),desmosToPixY(bottomMountainsY), bottomMountainsX.length);
        g2.setColor(new Color(50, 40, 80));
        g2.fillPolygon(bottomMountains);
        gThin.setStroke(new BasicStroke(0.5f));
        gThin.setColor(new Color(0, 0, 0, 50)); // Semi-transparent
        gThin.drawPolygon(bottomMountains);

        Color[] sunBeamColors = {new Color(255, 154, 154, 115), new Color(255, 220, 200, 0)}; // Make outer color transparent
        float[] fractions = {0.0f, 1.0f}; // Color distribution
        RadialGradientPaint sunBeam = new RadialGradientPaint(
                (float)(sunX + sunSize/2),  // Center X
                (float)(sunY + sunSize/2),  // Center Y
                (float)(0.50 * Math.min(uW, uH)),  // Radius as float
                fractions,
                sunBeamColors
        );
        g2.setPaint(sunBeam);

        int beamSize = (int)(1.0 * Math.min(uW, uH));
        g2.fillOval(sunX + sunSize/2 - beamSize/2, sunY + sunSize/2 - beamSize/2, beamSize, beamSize);

        g2.setColor(new Color(6, 0, 20));
        // Left forest cluster - positioned on the curve y = (1/160)(x-30)^2 + 4
        drawTreeOnCurve(g2, 5, 2.5);
        drawTreeOnCurve(g2, 8, 2.0);
        drawTreeOnCurve(g2, 12, 3.0);
        drawTreeOnCurve(g2, 15, 1.8);
        drawTreeOnCurve(g2, 18, 2.2);
        drawTreeOnCurve(g2, 10, 1.5);
        
        // Right forest cluster - also on the curve.
        drawTreeOnCurve(g2, 42, 2.6);
        drawTreeOnCurve(g2, 45, 2.1);
        drawTreeOnCurve(g2, 48, 3.2);
        drawTreeOnCurve(g2, 52, 1.9);
        drawTreeOnCurve(g2, 55, 2.3);
        drawTreeOnCurve(g2, 50, 2.0);

    }

    public int[] desmosToPixX(double[] array){
        double desmosX = 60;
        ArrayList<Integer> pixList = new ArrayList<>();
        
        for(double f : array){
            double percentage = (f / desmosX);
            int pixel = (int)(percentage * getWidth());
            pixList.add(pixel);
        }
        return pixList.stream().mapToInt(i->i).toArray();
    }

    public int[] desmosToPixY(double[] array){
        double desmosY = 34;
        ArrayList<Integer> pixList = new ArrayList<>();
        
        for(double f : array){
            double percentage = (Math.abs(34-f) / desmosY);
            int pixel = (int)(percentage * getHeight());
            pixList.add(pixel);
        }
        return pixList.stream().mapToInt(i->i).toArray();
    }

    private void drawGradientSky(Graphics2D g2) {
        int uH = getHeight();
        int uW = getWidth();
        GradientPaint gradient = new GradientPaint(
                0, 0, new Color(226, 112, 179),  // Pink at top
                0, (float)uH /2, new Color(255, 195, 163) // Peachy orange at middle
        );
        g2.setPaint(gradient);
        g2.fillRect(0, 0, uW, uH/2);

    
        //stars
        Random rand = new Random(67);
        g2.setColor(new Color(255, 255, 255, 150)); // Semi-transparent white

        for (int i = 0; i < 100; i++) {
            int starX = rand.nextInt(uW);
            int starY = rand.nextInt(uH / 3); // Only in top third of sky
            int starSize = rand.nextInt(4) +1; // 1-2 pixels

            // Make some stars slightly brighter
            if (rand.nextInt(5) == 0) {
                g2.setColor(new Color(255, 255, 255, 200));
            } else {
                g2.setColor(new Color(255, 255, 255, 120));
            }

            g2.fillOval(starX, starY, starSize, starSize);
        }
    }
    
    // Helper to place a tree on the parabolic curve: y = (1/160)(x-30)^2 + 4
    private void drawTreeOnCurve(Graphics2D g2, double desmosX, double scale) {
        // Calculate Y using the parabola formula
        double desmosY = (1.0/160.0) * Math.pow(desmosX - 33, 2) + 4;
        
        // Convert to pixel coordinates
        int pixelX = desmosToPixX(new double[]{desmosX})[0];
        int pixelY = desmosToPixY(new double[]{desmosY})[0];
        
        // Draw the tree at this position
        drawPineTree(g2, pixelX, pixelY, scale);
    }
    
    private void drawPineTree(Graphics2D g2, int x, int baseY, double scale) {
        int baseHeight = 100; // Base tree height
        int height = (int)(baseHeight * scale);
        int width = height / 2; // Width proportional to height
        
        // Draw trunk
        int trunkWidth = width / 6;
        int trunkHeight = height / 6;
        g2.fillRect(x - trunkWidth/2, baseY - trunkHeight, trunkWidth, trunkHeight);
        
        // Draw 4 layers of triangular branches with overlap
        int numLayers = 5;
        int layerHeight = (height - trunkHeight) / 3;
        
        for (int i = 0; i < numLayers; i++) {

            int layerY = (int)(baseY - trunkHeight - (i * layerHeight * 0.7));
            int layerWidth = width - (i * width / (numLayers + 1));
            
            // Create a triangle for this layer
            int[] xPoints = {
                x - layerWidth/2,           // left point
                x,                           // top point
                x + layerWidth/2            // right point
            };
            int[] yPoints = {
                layerY,                      // left point
                layerY - layerHeight,        // top point
                layerY                       // right point
            };
            
            g2.fillPolygon(xPoints, yPoints, 3);
        }
    }
}
