
/*
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */

import javax.swing.*; // for jpanels and jframes
import java.awt.*; // for colors and containers

public class GUI_Window{
    public static void main(String[] args) throws InterruptedException {
        final int WIDTH = 300;
        final int HEIGHT = 500;

        // Instantiation ... making an instance of an object.
        // ClassName identifier = new ClassName(args[]);

        JFrame Frame = new JFrame();
        Frame.setTitle("First GUI Program");
        Frame.setSize(WIDTH, HEIGHT);
        Frame.setLocation(100,50);
        Frame.setBackground(Color.black);
        Frame.setResizable(true);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Basic color panels
        JPanel Panel1 = new JPanel();
        Panel1.setBackground(Color.pink);
        JPanel Panel2 = new JPanel();
        Panel2.setBackground(Color.green);
        JPanel Panel3 = new JPanel();
        Panel3.setBackground(Color.blue);
        JPanel Panel4 = new JPanel();
        Panel4.setBackground(Color.red);
        JPanel Panel5 = new JPanel();
        Panel5.setBackground(Color.yellow);

        // New color via RGB
        JPanel PanelRGB = new JPanel();
        Color newColor = new Color(100,42,58);
        PanelRGB.setBackground(newColor);

        // Attach the panels to the frame.
        // Grid layout.
        GridLayout Grid = new GridLayout(3,4);
        Frame.setLayout(Grid);
        Frame.add(Panel1);
        Frame.add(Panel2);
        Frame.add(Panel3);
        Frame.add(Panel4);
        Frame.add(Panel5);
        Frame.add(PanelRGB);

        // BorderLayout
        BorderLayout Border = new BorderLayout();
        Frame.setLayout(Border);
        Frame.add(PanelRGB, BorderLayout.WEST); 
        Frame.add(Panel4, BorderLayout.NORTH);
        Frame.add(Panel2, BorderLayout.EAST);
        Frame.add(Panel3, BorderLayout.SOUTH);
        Frame.add(Panel1, BorderLayout.CENTER);

        //wait  
        Thread.sleep(1000);
        Frame.add(Panel5);
        
        // Container
        Container Center = new Container();
        Center.setLayout(new GridLayout(2,3));
        
        Center.add(Panel2);
        Center.add(Panel3);
        Center.add(Panel4);
        Center.add(Panel5);
        Center.add(PanelRGB);
        Center.add(Panel1);
        Frame.add(Center, BorderLayout.CENTER);
        Frame.add(PanelRGB, BorderLayout.WEST); 
        Frame.add(Panel4, BorderLayout.NORTH);
        Frame.add(Panel2, BorderLayout.EAST);
        Frame.add(Panel3, BorderLayout.SOUTH);
        
        Frame.setVisible(true);
    }

    
}
