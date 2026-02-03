
/**
 * Write a description of class Connect3Driver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class Connect3Driver{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Connect3Board board = new Connect3Board();
        board.print();
        
        //big game loop:
        /*
         * Game loop:
         * gravDrop
         * clear the screen after error checking and success
         * print the screenb
         * check winner
         * print winner
         * end game.
         */
        try{
            boolean player = true;
            while(true){
                
                if(player){
                    board.gravDrop(-1, "X", scan);
                    player = false;
                }else{
                    board.gravDrop(-1, "@", scan);
                    player = true;
                }
                clearScreen();
                board.print();
                if(printWinner(board)){
                    break;
                }
            }
        }catch(Exception e){
            System.out.println("Error");
        }
    }

    //prints and ends game.
    public static boolean printWinner(Connect3Board board){
        String winner = board.checkForWinner();
        if(winner == null){return false;}
        System.out.println("The winner is " + winner);
        return true;
    }

    public static void clearScreen() {
        System.out.print('\u000c');
    }
}
