package Lab2048;
/**
 * Game2048.java  
 *
 * @author – Your name
 * @author – Class period
 *
 */ 

import java.io.*;                   
import java.util.Scanner;          
import java.util.ArrayList;         

public class Game2048
{
    private int[][] gameBoard;
    private int score;
    private int boardSize;   

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
        int randRow = (int)(Math.random()*boardSize);
        int randCol = (int)(Math.random()*boardSize);
        while (gameBoard[randRow][randCol] != 0)
        {
            randRow = (int)(Math.random()*boardSize);
            randCol = (int)(Math.random()*boardSize);
        }
        gameBoard[randRow][randCol] = 2;
    }                  

    public void moveRight()
    {
        for (int row = 0; row < gameBoard.length; row++)
        {
            for (int col = gameBoard[0].length - 1; col > 0; col--)
            {
                if (gameBoard[row][col] == 0)
                {
                    int counter = col - 1;
                    while (counter >= 0 && gameBoard[row][counter] == 0)
                    {
                        counter--;
                    }
                    if (counter >= 0)
                    {
                        gameBoard[row][col] = gameBoard[row][counter];
                        gameBoard[row][counter] = 0;
                    }
                }
            }
        }
    }

    public void moveLeft()
    {
        for (int row = 0; row < gameBoard.length; row++)
        {
            for (int col = 0; col < gameBoard[0].length - 1; col++)
            {
                if (gameBoard[row][col] == 0)
                {
                    int counter = col + 1;
                    while (counter<gameBoard[0].length)
                    {
                        if (gameBoard[row][col] == 0)
                        {
                            int counter = row - 1;
                            while (counter >= 0 && gameBoard[counter][col] == 0)
                            {
                                counter--;
                            }
                            if (counter >= 0)
                            {
                                gameBoard[row][col] = gameBoard[counter][col];
                                gameBoard[counter][col] = 0;
                            }
                        }
                        row--;
                    }
                }
            }
        }
    }

    public void mergeLeft()
    {
        for (int row = 0; row < gameBoard.length; row++)
        {
            for (int col = 0; col < gameBoard[0].length - 1; col++)
            {
                if (gameBoard[row][col] == gameBoard[row][col+1] && 
                gameBoard[row][col+1] != 0)
                {
                    gameBoard[row][col] *= 2;
                    gameBoard[row][col+1] = 0;
                    score += gameBoard[row][col];
                }
            }
        }
    }

    public void mergeRight()
    {
        for (int row = 0; row < gameBoard.length; row++)
        {
            for (int col = gameBoard[0].length - 2; col >= 0; col--)
            {
                if (gameBoard[row][col] == gameBoard[row][col+1] && 
                gameBoard[row][col+1] != 0)
                {
                    gameBoard[row][col+1] *= 2;
                    gameBoard[row][col] = 0;
                    score += gameBoard[row][col+1];
                }
            }
        }
    }

    public void mergeUp()
    {
        for (int col = 0; col < gameBoard[0].length; col++)
        {
            for (int row = 0; row < gameBoard.length - 1; row++)
            {
                if (gameBoard[row][col] == gameBoard[row+1][col] && 
                gameBoard[row+1][col] != 0)
                {
                    gameBoard[row][col] *= 2;
                    gameBoard[row+1][col] = 0;
                    score += gameBoard[row][col];
                }
            }
        }
    }

    public void mergeDown()
    {
        for (int col = 0; col < gameBoard[0].length; col++)
        {
            for (int row = gameBoard.length - 2; row >= 0; row--)
            {
                if (gameBoard[row][col] == gameBoard[row+1][col] &&
                gameBoard[row+1][col] != 0)
                {
                    gameBoard[row+1][col] *= 2;
                    gameBoard[row][col] = 0;
                    score += gameBoard[row+1][col];
                }
            }
        }
    }

    public boolean gameOver()
    {
        boolean found2048 = false;
        int zeroCount = 0;
        for (int row = 0; row < gameBoard.length; row++)
        {
            for (int col = 0; col < gameBoard[0].length; col++)
            {
                if (gameBoard[row][col] == 0)
                {
                    zeroCount++;
                }  
                if (gameBoard[row][col] == 32)
                {
                    found2048 = true;
                }
            }
        }
        return (found2048 || zeroCount == 0);
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