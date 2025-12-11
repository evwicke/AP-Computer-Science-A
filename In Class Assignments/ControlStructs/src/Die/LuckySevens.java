package src.Die;


/**
 * Write a description of class LuckySevens here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */



 // the function goes into an infinite loop at winamt = 5 and higher.
import java.util.*;
public class LuckySevens{
    public static void main(String[] args){
        final double WIN_AMT = 5;
        final double LOSE_AMT = 1;
        double maxAmt = 0;
        int maxAmtRuns = 0;
        int runs = 0;
        
        Scanner scan = new Scanner(System.in);
        System.out.printf("If you win, you gain %.0f$, otherwise, you lose %.0f$.", WIN_AMT, LOSE_AMT);
        
        System.out.print("\n  How much money do you want to gamble with?\n   : ");
        double balance = scan.nextDouble();
        
        Die die1 = new Die();
        Die die2 = new Die();
        while(balance >= LOSE_AMT){
            if(balance > maxAmt){maxAmt = balance; maxAmtRuns = runs;}
            
            
            die1.roll();
            int r1 = die1.getCurrentSide();
            die2.roll();
            int r2 = die2.getCurrentSide();
            
            if(r1+r2 == 7){
                System.out.println("WIN");
                balance += WIN_AMT;
                System.out.println(balance);
                
            }else{
                //System.out.println("LOSE");
                balance -= LOSE_AMT;
            }
            runs++;
        }
        
        System.out.println("You were broke after " + runs + " rolls and you should have quit after " + maxAmtRuns + " rolls when you had " + maxAmt + "$.");
        
    }
}
