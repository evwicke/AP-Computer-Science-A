import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.*;

public class BombGUI {
    public static final String WINDOW_TITLE = "Keep Typing and Nobody Explodes";
    public static final int WINDOW_WIDTH = 1000;
    public static final int WINDOW_HEIGHT = 800;
    
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
    private JLabel timerLabel;
    
    private JLabel moduleTimerLabel;

    private JPanel visualContainer;
    private VisualModule visualSimon;
    private VisualModule visualScramble;
    private VisualModule visualMastermind;
    
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
        JPanel centerSplit = new JPanel(new BorderLayout());
        centerSplit.add(scrollPane, BorderLayout.CENTER); 
        
        // bottom row to hold the 3 visual modules
        visualContainer = new JPanel(new GridLayout(1, 3, 20, 0)); 
        visualContainer.setBackground(Color.BLACK);
        visualContainer.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); 
        visualContainer.setPreferredSize(new Dimension(WINDOW_WIDTH, 250));
        
        visualSimon = new VisualModule("SIMON", Color.RED);
        visualScramble = new VisualModule("SCRAMBLE", Color.RED);
        visualMastermind = new VisualModule("MASTERMIND", Color.RED);
        
        visualContainer.add(visualSimon);
        visualContainer.add(visualScramble);
        visualContainer.add(visualMastermind);
        
        centerSplit.add(visualContainer, BorderLayout.SOUTH);
        
        frame.add(centerSplit, BorderLayout.CENTER); 

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
        
        JPanel clockPanel = new JPanel(new GridLayout(2, 1));
        clockPanel.setBackground(Color.BLACK);
        
        // main Red Clock
        timerLabel = new JLabel("00:00:000", SwingConstants.CENTER);
        timerLabel.setFont(new Font(FONT_NAME, Font.BOLD, 36));
        timerLabel.setForeground(Color.RED);
        timerLabel.setOpaque(true);
        timerLabel.setBackground(Color.BLACK);
        clockPanel.add(timerLabel);
        
        // yellow Simon Clock
        moduleTimerLabel = new JLabel("", SwingConstants.CENTER); // Starts empty!
        moduleTimerLabel.setFont(new Font(FONT_NAME, Font.BOLD, 24));
        moduleTimerLabel.setForeground(Color.YELLOW);
        moduleTimerLabel.setOpaque(true);
        moduleTimerLabel.setBackground(Color.BLACK);
        clockPanel.add(moduleTimerLabel);
        
        frame.add(clockPanel, BorderLayout.NORTH); 
        
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
    
    public void printToConsole(String text, Color c, int textSize) {
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);
        aset = sc.addAttribute(aset, StyleConstants.FontFamily, FONT_NAME);
        aset = sc.addAttribute(aset, StyleConstants.FontSize, textSize);
        aset = sc.addAttribute(aset, StyleConstants.Bold, true);

        try {
            int len = consoleOutput.getDocument().getLength();
            consoleOutput.getDocument().insertString(len, text + "\n", aset);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
        
        consoleOutput.setCaretPosition(consoleOutput.getDocument().getLength());
    }
    
    //like print instead of println
    public void printInline(String text, Color c, int size) {
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);
        aset = sc.addAttribute(aset, StyleConstants.FontFamily, FONT_NAME);
        aset = sc.addAttribute(aset, StyleConstants.FontSize, size);
        aset = sc.addAttribute(aset, StyleConstants.Bold, true);

        try {
            int len = consoleOutput.getDocument().getLength();
            consoleOutput.getDocument().insertString(len, text, aset); // just removed the +"\n
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
    public Color getBGColor(){return BG_COLOR;}
    
    public static void main() {
        new BombGUI();
    }
    
    public void updateModuleTimer(String text) {
        moduleTimerLabel.setText(text);
    }
    
    public void updateTimerDisplay(String text) {
        timerLabel.setText(text);
    }
    
    public void setSimonVisual(String text, Color c) {
        visualSimon.updateState(text, c);
    }
    public void setScrambleVisual(String text, Color c) {
        visualScramble.updateState(text, c);
    }
    public void setMastermindVisual(String text, Color c) {
        visualMastermind.updateState(text, c);
    }
    public void setMainMenuVisualsVisible(boolean visible) {
        visualContainer.setVisible(visible);
    }
}