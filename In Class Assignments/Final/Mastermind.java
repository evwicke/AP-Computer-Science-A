import java.awt.Color;

public class Mastermind extends Module {

    private String[] colorBank = {"RED", "BLUE", "GREEN", "YELLOW", "ORANGE", "PURPLE", "PINK"};
    private String[] secretCode;
    private int guessesRemaining;

    public Mastermind(Bomb bomb, BombGUI gui) {
        super(bomb, gui);
        secretCode = new String[7];
        guessesRemaining = 5;
    }

    public void start() {
        for (int i = 0; i < 7; i++) {
            int randomIndex = (int)(Math.random() * colorBank.length);
            secretCode[i] = colorBank[randomIndex];
        }

        gui.printToConsole("MASTERMIND MODULE STARTED.", Color.MAGENTA, 18);
        gui.printToConsole("COLORS: RED, BLUE, GREEN, YELLOW, ORANGE, PURPLE, PINK", Color.WHITE, 16);
        gui.printToConsole("ENTER 4 COLORS SEPARATED BY SPACES (ex: 'RED BLUE RED GREEN')");
        gui.printToConsole("Type 'BACK' to exit.");
        gui.printToConsole("Guesses remaining: " + guessesRemaining, Color.YELLOW, 16);
    }

    public void handleInput(String input) {
        if (input.equals("BACK")) {
            gui.clearConsole();
            bomb.exitModule();
            return;
        }
        if(input.equals("DEVSOLVE")){
            gui.clearConsole();
            bomb.moduleSolved(); 
            return;
        }
        // split typing by spaces into a String array
        String[] guess = input.split(" ");

        if (guess.length != 4) {
            gui.printToConsole("ERROR", Color.RED, 16);
            return;
        }

        int exactMatches = 0;
        boolean[] secretUsed = new boolean[4];
        boolean[] guessUsed = new boolean[4];
        
        Color[] feedbackColors = new Color[4];
        
        // assume every guess is wrong as a base case
        for (int i = 0; i < 4; i++) {
            feedbackColors[i] = Color.RED;
        }

        // exact match
        for (int i = 0; i < 4; i++) {
            if (guess[i].equalsIgnoreCase(secretCode[i])) {
                exactMatches++;
                secretUsed[i] = true;
                guessUsed[i] = true;
                feedbackColors[i] = Color.GREEN; 
            }
        }

        // partial matches
        for (int i = 0; i < 4; i++) {
            if (!guessUsed[i]) {
                for (int j = 0; j < 4; j++) {
                    if (!secretUsed[j] && guess[i].equalsIgnoreCase(secretCode[j])) {
                        secretUsed[j] = true;
                        feedbackColors[i] = Color.YELLOW; 
                        break;
                    }
                }
            }
        }

        gui.printInline("   ", Color.WHITE, 16); // small indent to line it up
        for (int i = 0; i < 4; i++) {
            // Print each word on the same line using its assigned color!
            gui.printInline(guess[i].toUpperCase() + " ", feedbackColors[i], 16);
        }
        gui.printToConsole(""); // Prints a blank line break to reset for the next turn

        // Process win/loss
        if (exactMatches == 4) {
            gui.clearConsole();
            gui.printToConsole("MASTERMIND DEFUSED.", Color.GREEN, 18);
            this.isDefused = true;
            bomb.moduleSolved();
        } else {
            guessesRemaining--;

            if (guessesRemaining <= 0) {
                gui.clearConsole();
                gui.printToConsole("OUT OF GUESSES", Color.RED, 18);
                gui.printToConsole("THE CODE WAS: " + String.join(" ", secretCode), Color.WHITE, 16);
                bomb.addStrike();
                bomb.exitModule(); // Kick them out with a strike
            } else {
                gui.printToConsole("Guesses remaining: " + guessesRemaining, Color.GRAY, 14);
            }
        }
    }
}