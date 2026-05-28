import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Scramble extends Module {
    private String secretWord;
    private WordBank wordBank = new WordBank();
    
    public Scramble(Bomb bomb, BombGUI gui) {
        super(bomb, gui);
        secretWord = wordBank.getWord("easy");
    }

    public void start() {
        gui.printToConsole("SCRAMBLE DEFUSAL STARTED.");
        gui.printToConsole("Type 'BACK' to exit.");
        gui.printToConsole(wordScrambler(secretWord.length(), secretWord), Color.MAGENTA, 18);
    }

    public void handleInput(String input) {
        if (input.equals("BACK")) {
            gui.clearConsole();
            bomb.exitModule();
        }else if(input.equals("DEVSOLVE")){
            gui.clearConsole();
            bomb.moduleSolved(); 
            return;
        }else if(input.toLowerCase().equals(secretWord.toLowerCase())){
            gui.clearConsole();
            bomb.moduleSolved();
        }else{
            gui.printToConsole(" Input Incorrect ");
            bomb.addStrike();
        }
    }
    
    public static String wordScrambler(int steps, String word){
        String[] split = word.split("");
        ArrayList<String> splitList = new ArrayList<String>();
        for(String c : split){splitList.add(c);}

        for(int i = 0; i < steps; i++){
            splitList.add((int)(Math.random()*word.length() -1), splitList.remove(i));
        }
        
        String fin = "";
        for(String c : splitList){fin +=c;};
        return fin;
    }
}