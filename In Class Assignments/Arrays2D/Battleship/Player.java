package Battleship;

import java.util.Scanner;

public class Player {
    private String name;
    private BSBoard shipBoard;    // Where my ships are
    private BSBoard torpedoBoard; // Where I record my shots

    // Ship lengths
    private final int BATTLESHIP = 5;
    private final int DESTROYER = 4;
    private final int CRUISER = 3;
    
    /**
     * Constructs a player with a name, a ship board and a torpedo board
     */
    public Player(String name) {
        this.name = name;
        this.shipBoard = new BSBoard();
        this.torpedoBoard = new BSBoard();
    }

    /**
     * Just a getter for getting the name of the player. Used for CURRENT_PLAYER logic in the driver
     */
    public String getName() {
        return name;
    }

    /**
     * Just prints the boards of the player.
     */
    public void printBoards() {
        System.out.println(name + "'s Torpedo Board:");
        torpedoBoard.printBoard();
        System.out.println("------------------------------------------");
        System.out.println(name + "'s Ship Board:");
        shipBoard.printBoard();
    }

    /**
     * Takes a row char and returns the index it is from
     */
    private int rowCharToInt(char c) {
        return c - 'A';
    }

    /**
     * Calls the place ship method for all 3 ships.
     */
    public void placeShips(Scanner scan) {
        //clearScreen(); not at the top cuz its gonna clear in the bufferClear(); method in the client.
        //loop:
        /* Clear last one
         * Print the new baord
         * Place the ship
         */
        System.out.println(name + ", place your ships.");
        shipBoard.printBoard();
        placeSingleShip(scan, BATTLESHIP, "Battleship");
        
        clearScreen();
        System.out.println(name + ", place your ships.");
        shipBoard.printBoard();
        placeSingleShip(scan, DESTROYER, "Destroyer");
        
        clearScreen();
        System.out.println(name + ", place your ships.");
        shipBoard.printBoard();
        placeSingleShip(scan, CRUISER, "Cruiser");
        
        clearScreen();
        System.out.println(name + ", This is the location of your ships.");
        shipBoard.printBoard();
    }

    /**
     * This one was hard. Takes in the ships name and size and a scanner object for user input
     * Void method but it modifies the player's shipBoard.
     */
    private void placeSingleShip(Scanner scan, int size, String shipName) {
        boolean placed = false;
        String shipLetter = shipName.substring(0, 1); // the letter it shows on the board is the first letter of the ship name
        while (!placed) {
            System.out.println("Placing " + shipName + " (Length " + size + ")");
            System.out.print(" > Enter coordinates (e.g. A4): ");
            String coord = scan.nextLine();
            System.out.print(" > Enter direction (u, d, l, r): ");
            char dir = (scan.nextLine().charAt(0));
                
            int startRow;
            int startCol;
            
            try{
                startRow = rowCharToInt(coord.charAt(0)); // turns the letter into a number
                startCol = Integer.parseInt(coord.substring(1)) - 1; // takes the substring string type number and turns it to int, then -1 to index properly
                
            } catch (Exception e) {
                System.out.println("Invalid coordinate format. Try again (A4).");
                continue; // goes ALL the way around to the top of the innermost loop (for a for loop its within the next iteration). 
                          //(in this case, it is the top of the while loop.)
            }

            // ERROR CHECKINNGGGG!!!!!!!!
            boolean possible = true;
            // setting it to be possible, if at any time it doesnt work, it will restart the whole while loop.
            //first check if the ship will fit on the board
            for (int i = 0; i < size; i++) {
                int r = startRow;
                int c = startCol;

                if (dir == 'u') { r = startRow - i; }
                else if (dir == 'd') { r = startRow + i; }
                else if (dir == 'l') { c = startCol - i; }
                else if (dir == 'r') { c = startCol + i; }
                else {
                    System.out.println("Invalid direction. Use u, d, l, or r.");
                    possible = false;
                    break; // need to pop out of the loop. it doesnt work.
                }
                // is this value even valid? will check all of them
                if (!(shipBoard.isValidPosition(r, c) && shipBoard.isCellEmpty(r, c))) {
                    // DEMORGANS RULE ( !A OR !B == !(A AND B) ).
                    possible = false;
                    break; // Stop checking, it won't fit
                }
            }

            if(possible) {
                // ok so we know it fits.
                for (int i = 0; i < size; i++) {
                    int r = startRow;
                    int c = startCol;

                    if (dir == 'u') { r = startRow - i; }
                    else if (dir == 'd') { r = startRow + i; }
                    else if (dir == 'l') { c = startCol - i; }
                    else if (dir == 'r') { c = startCol + i; }
                    //update the shipBoard.
                    shipBoard.updateCell(r, c, shipLetter);
                }
                placed = true; // Break the while loop
            } else {
                System.out.println("Error: Ship does not fit or overlaps another ship. Try again.");
            }
        }
    }

    /**
     * Takes in the enemy player and a scanner object.
     * modifies the enemy's shipboard and the player's torpedoBoard.
     */
    public void takeTurn(Player enemy, Scanner scan) {
        System.out.println(name + "'s Turn to fire!");
        boolean validShot = false;
        int startRow;
        int startCol;
        
        while(!validShot) {
            /*----------------------------*/
            //youve already seen all of this in the last one
            System.out.print(" > Enter coordinates (e.g. A4): ");
            String coord = scan.nextLine();

            try{
                startRow = rowCharToInt(coord.charAt(0));
                startCol = Integer.parseInt(coord.substring(1)) - 1;
                
            } catch (Exception e) {
                System.out.println(" > Invalid coordinate format. Try again (A4).");
                continue;
            }
            /*----------------------------*/
            if(startRow > 9 || startCol > 9){
                System.out.println(" > Invalid torpedo spot. Try again.");
                continue;
            }
            
            String myTorp = torpedoBoard.getCell(startRow, startCol); 
            // myTorp is the value of the row/col of the torpedoboard that is selected by the user.
            String enem = enemy.shipBoard.getCell(startRow, startCol);
            // enem is the value of the row/col of the enemy shipboard that is selected by the user.
            if(myTorp.equals("X") || myTorp.equals("O")){
                System.out.println(" > You've already shot here. Try again.");
                continue; // go back to the top of the while loop.
            }else if(enem.equals("B") || enem.equals("C") || enem.equals("D")){
                enemy.shipBoard.updateCell(startRow, startCol,"X");
                torpedoBoard.updateCell(startRow, startCol,"X");
            }else{
                torpedoBoard.updateCell(startRow, startCol,"O");
            }

            validShot = true; // end while loop.
        }
    }
    /**
     * Returns bool based on whether the player's shipboard doesnt have any ships left.
     */
    public boolean hasLost() {
        return shipBoard.allShipsSunk();
    }
    public static void clearScreen() {
        System.out.print('\u000c'); // This works in BlueJ/standard terminals
    }
}