package src;

/*
    Evan Wicke
    Cooper ( Flag Project ) 
    Mon Sep 29

    This program creates a window that displays different country flags
    using colored panels arranged in a grid layout. It shows the flags
    of France, Mauritius, and Bulgaria in sequence with delays between
    each display.
*/

import javax.swing.*; // for jpanels and jframes
import java.awt.*; // for colors and containers

public class Cooper {
    public static void main(String[] args) throws InterruptedException {
        final int WIDTH = 1200;
        final int HEIGHT = 800;
        
        
        //initialize the frame
        JFrame mainFrame = new JFrame();
        mainFrame.setTitle("Cooper Flag Program");
        mainFrame.setSize(WIDTH, HEIGHT);
        mainFrame.setLocation(100,50);
        mainFrame.setResizable(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //france
        makeFlag(1,3,mainFrame, new Color[]{Color.blue, Color.white, Color.red});  // uses format:    makeFlag(rows,cols,frame,color[]);
        mainFrame.setVisible(true); // make the frame visible and display it.
        Thread.sleep(2000); // wait 2 seconds

        //mauritius
        makeFlag(4,1,mainFrame, new Color[]{Color.red, Color.blue, Color.yellow, Color.green});
        Thread.sleep(2000);

        //bulgaria via rgb values
        makeFlag(3,1,mainFrame, new Color[]{new Color(255,255,255), new Color(0,150,110), new Color(214,38,18)});
        
    }


    private static JPanel newPanel(Color color) {  //method to make a new frame passed with a certain color
        JPanel panel = new JPanel();
        panel.setBackground(color);
        return panel;
    }
    private static void makeFlag(int rows, int cols, JFrame frame, Color[] color){  //method to use the args to make a flag
        frame.getContentPane().removeAll();  // part 1 of clearing
        GridLayout grid = new GridLayout(rows,cols);
        frame.setLayout(grid);
        for(Color c : color){  // for each color SLOT in the list of colors, add a frame with the color it contains.
            frame.add(newPanel(c));
        }
        frame.revalidate(); // signals to the cpu to go back and check if you are running out of grid slots, if so, it makes more.
        frame.repaint(); // now take the backlog of 'add();' commands and fit them into their respective grid slots.
    }
}
