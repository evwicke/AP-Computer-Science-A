
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bomb {
    private BombGUI gui;
    private int strikes;

    private boolean scrambleDefused = false;
    private boolean mastermindDefused = false;
    private boolean simonDefused = false;

    private int modulesDefused = 0;
    private Module[] modules;
    private Module activeModule;
    private CountdownClock clock;

    public Bomb(BombGUI gui) {
        this.gui = gui;
        this.strikes = 0;

        gui.printToConsole("Bomb Armed.\n > Use HELP to get commands.");
        clock = new CountdownClock(240, this, gui); 
        clock.start();
    }

    public void receiveCommand(String command) {

        //if youre in a module, handle the input within the module itself
        if (activeModule != null) {
            activeModule.handleInput(command);
            return; 
        }

        //main menu commands
        switch (command) {
            case "HELP":
            gui.printToConsole("STATUS, MASTERMIND, SCRAMBLE, SIMON");
            break;

            case "STATUS":
            gui.printToConsole("--- STATUS ---", Color.CYAN);
            gui.printToConsole("STRIKES: " + strikes + "/3", Color.RED);
            gui.printToConsole("SCRAMBLE:   " + (scrambleDefused ? "[DEFUSED]" : "[ARMED]"));
            gui.printToConsole("MASTERMIND: " + (mastermindDefused ? "[DEFUSED]" : "[ARMED]"));
            gui.printToConsole("SIMON:      " + (simonDefused ? "[DEFUSED]" : "[ARMED]"));
            break;

            case "EXPLODE":
            explode();
            break;

            case "DEVTIME":
            clock.forceTimeLeft(3);
            break;

            case "SCRAMBLE":
            if (scrambleDefused) {
                gui.printToConsole("SCRAMBLE IS ALREADY DEFUSED.", Color.GREEN);
            } else {
                activeModule = new Scramble(this, gui);
                gui.clearConsole();
                gui.setMainMenuVisualsVisible(false);
                activeModule.start();
            }
            break;

            case "MASTERMIND":
            if (mastermindDefused) {
                gui.printToConsole("MASTERMIND IS ALREADY DEFUSED.", Color.GREEN);
            } else {
                activeModule = new Mastermind(this, gui);
                gui.clearConsole();
                gui.setMainMenuVisualsVisible(false);
                activeModule.start();
            }
            break;

            case "SIMON":
            if (simonDefused) {
                gui.printToConsole("SIMON IS ALREADY DEFUSED.", Color.GREEN);
            } else {
                activeModule = new Simon(this, gui);
                gui.clearConsole();
                gui.setMainMenuVisualsVisible(false);
                activeModule.start();
            }
            break;

            default:
            gui.printToConsole("COMMAND NOT RECOGNIZED.");
            addStrike();
            break;
        }
    }

    public void exitModule() {
        activeModule = null;
        gui.clearConsole();
        gui.setMainMenuVisualsVisible(true); 
        gui.printToConsole("EXITED MODULE", Color.YELLOW);
        gui.printToConsole("STATUS, MASTERMIND, SCRAMBLE, SIMON");
    }

    public void moduleSolved() {
        //instanceof is a built in equality operator for use in inheritance.
        if (activeModule instanceof Scramble) {
            scrambleDefused = true;
            gui.setScrambleVisual("SCRAMBLE DEFUSED", Color.GREEN);
        } else if (activeModule instanceof Mastermind) {
            mastermindDefused = true;
            gui.setMastermindVisual("MASTERMIND DEFUSED", Color.GREEN);
        } else if (activeModule instanceof Simon) {
            simonDefused = true;
            gui.setSimonVisual("SIMON DEFUSED", Color.GREEN);
        }

        activeModule = null; // back to main menu
        modulesDefused++; 

        gui.clearConsole();
        gui.setMainMenuVisualsVisible(true); 
        if (modulesDefused >= 3) {

            clock.stop(); 
            gui.changeBGColor(Color.GREEN);

        } else {

            gui.printToConsole("MODULE DEFUSED (" + modulesDefused + "/3 completed)", Color.YELLOW);
            gui.printToConsole("STATUS, MASTERMIND, SCRAMBLE, SIMON");
        }
    }

    public void stealTime(int seconds) {
        gui.printToConsole(seconds + " SECONDS LOST!", Color.RED, 21);
        clock.subtractTime(seconds);
    }

    public void addStrike() {
        strikes++;
        gui.printToConsole("STRIKE " + strikes + " ADDED!", Color.RED, 21);
        gui.printToConsole((3-strikes) + " STRIKES REMAINING.", Color.RED, 21);
        stealTime(30);

        if (strikes >= 3) {
            explode();
        }
    }

    public void explode() {
        clock.stop();
        gui.clearConsole();
        gui.changeBGColor(Color.RED);
    }
    public BombGUI getGUI(){return gui;}
}
class VisualModule extends JPanel{
    private String text;
    private Color color;
    public VisualModule(String text, Color color){
        this.text = text;
        this.color = color;
        this.setBackground(Color.BLACK);
    }
    
    public void updateState(String text, Color color){
        this.text = text;
        this.color = color;
        this.repaint(); // tells java to redraw the box
    }
    
    @Override //idk why it only works when this is here but it does soooo
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(5)); // Line thickness
        g2.setColor(color);
        g2.drawRoundRect(10, 10, getWidth() - 20, getHeight() - 20, 40, 40);
        
        // draw the text in the center, from one of the past assignments
        g2.setFont(new Font("DialogInput", Font.BOLD, 16));
        FontMetrics fm = g2.getFontMetrics();
        int textWidth = fm.stringWidth(text);
        int textHeight = fm.getAscent();
        g2.drawString(text, (getWidth() - textWidth) / 2, (getHeight() + textHeight) / 2);
        
    }
}