package src.Cardz;

/**
 * Write a description of class War here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class War{
    public static void main(String[] args){
        final String RESET = "\u001B[0m";
        final String RED = "\u001B[31m";
        final String GREEN = "\u001B[32m";
        final String BLUE = "\u001B[34m";
        int wins1=0;
        int ties=0;

        for(int i = 1; i<=20; i++){
            Card card1 = new Card();
            Card card2 = new Card();

            System.out.print(card1 + " versus " + card2);
            if(card1.getValue() > card2.getValue()){
                System.out.println("  ===  "+ RED +"Player 1 wins!" + RESET);
                wins1++;
            }else if(card1.getValue() < card2.getValue()){
                System.out.println("  ===  "+ GREEN + "Player 2 wins!"+RESET);
            }else{
                System.out.println("  ===  "+ BLUE + "TIE!"+RESET);
                ties++;
            }
        }

        int losses1 = 20-ties-wins1;
        if(wins1 > losses1){
            System.out.println(RED +"Player 1 wins!" + RESET);
            System.out.printf("They have:\n  Wins: %d \n  Losses: %d \n  Ties: %d", wins1, losses1, ties);
        }else{
            System.out.println(GREEN +"Player 2 wins!" + RESET);
            System.out.printf("They have:\n  Wins: %d \n  Losses: %d \n  Ties: %d", losses1, wins1, ties);
        }
    }
}
