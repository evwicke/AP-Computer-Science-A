
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bomb {
    private BombGUI gui;
    private int strikes;
    
    //i will put the modules here
    // private Module[] modules;
    // private Module activeModule;

    public Bomb(BombGUI gui) {
        this.gui = gui;
        this.strikes = 0;
        
        // initialize modules
        // Print the starting boot-up sequence
    }

    public void receiveCommand(String command) {
        //Later i will pass this down to activeModule.processInput()
        if (command.equals("HELP")) {
            gui.printToConsole("COMMANDS: STATUS, MASTERMIND, CIPHER, SIMON");
        } 
        else if (command.equals("STATUS")) {
            gui.printToConsole("STRIKES: " + strikes + "/3", Color.RED);
        }
        else if (command.equals("EXPLODE")) {
            // test command
            explode();
        }
        else {
            gui.printToConsole("COMMAND NOT RECOGNIZED.");
            
            //will move this eventually
            strikes++;
            gui.printToConsole("STRIKE " + strikes + " ADDED!");
            
            if (strikes >= 3) {
                explode();
            }
        }
    }
    public void explode(){
        gui.clearConsole();
        gui.changeBGColor(Color.RED);
    }
}