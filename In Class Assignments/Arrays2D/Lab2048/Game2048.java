package Lab2048;
import java.io.*;                   
import java.util.Scanner;          
import java.util.ArrayList; 
/**
 * Game2048.java  
 *
 * @author – Your name
 * @author – Class period
 *
 */  
public class Game2048
{
    private int[][] gameBoard;
    private int score;
    private int boardSize;   
    private final int WIN_CONDITION = 2048;

    public Game2048()
    {
        boardSize = 4;
        gameBoard = new int[boardSize][boardSize];
        score = 0;
        add2ToBoard();
        add2ToBoard();
    }

    public void add2ToBoard()
    {
        boolean looking = true;
        while(looking){
            int x_val = (int)(Math.random() * boardSize);
            int y_val = (int)(Math.random() * boardSize);

            if(gameBoard[x_val][y_val] == 0){
                gameBoard[x_val][y_val] = 2;
                looking = false;
            }else{
                continue;
            }
        }
    }      

    public void moveLeft()
    {
        for(int r = 0; r < boardSize; r++){
            for(int c = 1; c < boardSize; c++){
                if (gameBoard[r][c] != 0){
                    int current = c;
                    while (current > 0 && gameBoard[r][current - 1] == 0){
                        gameBoard[r][current - 1] = gameBoard[r][current];
                        gameBoard[r][current] = 0;
                        current--;
                    }
                }
            }
        }
    }

    public void moveRight()
    {
        /*
         *  - - - -
         *  - 2 - -
         *  - - 4 -
         *  - 2 - -
         *  
         *  Starts on the top row and the second to last column. checks if its not a zero. If it is, it will go left
         *  to the next value to the left. If it isnt a zero, it goes through this logic:
         *  while the current column is less than the last index and the value to the right is a zero:
         *  move the value over and overwrite the 0. then cover up your tracks and set the original value to 0.
         *  then move over the column 1 and do it again.
         */

        for(int r = 0; r < boardSize; r++){
            for(int c = boardSize-2; c >= 0; c--){
                if (gameBoard[r][c] != 0){
                    int current = c;
                    while (current < boardSize-1 && gameBoard[r][current + 1] == 0){
                        gameBoard[r][current + 1] = gameBoard[r][current];
                        gameBoard[r][current] = 0;
                        current++;
                    }
                }
            }
        }
    }

    public void moveUp()
    {
        for(int c = 0; c < boardSize; c++){
            for(int r = 1; r < boardSize; r++){
                if(gameBoard[r][c] != 0){
                    int current = r;
                    while(current > 0 && gameBoard[current - 1][c] == 0){
                        gameBoard[current - 1][c] = gameBoard[current][c];
                        gameBoard[current][c] = 0;
                        current--;
                    }
                }
            }
        }
    }

    public void moveDown(){
        for(int c = 0; c < boardSize; c++){ 
            for(int r = 0; r < boardSize; r++){
                if(gameBoard[r][c] != 0){
                    int current = r;
                    while(current < boardSize-1 && gameBoard[current + 1][c] == 0){
                        gameBoard[current + 1][c] = gameBoard[current][c];
                        gameBoard[current][c] = 0;
                        current++;
                    }
                }
            }
        }
    }

    public void mergeLeft(){
        for(int r = 0; r < boardSize; r++){
            for(int c = 0; c < boardSize-1; c++){
                if (gameBoard[r][c] != 0 && gameBoard[r][c+1] == gameBoard[r][c]){
                    gameBoard[r][c] *= 2;
                    gameBoard[r][c+1] = 0;
                }
            }
        }
    }

    public void mergeRight(){
        for(int r = 0; r < boardSize; r++){
            for(int c = boardSize - 1; c > 0; c--){
                if (gameBoard[r][c] != 0 && gameBoard[r][c-1] == gameBoard[r][c]){
                    gameBoard[r][c] *= 2;
                    gameBoard[r][c-1] = 0;
                }
            }
        }
    }

    public void mergeUp(){
        for(int c = 0; c < boardSize; c++){
            for(int r = 0; r < boardSize-1; r++){
                if (gameBoard[r][c] != 0 && gameBoard[r+1][c] == gameBoard[r][c]){
                    gameBoard[r][c] *= 2;
                    gameBoard[r+1][c] = 0;
                }
            }
        }
    }

    public void mergeDown(){
        for (int c = 0; c < boardSize; c++) {
            for (int r = boardSize - 1; r > 0; r--) {
                if (gameBoard[r][c] != 0 && gameBoard[r][c] == gameBoard[r-1][c]) {
                    gameBoard[r][c] *= 2;
                    gameBoard[r-1][c] = 0;
                }
            }
        }
    }

    public boolean gameOver()
    {
        //Check for Win
        for (int r = 0; r < boardSize; r++) {
            for (int c = 0; c < boardSize; c++) {
                if (gameBoard[r][c] == WIN_CONDITION) {
                    return true;
                }
                if (gameBoard[r][c] == 0) {
                    return false; 
                }
            }
        }
        //Check for Possible Merges
        for (int r = 0; r < boardSize; r++) {
            for (int c = 0; c < boardSize; c++) {
                if (c < boardSize - 1 && gameBoard[r][c] == gameBoard[r][c+1]) {
                    return false;
                }
                if (r < boardSize - 1 && gameBoard[r][c] == gameBoard[r+1][c]) {
                    return false;
                }
            }
        }
        //No empty spots and no merges possible.
        return true;
    } 

    public void displayBoard()
    {
        System.out.println("Score: " + score);
        System.out.println();
        for (int row = 0; row < gameBoard.length; row++)
        {
            for (int col = 0; col < gameBoard[0].length; col++)
            {
                if (gameBoard[row][col] == 0)
                {
                    System.out.print("-\t\t");
                } 
                else if (gameBoard[row][col] < 100)
                {
                    System.out.print(gameBoard[row][col] + "\t\t");
                }
                else 
                {
                    System.out.print(gameBoard[row][col] + "\t");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    private void saveHighScore(ArrayList highScores) throws IOException
    {
        FileWriter outfile = new FileWriter("highscore.txt");
        PrintWriter output = new PrintWriter(outfile);

        for (int i = 0; i < highScores.size(); i++)
        {
            output.println(highScores.get(i));
        }
        output.close();
        outfile.close();

        System.out.println("CONGRATULATIONS! New High Score Added!");
    }

    public void checkHighScore() throws IOException
    {
        // enter your code for 5B here
    }     
}
