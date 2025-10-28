package src;

/**
 * Outputs the powers of n based on input from the user.
 * Uses while loop to ask as many times as the user wants, can be exited by inputting (-1)
 * @evanwicke
 * @10/24/2025
 */
import java.util.*;
import java.util.function.*;

//I abstracted the inputsentinel out into a class for just it.
import src.InputSentinel;
public class ModBinary{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("This program will display the powers of the inputted base.\n"
            +"Note: Enter -1 as the exponent to halt the program.");
        int counter = 0;
        int exp = 0;
        
        Predicate<Integer> isInBaseRange = d-> d>=2 && d<=50; // is the condition for the inputSentinel. 
        Predicate<Integer> isInRange = d-> d>=-1 && d<=63; // a predicate is part of the java.util subset and is a method - passable boolean argument
        do {
            
            int base = InputSentinel.sentinel(Integer::parseInt, isInBaseRange, "\n\n Please input the base between 2 and 50."); //needed 2 \n's to add empty lines
            exp = InputSentinel.sentinel(Integer::parseInt, isInRange, " Please input an exponent between 0 and 50 (long max).");

            if (exp != -1) {
                long ans = base;
                for(int i = 0; i<exp-1; i++){
                    ans *=base;
                }
                System.out.printf("  %d^%d is %d.\n",base, exp, ans); // print out the output
            }
        } while (exp != -1); //while the exponent ISNT -1... continue running.
    }
}
