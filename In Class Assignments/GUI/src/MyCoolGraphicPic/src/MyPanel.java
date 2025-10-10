package src.MyCoolGraphicPic.src;

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
    int uH = getHeight(); // set some global variables here. 
    int uW = getWidth(); // i tried originally to make them finals, but it didnt work because it would throw an error whenever the screen was resized.

    public void paintComponent(Graphics g){  //basically the main method of this class. it's where all the helper methods get called.
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        // antialiasing. yes. smoother edges are always good
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        uH = getHeight(); // have to reset every frame, so I put it in here too.
        uW = getWidth();

        drawGradientSky(g2); // furthest back in the painting is the sky. draw that using the helper method ( I moved it all to a diff method because the stars are messy. )

        int sunSize = (int)(0.25 * Math.min(uW, uH)); // make the radius of the sun 25% of the width or height of the screen, whichever is smaller. this makes sure its always a circle.
        int sunX = uW/2 - sunSize/2; // put it in the middle
        int sunY = (uH/3) - sunSize/2; // Higher position than the middle. 1/3 down the screen is good

        g2.setColor(new Color(255, 250, 220)); // yellow-white
        g2.fillOval(sunX, sunY, sunSize, sunSize); // make the sun

        //ground at the very bottom of the screen. dont want it drawing over the mountains or trees.
        g2.setColor(new Color(6, 0, 20));
        g2.fillRect((0),(uH/2),(uW),(uH/2));

        Graphics2D gThin = (Graphics2D) g; // this is for the very thin outline of all the shapes to help them blend in more and be less jagged
        gThin.setStroke(new BasicStroke(2.5f));

        // top mountains
        double[] topMountainsX = {20.35, 14.75 ,3.6, 0, 0 ,5.35, 9.3, 13.5, 20.7, 25.2,
                29.8, 35.2, 50.1, 39.5, 34.7, 31.4, 26.96, 23.2 };
        double[] topMountainsY = {23.96 ,19.8 ,27.3, 24.85, 22.7, 24.3, 19.5, 12.7, 9.7 ,6.4, 9.4 ,13.9, 19.9, 22.7,
                20.1, 22.45, 18.36, 21 };
        Polygon topMountains = new Polygon(desmosToPixX(topMountainsX),desmosToPixY(topMountainsY),topMountainsX.length);
        /*
        Ok so this polygon is the top mountain. (the one in the back of the frame). I initialize the polygon with
        new Polygon(int[x], int[y], int npoints). then i set the color and draw the filled in shape with fillPolygon. then i make the outline with drawPolygon
        this applies to all of the mountains.
         */
        g2.setColor(new Color(98,78,141));
        g2.fillPolygon(topMountains);
        gThin.setStroke(new BasicStroke(0.5f));
        gThin.setColor(new Color(0, 0, 0, 50)); // Semi-transparent
        gThin.drawPolygon(topMountains);

        //bottom mountains
        double[] bottomMountainsX = {54.2,49.8,44.1,32.7,25.3,21,12.5,9.4,5.54,0,0,8.6,26.6,38.7,50.2,60,60,60};
        double[] bottomMountainsY = {21.9,25.4,18.94,13.66,8.8,9.94,17,19.66,24.4,22.75,12.5,8.5,3.96,4.2,6.8,9.8,19.2,25.5};
        Polygon bottomMountains = new Polygon(desmosToPixX(bottomMountainsX),desmosToPixY(bottomMountainsY), bottomMountainsX.length);
        g2.setColor(new Color(50, 40, 80));
        g2.fillPolygon(bottomMountains);
        gThin.setStroke(new BasicStroke(0.5f));
        gThin.setColor(new Color(0, 0, 0, 50)); // Semi-transparent
        gThin.drawPolygon(bottomMountains);

        // Left forest cluster - positioned on the curve y = (1/160)(x-30)^2 + 4
        // i found the curve on desmos by playing around with a quadratic function until it lined up with the tree line of the reference image.
        g2.setColor(new Color(6, 0, 20));
        drawTreeOnCurve(g2, 3, 1.2);
        drawTreeOnCurve(g2, 5, 2.5);
        drawTreeOnCurve(g2, 8, 2.0);
        drawTreeOnCurve(g2, 10, 1.5);
        drawTreeOnCurve(g2, 12, 3.0);
        drawTreeOnCurve(g2, 15, 1.8);
        drawTreeOnCurve(g2, 16.5, 1.2);
        drawTreeOnCurve(g2, 18, 2.2);

        // Right forest cluster - also on the curve.
        g2.setColor(new Color(6, 0, 20));
        drawTreeOnCurve(g2, 39, 1.5);
        drawTreeOnCurve(g2, 42, 2.6);
        drawTreeOnCurve(g2, 45, 2.1);
        drawTreeOnCurve(g2, 48, 3.2);
        drawTreeOnCurve(g2, 52, 1.9);
        drawTreeOnCurve(g2, 55, 2.3);
        drawTreeOnCurve(g2, 50, 2.0);
        drawTreeOnCurve(g2, 58, 1.0);

        
        //draws 4 clouds in the scene :
            // drawCloud(graphics Obj, X, Y, scaleFactor);
        drawCloud(g2, 100, 100, 1.0);
        drawCloud(g2, 300, 200, 1.2);
        drawCloud(g2, uW-200, 150, 1.3);
        drawCloud(g2, uW-400, 400, 0.75);

        
        
        drawFireflies(g2);
        
        
        /*
        Basically is a custom color object (technically a paint object, but they function the same).
        the color array is the colors it will go between, the first is in the center, and the last is in the outer parts of the effect.
        (the effect is a circle because its radial gradient not a normal gradient). the float array is there to tell it WHERE in the circle each color
        should be at 100% opacity. ( at the middle its color 1, and at the outer its color n.length. )
        then i set the paint to the new paint color.
         */
        
        
        
        
        Color[] sunBeamColors = {new Color(255, 154, 154, 115), new Color(255, 50, 45, 16), new Color(0, 0, 0, 105), new Color(0, 0, 0, 255)}; // Make outer color transparent
        float[] fractions = {0.0f, 0.45f, 0.75f, 1.0f}; // Color distribution
        RadialGradientPaint sunBeam = new RadialGradientPaint(
                (float)(sunX + sunSize/2),  // Center X
                (float)(sunY + sunSize/2),  // Center Y
                (float)(0.7 * Math.max(uW, uH)),  // Radius as float
                fractions,
                sunBeamColors
            );
        g2.setPaint(sunBeam); // this works similarly to graphic.setColor(Color color);

        int beamSize = (int)(1.5 * Math.max(uW, uH)); //radius of the sun's beams effect
        g2.fillOval(sunX + sunSize/2 - beamSize/2, sunY + sunSize/2 - beamSize/2, beamSize, beamSize);

        
        
    }

    public int[] desmosToPixX(double[] array){
        double desmosX = 60;
        ArrayList<Integer> pixList = new ArrayList<>(); // arraylists are dynamic array objects. They can take in a bunch of values [0,23,134,12,13,-23] and can be changed both
        // in size and in value. It will automatically resize when an element is added to the end of the array.

        for(double f : array){
            /* For each number in the array, this for loop will first : find the percentage of the whole screen,
             * then it will get the pixel equivalent of the percentage OF THE NEW HEIGHT/WIDTH of the screen.
             */
            double percentage = (f / desmosX);
            int pixel = (int)(percentage * getWidth());
            pixList.add(pixel);
        }
        return pixList.stream().mapToInt(i->i).toArray(); //converts a List<Integer> into a primitive int[] array
    }

    public int[] desmosToPixY(double[] array){
        double desmosY = 34;
        ArrayList<Integer> pixList = new ArrayList<>();

        for(double f : array){
            /* For each number in the array, this for loop will first : find the percentage of the whole screen,
             * then it will get the pixel equivalent of the percentage OF THE NEW HEIGHT/WIDTH of the screen.
             */
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
                0, (float)uH /2, new Color(255, 195, 163) // orange at middle
            );
        g2.setPaint(gradient);
        g2.fillRect(0, 0, uW, uH/2);

        //stars
        Random rand = new Random(67); // seed of 67 to make the stars in the same place every time i compile it
        g2.setColor(new Color(255, 255, 255, 110)); // Semi-transparent white (alpha value at 110/255 opacity)

        for (int i = 0; i < 150 /* 150 stars */; i++) {
            int starX = rand.nextInt(uW);
            int starY = rand.nextInt(uH / 3); // Only in top third of sky
            int starSize = rand.nextInt(4) +1;

            // Make some stars slightly brighter
            if (rand.nextInt(10) == 0) {
                g2.setColor(new Color(255, 255, 255, 230));
            }

            g2.fillOval(starX, starY, starSize, starSize);
            
            
            Color[] starBeamColors = {new Color(255, 255, 255, 125), new Color(255, 255, 255, 85), new Color(255, 255, 255, 35), new Color(255, 255, 255, 5)}; // Make outer color transparent
            float[] fractions = {(float)(starSize/(2.5*starSize)), 0.45f, 0.75f, 1.0f}; // Color distribution
            RadialGradientPaint starBeam = new RadialGradientPaint(
                    (float)(starX + starSize/2),  // Center X
                    (float)(starY + starSize/2),  // Center Y
                    (float)(0.8 * starSize),  // Radius as float
                    fractions,
                    starBeamColors
                );
            g2.setPaint(starBeam); // this works similarly to graphic.setColor(Color color);
    
            int beamSize = (3 * starSize); //radius of the sun's beams effect
            g2.fillOval(starX + starSize/2 - beamSize/2, starY + starSize/2 - beamSize/2, beamSize, beamSize);
        }
    }

    private void drawFireflies(Graphics2D g2){
        Random rand = new Random(67); // seed of 67 to make the fireflys in the same place every time i compile it
        g2.setColor(new Color(255, 200, 105, 110)); // Semi-transparent white (alpha value at 110/255 opacity)

        for (int i = 0; i < 150 /* 20 fireflies */; i++) {
            int fireflyX = rand.nextInt(uW);
            int fireflyY = (uH/2) + rand.nextInt(uH/2); 
            int fireflySize = rand.nextInt(4) +1;

            // Make some fireflys slightly brighter
            if (rand.nextInt(10) == 0) {
                g2.setColor(new Color(255, 200, 105, 210));
            }

            g2.fillOval(fireflyX, fireflyY, fireflySize, fireflySize);
            
            
            Color[] fireflyBeamColors = {new Color(255, 255, 255, 125), new Color(255, 255, 255, 85), new Color(255, 255, 255, 35), new Color(255, 255, 255, 5)}; // Make outer color transparent
            float[] fractions = {(float)(fireflySize/(2.5*fireflySize)), 0.45f, 0.75f, 1.0f}; // Color distribution
            RadialGradientPaint fireflyBeam = new RadialGradientPaint(
                    (float)(fireflyX + fireflySize/2),  // Center X
                    (float)(fireflyY + fireflySize/2),  // Center Y
                    (float)(0.8 * fireflySize),  // Radius as float
                    fractions,
                    fireflyBeamColors
                );
            g2.setPaint(fireflyBeam); // this works similarly to graphic.setColor(Color color);
    
            int beamSize = (3 * fireflySize); //radius of the sun's beams effect
            g2.fillOval(fireflyX + fireflySize/2 - beamSize/2, fireflyY + fireflySize/2 - beamSize/2, beamSize, beamSize);
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
        int baseHeight = (int)(uH/10.8); // Base tree height
        int height = (int)(baseHeight * scale);
        int width = height / 2; // Width proportional to height

        // Draw trunk
        int trunkWidth = width / 6;
        int trunkHeight = height / 6;
        g2.fillRect(x - trunkWidth/2, baseY - trunkHeight, trunkWidth, trunkHeight);

        int numLayers = 5;
        int layerHeight = (height - trunkHeight) / 3;

        for (int i = 0; i < numLayers; i++) {

            int layerY = (int)(baseY - trunkHeight - (i * layerHeight * 0.7));  // starts at the base Y, moves up by the trunk height, then moves up 70% of the layerheight* how many layers there are
            int layerWidth = width - (i * width / (numLayers + 2)); // width gets smaller per layer

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

    private void drawCloud(Graphics2D g2, int x, int y, double scale) {
        int cloudWidth = (int) (Math.min(uW,uH) / 12 * 1.5 * scale); // Base width of the cloud
        int cloudHeight = (int) (Math.min(uW,uH) / 20 * scale); // Base height of the cloud

        // Draw cloud ovals
        g2.setColor(new Color(255, 255, 255, 240)); // semi-transparent white
        g2.fillOval(x, y, cloudWidth, cloudHeight);
        g2.fillOval(x - cloudWidth / 2, y + cloudHeight / 4, (int) (cloudWidth * 0.7), (int) (cloudHeight * 0.7));
        g2.fillOval(x + cloudWidth / 3, y + cloudHeight / 3, (int) (cloudWidth * 0.8), (int) (cloudHeight * 0.8));
        g2.fillOval(x - cloudWidth / 3, y - cloudHeight / 3, (int) (cloudWidth * 0.9), (int) (cloudHeight * 0.9));
    }
}
