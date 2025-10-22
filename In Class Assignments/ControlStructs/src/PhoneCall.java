package src;

 


/**
 * A 2-minute (or less) telephone call to Lexington, Virginia, costs $1.15. 
 * Each additional minute costs $0.50. Write a program called PhoneCall.java that 
 * takes the total length of a call in full minutes as input and calculates and 
 * displays the cost in a nice and clean way that represents money.  
 * Remember to use proper data types and print meaningful descriptive output. 

 * Optional:  If you want the user to enter floating point types for the length 
 * of the phone call, you need to account for the fact that a 5 min : 01 sec phone call 
 * is going to cost the same as a 6 min phone call. 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class PhoneCall
{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
       
        System.out.print("Input the amount of minutes you spoke for: ");
        double minutes = scan.nextDouble();
        while(minutes < 0){ // makes it so they cant input a negative number
            System.out.print("  Input valid time: ");
            minutes = scan.nextDouble(); // re-prompt
        }
        
        int minutesCeil = (int)(Math.ceil(minutes)); // gets the ceiling of the number.
        double cost = round(0.5*(minutesCeil - 2 ) + 1.15, 2); // y = mx + b
        
        System.out.printf("The cost of this phone call is $%.2f",cost);// MR LYNCH I PROMISE THAT I AM NOT USING
                                                // THE PRINTF FOR ACTUAL ROUNDING. JUST REMOVING THE TRAILING
                                                // ZEROS. THE ROUNDING METHOD WORKS TO ROUND THE NUMBERS.
    }
    
    public static double round(double value, int places) { // rounding function outpuyttng a double.
        // Multiply by 10^places, cast to int, then divide back
        return (((int) (value * (Math.pow(10, places)) + 0.5)) / (Math.pow(10, places)));
    }
}
