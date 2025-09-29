
/*



*/

import javax.swing.*; // for jpanels and jframes
import java.awt.*; // for colors and containers

public class Cooper {
    public static void main(String[] args) {
        final int WIDTH = 1200;
        final int HEIGHT = 800;

        JFrame Frame = new JFrame();
        Frame.setTitle("Cooper Flag Program");
        Frame.setSize(WIDTH, HEIGHT);
        Frame.setLocation(100,50);
        Frame.setResizable(true);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridLayout Grid = new GridLayout(3,1);
        Frame.setLayout(Grid);



    }
}
