package src;


/**
 * Approximates PI to a certain accuracy via iterations over Leibniz's summation formula for PI
 * @evanwicke
 * @10/23/2025
 */
import java.util.*;
public class LeibnizPI{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Please input the iteration accuracy \n  : ");
        int iterations = scan.nextInt();
        
        double sum = 0;
        double denominator = 1;

        /** This for loop is a lot easier understood via mathematical functions.
                                                   ____           ( 4 )
        (summation from i=1 to i=iterations) of    \      ---------------------
                                                   /       (2(i)-1)*(-1)^(i+1)
                                                   ----                                           
         */

        for(int i = 1; i<=iterations; i++){
            denominator = (2*i)-1;
            if(i % 2 == 0){
                denominator *=-1; // every even integer will multiply by -1 (flip flops)
            }
            sum += (4.0/denominator); //sum this value to the sum
        }

        System.out.println();
        System.out.printf("  Approximation: " + sum + "\n  PercentError: %.8f%%\n",percentageToPI(sum));

        scan.close();
    }

    public static double percentageToPI(double actual){
        return Math.abs(((actual - Math.PI)/Math.PI) * 100);  // returns the percent error 
        
        /*
         *  ( A - T )
         *  --------- ( 100 ) = % error
         *    ( T )
         *    
         */
    }
}
