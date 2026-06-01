import java.awt.Color;
import javax.swing.Timer;
import java.awt.event.*;

public class Override extends Module {
    private String target = "OVERRIDEbombDEFUSAL2918-%%$#@?ACTIVATE";
    private Timer miniTimer;
    private int time = 30 * 1000; // seconds
    private long endTime;
    public Override(Bomb bomb, BombGUI gui) {
        super(bomb, gui);
        miniTimer = new javax.swing.Timer(10, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    long timeLeft = endTime - System.currentTimeMillis();

                    if (timeLeft <= 0) {
                        miniTimer.stop();
                        gui.updateModuleTimer("");
                        gui.printToConsole("OVERRIDE FAILED!", Color.RED, 24);
                        bomb.explode();
                        return;
                    }

                    long seconds = (timeLeft / 1000) % 60;
                    long milliseconds = timeLeft % 1000;
                    String timeString = String.format("OVERRIDE: %02d:%03d", seconds, milliseconds);

                    gui.updateModuleTimer(timeString);
                }
            });

    }

    public void start() {
        gui.printToConsole("!!! FINAL OVERRIDE REQUIRED !!!", Color.RED, 20);
        gui.printToConsole("TYPE THIS EXACTLY:", Color.WHITE, 16);
        gui.printToConsole(target, Color.CYAN, 20);
        endTime = (System.currentTimeMillis() + time);
        miniTimer.start();
    }

    public void handleInput(String input) {
        if (input.equalsIgnoreCase(target)) {
            miniTimer.stop();
            gui.updateModuleTimer("");
            gui.clearConsole();
            gui.printToConsole("OVERRIDE SUCCESSFUL", Color.GREEN, 24);
            bomb.moduleSolved(); 
        } else if(input.equals("DEVSOLVE")){
            miniTimer.stop();
            gui.updateModuleTimer(""); // Hide the clock
            gui.clearConsole();
            bomb.moduleSolved(); 
            return;
        }else{
            bomb.addStrike();
        }
    }
}