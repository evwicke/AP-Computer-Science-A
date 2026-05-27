import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Simon extends Module {
    private WordBank wordBank = new WordBank();
    private int level = 1;
    private ArrayList<String> LevelOneWords = new ArrayList<String>();
    private ArrayList<String> LevelTwoWords = new ArrayList<String>();
    private ArrayList<String> LevelThreeWords = new ArrayList<String>();

    private final int SECONDS_TO_DEFUSE = 20;
    private final double PUNISH_TIME = 1.5;
    private final double GRACE_TIME = 3;
    private long endTime; 
    private javax.swing.Timer miniTimer;

    public Simon(Bomb bomb, BombGUI gui) {
        super(bomb, gui);

        miniTimer = new javax.swing.Timer(10, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    long timeLeft = endTime - System.currentTimeMillis();

                    if (timeLeft <= 0) {
                        miniTimer.stop();
                        gui.updateModuleTimer(""); // Clear the clock from the screen
                        gui.printToConsole("OUT OF TIME!", Color.GREEN, 18);
                        bomb.addStrike();
                        bomb.exitModule();
                        return;
                    }

                    // Format the clock
                    long seconds = (timeLeft / 1000) % 60;
                    long milliseconds = timeLeft % 1000;
                    String timeString = String.format("SIMON: %02d:%03d", seconds, milliseconds);

                    gui.updateModuleTimer(timeString);
                }
            });
    }

    public void start() {
        gui.printToConsole("SIMON SAYS MODULE STARTED. TYPE EACH WORD ONE BY ONE.");
        gui.printToConsole("Type 'BACK' to exit.");
        simonGame();

        endTime = System.currentTimeMillis() + (1000 * SECONDS_TO_DEFUSE); 
        miniTimer.start(); 
    }

    public void handleInput(String input) {
        if (input.equals("BACK")) {
            miniTimer.stop(); 
            gui.updateModuleTimer(""); // Hide the clock
            gui.clearConsole();
            bomb.exitModule(); 
            return; 
        }

        boolean foundWord = false;

        switch(level) {
            case 1:
            for(int i = 0; i < LevelOneWords.size(); i++){
                if(LevelOneWords.get(i).equalsIgnoreCase(input)){
                    LevelOneWords.remove(i);
                    foundWord = true;
                    break;
                }
            }

            if (foundWord) {
                endTime += (1000*PUNISH_TIME);
                gui.printToConsole("+1.5s", Color.CYAN, 18);

                if (LevelOneWords.size() == 0) {
                    gui.clearConsole();
                    gui.printToConsole("LEVEL ONE COMPLETED. MOVING ON TO LEVEL TWO.", Color.GREEN, 18);
                    level = 2; 
                    gui.printToConsole("LEVEL 2", Color.MAGENTA, 18);
                    printWords(2, LevelTwoWords);
                } else {
                    printNewWords(LevelOneWords); 
                }
            } else {
                endTime -= (1000*GRACE_TIME);
                gui.printToConsole("WRONG WORD!", Color.RED, 18);
                bomb.addStrike();
            }
            break;

            case 2:
            for(int i = 0; i < LevelTwoWords.size(); i++){
                if(LevelTwoWords.get(i).equalsIgnoreCase(input)){
                    LevelTwoWords.remove(i);
                    foundWord = true;
                    break;
                }
            }

            if (foundWord) {
                endTime += (1000*PUNISH_TIME); 
                gui.printToConsole("+1.5s", Color.CYAN, 18);

                if (LevelTwoWords.size() == 0) {
                    gui.clearConsole();
                    gui.printToConsole("LEVEL TWO COMPLETED. MOVING ON TO LEVEL THREE.", Color.GREEN, 18);
                    level = 3; 
                    gui.printToConsole("LEVEL 3", Color.MAGENTA, 18);
                    printWords(3, LevelThreeWords);
                } else {
                    printNewWords(LevelTwoWords); 
                }
            } else {
                endTime -= (1000*GRACE_TIME);
                gui.printToConsole("WRONG WORD!", Color.RED, 18);
                bomb.addStrike();
            }
            break;

            case 3:
            for(int i = 0; i < LevelThreeWords.size(); i++){
                if(LevelThreeWords.get(i).equalsIgnoreCase(input)){
                    LevelThreeWords.remove(i);
                    foundWord = true;
                    break;
                }
            }

            if (foundWord) {
                endTime += (1000*PUNISH_TIME);
                gui.printToConsole("+1.5s", Color.CYAN, 18);

                if (LevelThreeWords.size() == 0) {
                    miniTimer.stop(); 
                    gui.updateModuleTimer(""); 
                    gui.printToConsole("LEVEL THREE COMPLETED. MODULE DEFUSED!", Color.GREEN, 18);
                    this.isDefused = true;
                    bomb.moduleSolved(); 
                } else {
                    printNewWords(LevelThreeWords); 
                }
            } else {
                endTime -= (1000*GRACE_TIME);
                gui.printToConsole("WRONG WORD!", Color.PINK, 18);
                bomb.addStrike();
            }
            break;
        }
    }

    private void simonGame(){
        gui.printToConsole("LEVEL 1", Color.MAGENTA, 18);
        printWords(1, LevelOneWords);
    }

    private void printNewWords(ArrayList<String> list){
        String returner = "";
        for(String s : list){returner+= (s + " ");}
        gui.printToConsole(returner.trim(), Color.MAGENTA, 18);
    }

    private void printWords(int level, ArrayList<String> list){
        for(int i = 0; i<(level + 2); i++){
            String foundWord = wordBank.getWord("hard");
            while(list.indexOf(foundWord)!= -1){
                foundWord = wordBank.getWord("hard");
            }
            list.add(foundWord);
        }

        String returner = "";
        for(String s : list){returner+= (s + " ");}
        gui.printToConsole(returner.trim(), Color.MAGENTA, 18);
    }
}