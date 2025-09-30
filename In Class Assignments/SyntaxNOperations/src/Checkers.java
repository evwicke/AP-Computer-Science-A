/*
    Evan Wicke
    Checkers ( Make a checkerboard! ) 
    Mon Sep 29
    This program creates a checkerboard pattern by taking user input
    for row and column amounts to display alternating red and black squares.
*/

import javax.swing.*; // for jpanels and jframes
import java.awt.*; // for colors and containers
import java.util.Scanner;

public class Checkers {
    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        final int WIDTH = 1000;
        final int HEIGHT = 1000;

        JFrame mainFrame = new JFrame();
        mainFrame.setTitle("Checkerboard Program");
        mainFrame.setSize(WIDTH, HEIGHT);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setResizable(true);
        mainFrame.setBackground(Color.BLACK);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        System.out.println("Enter the number of rows: ");
        final int rows = scan.nextInt();
        System.out.println("Enter the number of columns: ");
        final int cols = scan.nextInt();


        mainFrame.setVisible(true);
        makeBoard(rows, cols, mainFrame);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    private static JPanel newPanel(Color color) {
        JPanel panel = new JPanel();
        panel.setBackground(color);
        panel.setOpaque(true);
        return panel;
    }

    private static void makeBoard(int rows, int cols, JFrame frame) {
        frame.getContentPane().setBackground(Color.BLACK);
        GridLayout grid = new GridLayout(rows, cols, 0, 0);
        frame.setLayout(grid);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                frame.add(newPanel((i + j) % 2 == 0 ? Color.BLACK : Color.RED));
                frame.revalidate();
                frame.repaint();
            }
        }
    }
}