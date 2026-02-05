package Arrays2D.Battleship;

import java.util.Scanner;

public class BSBoard {
    private int rows = 10;
    private int cols = 10;
    private String[][] layout;

    public BSBoard() {
        this.layout = new String[rows][cols];
        resetBoard(); // Fill with dashes
    }

    private void resetBoard() {
        for(int i=0; i<layout.length; i++){
            for(int j=0; j<layout[i].length; j++){
                layout[i][j] = "-";
            }
        }
    }

    public void printBoard() {
        System.out.print("    ");
        for(int k = 1; k<cols+1; k++){System.out.printf("%-3s ", k);} System.out.println();
        for(int i=0; i<layout.length; i++){
            System.out.printf(" %-2s ", (char)(i+65));
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

