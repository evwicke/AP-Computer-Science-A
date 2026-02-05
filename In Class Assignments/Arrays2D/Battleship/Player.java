package Arrays2D.Battleship;

import java.util.Scanner;

public class Player {

    private String name;
    private BSBoard shipBoard;    // Where my ships are
    private BSBoard torpedoBoard; // Where I record my shots

    // Ship lengths
    private final int BATTLESHIP = 5;
    private final int DESTROYER = 4;
    private final int CRUISER = 3;

    public Player(String name) {
        this.name = name;
        this.shipBoard = new BSBoard();
        this.torpedoBoard = new BSBoard();
    }

    public String getName() {
        return name;
    }

    public void printBoards() {
        System.out.println(name + "'s Torpedo Board:");
        torpedoBoard.printBoard();
        System.out.println("-----------------------");
        System.out.println(name + "'s Ship Board:");
        shipBoard.printBoard();
    }

    /**
     * Takes a row char and returns the index it is from
     */
    private int rowCharToInt(char c) {
        return c - 'A';
    }

    // TODO: THIS WHOLE METHOD
    public void placeShips(Scanner scan) {
        System.out.println(name + ", place your ships.");
        shipBoard.printBoard();

        // placeSingleShip(scan, BATTLESHIP, "Battleship");
        // placeSingleShip(scan, CRUISER, "Cruiser");
        // placeSingleShip(scan, DESTROYER, "Destroyer");
    }

    private void placeSingleShip(Scanner scan, int size, String shipName) {
        boolean placed = false;
        String shipLetter = shipName.substring(0, 1);
        while (!placed) {
            System.out.println("Placing " + shipName + " (Length " + size + ")");
            System.out.print("Enter coordinates (e.g. A4): ");
            String coord = scan.next();
            System.out.print("Enter direction (u, d, l, r): ");
            char dir = scan.next().charAt(0);

            int startRow;
            int startCol;
            
            try{
                startRow = rowCharToInt(coord.charAt(0));
                startCol = Integer.parseInt(coord.substring(1)) - 1;
                
            } catch (Exception e) {
                System.out.println("Invalid coordinate format. Try again (A4).");
                continue;
            }

            // ERROR CHECKINNGGGG!!!!!!!!
            boolean possible = true;

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
                    break;
                }
                // is this value even valid? will check all of them
                if (!(shipBoard.isValidPosition(r, c) && shipBoard.isCellEmpty(r, c))) {
                    // DEMORGANS RULE ( !A OR !B == !(A AND B) ).
                    possible = false;
                    break; // Stop checking, it won't fit
                }
            }

            // ok so we know it fits.
            if(possible) {
                for (int i = 0; i < size; i++) {
                    int r = startRow;
                    int c = startCol;

                    if (dir == 'u') { r = startRow - i; }
                    else if (dir == 'd') { r = startRow + i; }
                    else if (dir == 'l') { c = startCol - i; }
                    else if (dir == 'r') { c = startCol + i; }

                    shipBoard.updateCell(r, c, shipLetter);
                }
                placed = true; // Break the while loop
            } else {
                System.out.println("Error: Ship does not fit or overlaps another ship. Try again.");
            }
        }
    }

    // TODO: THIS WHOLE METHOD
    public void takeTurn(Player enemy, Scanner scan) {
        System.out.println(name + "'s Turn to fire!");
        boolean validShot = false;

        while(!validShot) {
            System.out.print("Enter coordinates to fire: ");
            String coord = scan.next();

            // TODO: Parse coord
            // TODO: Check if you already fired there

            // If valid:
            // Check enemy.shipBoard.getCell(r, c)
            // If hit: Update enemy.shipBoard to "X", update my torpedoBoard to "X"
            // If miss: Update my torpedoBoard to "O"

            validShot = true;
        }
    }

    public boolean hasLost() {
        return shipBoard.allShipsSunk();
    }
}

