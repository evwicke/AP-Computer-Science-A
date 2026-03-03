package Battleship;

import java.util.Scanner;

public class BSBoard {
    private int rows = 10;
    private int cols = 10;
    private String[][] layout;

    public BSBoard() {
        this.layout = new String[rows][cols];
        resetBoard(); // Fill with dashes
    }

    /**
     * Just sets all values in the board to "-"
     */
    private void resetBoard() {
        for(int i=0; i<layout.length; i++){
            for(int j=0; j<layout[i].length; j++){
                layout[i][j] = "-";
            }
        }
    }

    /**
     * Loops thru the board and prints it. the first for loop is the top row # thing and
     * the second for loop is the letters down the side (using chars) and the actual value within
     */
    public void printBoard() {
        System.out.print("    ");
        // top row numbers
        for(int k = 1; k<cols+1; k++){System.out.printf("%-3s ", k);} System.out.println();
        for(int i=0; i<layout.length; i++){
            /*The side letter numbers*/
            System.out.printf(" %-2s ", (char)(i+65)); 
            //printf(" %-2s") basically makes it so the variable takes up a MINIMUM of 2 spaces
            //for example, printf("%-4s", (num from 0-1000)) returns any of these 3 outputs ( without the pipe characters ):
            /* |1   |, etc
             * |1000|, etc
             * |230 |, etc      */
            for(int j=0; j<layout[i].length; j++){
                System.out.printf("%-3s ", layout[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * Checks if a coordinate is valid
     */
    public boolean isValidPosition(int r, int c) {
        if(r >= 0 && r < rows && c >= 0 && c < cols){
            return true;
        }else {
            return false;
        }
    }

    /**
     * Checks if a cell is already occupied by a ship
     */
    public boolean isCellEmpty(int r, int c) {
        if(layout[r][c].equals("-")){
            return true;
        }else {
            return false;
        }
    }

    /**
     * Updates a cell
     */
    public void updateCell(int r, int c, String value) {
        layout[r][c] = value;
    }

    /**
     * Returns what is at a specific cell
     */
    public String getCell(int r, int c) {
        return layout[r][c];
    }

    /**
     * Returns a bool based on if all of the values in the ship board is NOT B D or C
     *  or.. == (!B and !D and !C) == !(B or D or C)
     */
    public boolean allShipsSunk() {
        for(int i=0; i<layout.length; i++){
            for(int j=0; j<layout[i].length; j++){
                if(getCell(i,j).equals("B") || getCell(i,j).equals("D") || getCell(i,j).equals("C")){
                    return false;
                }
            }
        }
        return true;
    }
}

