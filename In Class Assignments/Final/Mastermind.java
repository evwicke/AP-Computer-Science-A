public class Mastermind extends Module {
    public Mastermind(Bomb bomb, BombGUI gui) {
        super(bomb, gui);
    }

    public void start() {
        gui.printToConsole("MASTERMIND MODULE STARTED.");
        gui.printToConsole("Type 'BACK' to exit.");
    }

    public void handleInput(String input) {
        if (input.equals("BACK")) {
            gui.clearConsole();
            bomb.exitModule(); 
        }else if(input.equals("DEVSOLVE")){
            gui.clearConsole();
            bomb.moduleSolved();
        }
    }
}