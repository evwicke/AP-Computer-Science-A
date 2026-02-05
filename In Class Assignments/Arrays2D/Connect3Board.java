 
import java.util.Scanner;
public class Connect3Board{
    private int rows;
    private int cols;
    private String[][] layout;

    public Connect3Board(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        this.layout = new String[rows][cols]; 
        resetBoard(layout);
    }

    public Connect3Board(){
        this.rows = 3;
        this.cols = 4;
        this.layout = new String[rows][cols]; 
        resetBoard(layout);
    }

    private void resetBoard(String[][] arr2D){
        for(int i=0; i<arr2D.length; i++){
            for(int j=0; j<arr2D[i].length; j++){
                arr2D[i][j] = "_";
            }   
        }
    }

    public void gravDrop(int col, String player, Scanner scan) {
        if (col < 0 || col >= this.cols) {
            System.out.print("Please choose a column between 1 and " + this.cols + "\n : ");
            int newCol = scan.nextInt() - 1;
            gravDrop(newCol, player, scan);
            return;
        }

        if (!layout[0][col].equals("_")) {
            System.out.print("Column " + (col + 1) + " is full. Choose another. \n : ");
            int newCol = scan.nextInt() - 1;
            gravDrop(newCol, player, scan);
            return;
        }

        for (int i = layout.length - 1; i >= 0; i--) {
            if (layout[i][col].equals("_")) {
                layout[i][col] = player;
                return; 
            }
        }
    }

    public boolean spaceFilled(int row, int col){
        if(layout[row-1][col-1].equals("_")){
            return false;
        }else{
            return true;
        }
    }

    public void print(){
        System.out.print("    ");
        for(int k = 1; k<cols+1; k++){System.out.printf("%-3s ", k);} System.out.println();
        for(int i=0; i<layout.length; i++){
            System.out.printf(" %-2s ", "");
            for(int j=0; j<layout[i].length; j++){
                System.out.printf("%-3s ", layout[i][j]);
            }   
            System.out.println();
        }
    }

    public String checkForWinner() {
        //(Rows)  
        /* Starts at #, checks both X's
         * # X X
         * _ _ _
         * _ _ _
         */
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols - 2; c++) {
                String current = layout[r][c];
                if (!current.equals("_") &&
                current.equals(layout[r][c+1]) &&
                current.equals(layout[r][c+2])) {
                    return current;
                }
            }
        }

        //(Columns)
        /* Starts at #, checks both X's
         * # _ _
         * X _ _
         * X _ _
         */
        for (int r = 0; r < rows - 2; r++) {
            for (int c = 0; c < cols; c++) {
                String current = layout[r][c];
                if (!current.equals("_") &&
                current.equals(layout[r+1][c]) &&
                current.equals(layout[r+2][c])) {
                    return current;
                }
            }
        }

        //(\)
        /* Starts at #, checks both X's
         * # _ _
         * _ X _
         * _ _ X
         */
        for (int r = 0; r < rows - 2; r++) {
            for (int c = 0; c < cols - 2; c++) {
                String current = layout[r][c];
                if (!current.equals("_") &&
                current.equals(layout[r+1][c+1]) &&
                current.equals(layout[r+2][c+2])) {
                    return current;
                }
            }
        }

        //(/)
        /* Starts at #, checks both X's
         * _ _ X
         * _ X _
         * # _ _
         */
        for (int r = 0; r < rows - 2; r++) {
            for (int c = 2; c < cols; c++) {
                String current = layout[r][c];
                if (!current.equals("_") &&
                current.equals(layout[r+1][c-1]) &&
                current.equals(layout[r+2][c-2])) {
                    return current;
                }
            }
        }

        return null; //nothing found.
    }

}
