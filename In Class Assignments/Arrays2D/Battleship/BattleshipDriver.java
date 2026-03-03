package Battleship;

import java.util.Scanner;

public class BattleshipDriver {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Battleship!");

        // Setup playrs
        System.out.print(" > Player 1, what is your name? \n  : ");
        Player p1 = new Player(scan.nextLine());
        System.out.print(" > Player 2, what is your name? \n  : ");
        Player p2 = new Player(scan.nextLine());

        //Place ships
        p1.placeShips(scan);
        buffer("Press Enter twice to end turn...");
        bufferClear(p2.getName() + ", press Enter twice to start placing ships...");
        clearScreen();
        
        p2.placeShips(scan);
        buffer("Press Enter twice to end turn...");
        clearScreen();

        //Game loop
        boolean gameOver = false;
        Player currentPlayer = p1;
        Player enemyPlayer = p2;

        bufferClear(p1.getName() + ", press Enter twice to start turn...");
        
        while (!gameOver) {
            //Display boards
            currentPlayer.printBoards();

            //fire
            currentPlayer.takeTurn(enemyPlayer, scan);
            
            //check win
            if (enemyPlayer.hasLost()) {
                clearScreen();
                currentPlayer.printBoards();
                System.out.println("Game Over. " + currentPlayer.getName() + " wins");
                gameOver = true;
            } else {
                //swap player
                clearScreen();
                currentPlayer.printBoards();
                buffer("Press enter twice to end turn");
                clearScreen();
                Player temp = currentPlayer;
                currentPlayer = enemyPlayer;
                enemyPlayer = temp;

                bufferClear("Press Enter twice to start turn...");
                clearScreen();
            }
        }
    }
    
    public static void bufferClear(String str){
        clearScreen();
        System.out.println(str);
        try{scan.nextLine();scan.nextLine();}catch(Exception e){}
        clearScreen();
    }
    public static void buffer(String str){
        System.out.println(str);
        try{scan.nextLine();scan.nextLine();}catch(Exception e){}
    }
    public static void clearScreen() {
        System.out.print('\u000c'); // This works in BlueJ/standard terminals
    }
}