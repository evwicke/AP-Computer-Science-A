package src;

/*
Evan Wicke
Checkers ( Make a checkerboard! )
Mon Sep 29
This program creates a checkerboard pattern by taking user input
for row and column amounts to display alternating red and black squares.
 */

import javax.swing.*; // for jpanels and jframes
import java.awt.*; // for colors and containers
import java.util.Optional;
import java.util.Scanner; // for user input

public class MazePrinterGUI {
    public static void main(String[] args) throws InterruptedException{

        // initialize scanner and JFrame constants
        Scanner scan = new Scanner(System.in);
        final int WIDTH = 1000;
        final int HEIGHT = 1000;

        // initialize and configure the frame
        JFrame mainFrame = new JFrame();
        mainFrame.setTitle("Maze Program");
        mainFrame.setSize(WIDTH, HEIGHT);
        mainFrame.setLocationRelativeTo(null); // center the frame (this one i thought was cool!)
        mainFrame.setResizable(true);
        mainFrame.setBackground(Color.BLACK);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // constants for frame generation and whether to update frame each draw cycle

        char[] map = { 5, 5,
                'X','X','X','X','X',
                'X','O','O','O','X',
                'X','O','X','O','X',
                'X','O','O','O','X',
                'X','X','X','X','X',
                5, 5
        };




        // generate the board
        makeBoard(map[1], map[2], mainFrame, true, map);
        Thread.sleep(150); // wait 150 milliseconds to make sure the board is generated.
        mainFrame.revalidate(); //after we make the board, we want to refresh the JFrame to make sure any visual bugs are gone.
        mainFrame.repaint();
    }
    // constuctor method for JPanels
    private static JPanel newPanel(Optional<Color> color) {
        JPanel panel = new JPanel();
        if(color.isEmpty()){
        }else {
            panel.setBackground(color);
            panel.setOpaque(true);  // found this in the docs. it should slow down the program but be worth it because it will
            //make any changes that happen the very top of the stack, essentially helping make it less buggy.
            return panel;
        }
    }

    // method to generate the checkerboard
    private static void makeBoard(int rows, int cols, JFrame frame, boolean autoRepaint, char[] map)  {
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.BLACK); // set the background color of the frame
        GridLayout grid = new GridLayout(rows, cols, 0, 0); // set the layout of the frame
        frame.setLayout(grid);
        int panelCounter = 0;
        for (int i = 0; i < rows; i++) { // iterate through rows
            for (int j = 0; j < cols; j++) { // iterate through columns
                frame.add(newPanel(()?(map[j+2] == 'X')?Color.WHITE:Color.BLACK):null); // add a new panel to the frame with correct colors
                panelCounter++;
                System.out.print((panelCounter%50==0)? (panelCounter%200==0)? panelCounter + "\n" : panelCounter + "\t" : "");
            }

            if (rows == cols && (i + 1) % 4 == 0 && autoRepaint) { frame.revalidate(); frame.repaint(); } // if we are autorepainting, every 4th perfect square will be displayed.
        }
    }
}