package ControlStructs.src;


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

        /* This for loop is a lot easier understood via mathematical functions.
                                                        ( 4 )
        (summation from i=1 to i=iterations) of ---------------------
                                                 (2(i)-1)*(-1)^(i+1)
         */

        for(int i = 1; i<=iterations; i++){
            denominator = (2*i)-1;
            if(i % 2 == 0){
                denominator *=-1;
            }
            sum += (4.0/denominator);
        }

        System.out.println();
        System.out.printf("  Approximation: %f\n  PercentError: %.8f%%\n", sum, percentageToPI(sum));

        scan.close();
    }

    public static double percentageToPI(double actual){
        return Math.abs(((actual - Math.PI)/Math.PI) * 100);
    }
}
