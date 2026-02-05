package Arrays2D.Battleship;

import java.util.Scanner;

public class BattleshipDriver {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Battleship!");

        // Setup playrs
        // TODO: Let them name themselves
        Player p1 = new Player("Player 1");
        Player p2 = new Player("Player 2");

        //Place ships
        p1.placeShips(scan);
        clearScreen();
        p2.placeShips(scan);
        clearScreen();

        //Game loop
        boolean gameOver = false;
        Player currentPlayer = p1;
        Player enemyPlayer = p2;

        while (!gameOver) {
            //Display boards
            currentPlayer.printBoards();

            //fire
            currentPlayer.takeTurn(enemyPlayer, scan);

            //check win
            if (enemyPlayer.hasLost()) {
                System.out.println("Game Over. " + currentPlayer.getName() + " wins");
                gameOver = true;
            } else {
                //swap player
                Player temp = currentPlayer;
                currentPlayer = enemyPlayer;
                enemyPlayer = temp;


                System.out.println("Press Enter to start turn...");
                try{scan.next();}catch(Exception e){}
                clearScreen();
            }
        }
    }

    public static void clearScreen() {
        System.out.print('\u000c'); // This works in BlueJ/standard terminals
    }
}