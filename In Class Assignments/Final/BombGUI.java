import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.*;

public class BombGUI {
    public static final String WINDOW_TITLE = "Keep Typing and Nobody Explodes";
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 600;
    
    public static Color BG_COLOR = Color.BLACK;
    public static Color TEXT_COLOR = Color.GREEN;
    public static final Color INPUT_BG_COLOR = Color.DARK_GRAY;
    public static final Color INPUT_TEXT_COLOR = Color.WHITE;
    
    public static final String FONT_NAME = "DialogInput"; 
    public static final int FONT_SIZE = 14;

    // GUI components
    private JFrame frame;
    private JTextPane consoleOutput;
    private JTextField userInputBox;
    
    // game controller of bomb class (they see each other)
    private Bomb gameController;

    public BombGUI() {
        //jframe
        frame = new JFrame(WINDOW_TITLE);
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        Font terminalFont = new Font(FONT_NAME, Font.BOLD, FONT_SIZE);

        //JTextPane
        consoleOutput = new JTextPane(); 
        consoleOutput.setEditable(false); 
        consoleOutput.setBackground(BG_COLOR);
        consoleOutput.setMargin(new Insets(10, 10, 10, 10)); 
        
        JScrollPane scrollPane = new JScrollPane(consoleOutput);
        frame.add(scrollPane, BorderLayout.CENTER);

        //JTextField (input box)
        userInputBox = new JTextField();
        userInputBox.setBackground(INPUT_BG_COLOR);
        userInputBox.setForeground(INPUT_TEXT_COLOR);
        userInputBox.setCaretColor(INPUT_TEXT_COLOR); 
        userInputBox.setFont(terminalFont);
        userInputBox.setMargin(new Insets(5, 10, 5, 10));

        // wait for enter until it processes the input
        userInputBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                processInput();
            }
        });

        frame.add(userInputBox, BorderLayout.SOUTH);

        // Start the game visually
        frame.setVisible(true);
        
        // intialize the controller
        // passing this into the bomb class, where private BombGUI gui gets this gui.
        gameController = new Bomb(this);
    }

    private void processInput() {
        String input = userInputBox.getText().toUpperCase().trim(); 
        userInputBox.setText(""); // Clear the box
        
        if (input.isEmpty()) {
            return;
        }

        // Print the player's command to the screen so they can see what they typed
        printToConsole("\n> " + input);

        // PASS THE INPUT TO THE BOMB CLASS TO HANDLE THE LOGIC
        gameController.receiveCommand(input);
    }

    public void printToConsole(String text) {
        printToConsole(text, TEXT_COLOR);
    }

    public void printToConsole(String text, Color c) {
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);
        aset = sc.addAttribute(aset, StyleConstants.FontFamily, FONT_NAME);
        aset = sc.addAttribute(aset, StyleConstants.FontSize, FONT_SIZE);
        aset = sc.addAttribute(aset, StyleConstants.Bold, true);

        try {
            int len = consoleOutput.getDocument().getLength();
            consoleOutput.getDocument().insertString(len, text + "\n", aset);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
        
        consoleOutput.setCaretPosition(consoleOutput.getDocument().getLength());
    }
    
    public void clearConsole() {
        consoleOutput.setText("");
    }

    public void changeTextColor(Color color){
        TEXT_COLOR = color;
    }
    
    public void changeBGColor(Color color){
        BG_COLOR = color;
        consoleOutput.setBackground(color);
    }
    
    public static void main(String[] args) {
        new BombGUI();
    }
}