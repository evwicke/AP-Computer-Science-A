package SyntaxNOperations.src;


/*



*/

import javax.swing.*; // for jpanels and jframes
import java.awt.*; // for colors and containers

public class Cooper {
    public static void main(String[] args) throws InterruptedException {
        final int WIDTH = 1200;
        final int HEIGHT = 800;

        JFrame mainFrame = new JFrame();
        mainFrame.setTitle("Cooper Flag Program");
        mainFrame.setSize(WIDTH, HEIGHT);
        mainFrame.setLocation(100,50);
        mainFrame.setResizable(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //france
        makeFlag(1,3,mainFrame, new Color[]{Color.blue, Color.white, Color.red});
        mainFrame.setVisible(true);
        Thread.sleep(2000);

        //mauritius
        makeFlag(4,1,mainFrame, new Color[]{Color.red, Color.blue, Color.yellow, Color.green});
        Thread.sleep(2000);

        //bulgaria via rgb values
        makeFlag(3,1,mainFrame, new Color[]{new Color(255,255,255), new Color(0,150,110), new Color(214,38,18)});


    }


    private static JPanel newPanel(Color color) {
        JPanel panel = new JPanel();
        panel.setBackground(color);
        return panel;
    }
    private static void makeFlag(int rows, int cols, JFrame frame, Color[] color){
        frame.getContentPane().removeAll();
        GridLayout grid = new GridLayout(rows,cols);
        frame.setLayout(grid);
        for(Color c : color){
            frame.add(newPanel(c));
        }
        frame.revalidate();
        frame.repaint();
    }
}
