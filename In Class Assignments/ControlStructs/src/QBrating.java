package src;

/**
 * Calculates QB rating
 * 
 * @evanwicke
 * @11/6/2025
 */
import java.util.*;
import java.util.function.*;
import src.InputSentinel;
public class QBrating{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        //variables for the rerunning
        char runner;
        String runnerFlip;
        int runCounter = 0;
        
        double a,b,c,d; //init all of my varibles so they can be changed in the while loop
        Predicate<Double> isInRange = r -> r>0; // all numbers must be greater than 0.
        do{
            if(runCounter != 0){
                System.out.println("----------------------------------------------");
            }
            
            //user input
            double comp = InputSentinel.sentinel(Double::parseDouble, isInRange, 
                        "Please input the amount of completions: ");
            double attempts = InputSentinel.sentinel(Double::parseDouble, isInRange, 
                        "Please input the amount of attempts: ");
            double yrds = InputSentinel.sentinel(Double::parseDouble, isInRange, 
                        "Please input the amount of yards gained: ");
            double TDs = InputSentinel.sentinel(Double::parseDouble, isInRange, 
                        "Please input the amount of touchdowns: ");
            double INTs = InputSentinel.sentinel(Double::parseDouble, isInRange, 
                        "Please input the amount of interceptions: ");
                        
                        
            //analysis of data
             a = (((comp / attempts) * 100) -30) /20;
             b = ((TDs/attempts) * 100) / 5;
             c = (9.5 - ((INTs/attempts) * 100)) / 4;
             d = ((yrds/attempts) - 3) / 4;
            double rating = (a+b+c+d) / 0.06;
            
            //outputting data
            System.out.printf("\n  The QB Rating of this player is: %.2f", rating);
            
            
            //logic for rerunning
            print("\n Rerun? (y/n)");
            runner = (char)scan.next().charAt(0); // using to just get the first word the user enters
            runnerFlip = String.valueOf(runner); // turns the char into a string
            runCounter++;
        }while(runnerFlip.equalsIgnoreCase("y"));
    }

    public static void print(String arg){
        System.out.print(arg);
    }
}
