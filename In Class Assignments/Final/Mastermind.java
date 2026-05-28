import java.awt.Color;

public class Mastermind extends Module {

    private String[] colorBank = {"RED", "BLUE", "GREEN", "YELLOW", "ORANGE"};
    private String[] secretCode;
    private int guessesRemaining;

    public Mastermind(Bomb bomb, BombGUI gui) {
        super(bomb, gui);
        secretCode = new String[4];
        guessesRemaining = 8;
    }

    public void start() {
        for (int i = 0; i < 4; i++) {
            int randomIndex = (int)(Math.random() * colorBank.length);
            secretCode[i] = colorBank[randomIndex];
        }

        gui.printToConsole("MASTERMIND MODULE STARTED.", Color.MAGENTA, 18);
        gui.printToConsole("COLORS: RED, BLUE, GREEN, YELLOW, ORANGE", Color.WHITE, 16);
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

        // split typing by spaces into a String array
        String[] guess = input.split(" ");

        if (guess.length != 4) {
            gui.printToConsole("ERROR", Color.RED, 16);
            return;
        }

        int exactMatches = 0;
        int partialMatches = 0;

        boolean[] secretUsed = new boolean[4];
        boolean[] guessUsed = new boolean[4];

        // exact matches
        for (int i = 0; i < 4; i++) {
            if (guess[i].equalsIgnoreCase(secretCode[i])) {
                exactMatches++;
                secretUsed[i] = true;
                guessUsed[i] = true;
            }
        }

        // partial matches
        for (int i = 0; i < 4; i++) {
            if (!guessUsed[i]) {
                for (int j = 0; j < 4; j++) {
                    if (!secretUsed[j] && guess[i].equalsIgnoreCase(secretCode[j])) {
                        partialMatches++;
                        secretUsed[j] = true;
                        break;
                    }
                }
            }
        }

        // process
        if (exactMatches == 4) {
            gui.clearConsole();
            gui.printToConsole("MASTERMIND DEFUSED.", Color.GREEN, 18);
            this.isDefused = true;
            bomb.moduleSolved();
        } else {
            guessesRemaining--;
            gui.printToConsole("RESULTS: " + exactMatches + " Exact, " + partialMatches + " Partial.", Color.CYAN, 16);

            if (guessesRemaining <= 0) {
                gui.clearConsole();
                gui.printToConsole("OUT OF GUESSES", Color.RED, 18);
                gui.printToConsole("THE CODE WAS: " + String.join(" ", secretCode), Color.WHITE, 16);
                bomb.addStrike();
            } else {
                gui.printToConsole("Guesses remaining: " + guessesRemaining, Color.YELLOW, 16);
            }
        }
    }
}