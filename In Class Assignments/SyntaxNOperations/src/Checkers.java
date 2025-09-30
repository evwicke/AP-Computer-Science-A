/*
    Evan Wicke
    Checkers ( Make a checkerboard! ) 
    Mon Sep 29
    This program creates a checkerboard pattern by taking user input
    for row and column amounts to display alternating red and black squares.
*/

import javax.swing.*; // for jpanels and jframes
import java.awt.*; // for colors and containers
import java.util.Scanner; // for user input

public class Checkers {
    public static void main(String[] args) throws InterruptedException {

        // initialize scanner and JFrame constants
        Scanner scan = new Scanner(System.in);
        final int WIDTH = 1000;
        final int HEIGHT = 1000;

        // initialize and configure the frame
        JFrame mainFrame = new JFrame();
        mainFrame.setTitle("Checkerboard Program");
        mainFrame.setSize(WIDTH, HEIGHT);
        mainFrame.setLocationRelativeTo(null); // center the frame (this one i thought was cool!)
        mainFrame.setResizable(true);
        mainFrame.setBackground(Color.BLACK);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // constants for frame generation and whether to update frame each draw cycle
        System.out.println("Multiples of 10 work better for autopaint, but anything works.\n");
        System.out.println("Enter the number of rows: ");
        final int rows = scan.nextInt();
        System.out.println("Enter the number of columns: ");
        final int cols = scan.nextInt();
        System.out.println("Should the board auto-repaint? (true/false)");
        final boolean autoRepaint = scan.nextBoolean();

        // generate the board and set it to visible
        mainFrame.setVisible(true);
        makeBoard(rows, cols, mainFrame, autoRepaint);
        mainFrame.revalidate();
        mainFrame.repaint();
    }
    // constuctor method for JPanels
    private static JPanel newPanel(Color color) {
        JPanel panel = new JPanel();
        panel.setBackground(color);
        panel.setOpaque(true);
        return panel;
    }

    // method to generate the checkerboard
    private static void makeBoard(int rows, int cols, JFrame frame, boolean autoRepaint) {
        frame.getContentPane().setBackground(Color.BLACK); // set the background color of the frame
        GridLayout grid = new GridLayout(rows, cols, 0, 0); // set the layout of the frame
        frame.setLayout(grid);


        for (int i = 0; i < rows; i++) { // iterate through rows
            for (int j = 0; j < cols; j++) { // iterate through columns
                frame.add(newPanel((i + j) % 2 == 0 ? new Color(0,0,0,0) : Color.RED)); // add a new panel to the frame with correct colors
            }
            if (rows == cols && (i + 1) % 4 == 0 && autoRepaint) { // if the number of rows and columns are equal, and the current row is a multiple of 4
                frame.revalidate(); // revalidate the frame
                frame.repaint(); // repaint the frame
            }
        }

    }
}