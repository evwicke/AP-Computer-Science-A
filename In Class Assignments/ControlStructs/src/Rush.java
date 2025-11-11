package src;


/**
 Prompt the user to enter a word.  Allow the user to re-run the program.

If the word is “Neil,” then ask the user to enter a letter.
If the letter is a or b, display “Peart.” If it’s another letter, display “Xanadu.”
If the word is “Geddy,” then ask the user to enter a number. 
If the number is odd and divisible by 9, display “Lee.” 
If the number is negative or equals 2020, display “YYZ.”

 * @evanwicke
 * @11/10/2025
 */

import java.util.*;
public class Rush{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        //variables for the rerunning
        char runner;
        String runnerFlip;
        int runCounter = 0;

        do{
            if(runCounter != 0){
                System.out.println("------------------------------------------------");
            }
            
            System.out.print("Input a name: \n : ");
            String word = scan.next();
            if(word.equalsIgnoreCase("Neil")){
                System.out.print("Input a letter: \n : ");
                char letter = scan.next().charAt(0);
                if(letter == 'a' || letter == 'b' || letter == 'A' || letter == 'B'){
                    System.out.println("  Peart.");
                }else{
                    System.out.println("  Xanadu.");
                }
            }else if(word.equalsIgnoreCase("Geddy")){
                System.out.print("Input a number: \n : ");
                int number = scan.nextInt();
                if(number % 2 == 1 && number % 9 == 0){
                    System.out.println("  Lee.");
                }else if(number < 0 || number == 2020){
                    System.out.println("  YYZ.");
                }
            }
            
            
            //logic for rerunning
            System.out.print("\n Rerun? (y/n)");
            runner = (char)scan.next().charAt(0); // using to just get the first word the user enters
            runnerFlip = String.valueOf(runner); // turns the char into a string
            runCounter++;
        }while(runnerFlip.equalsIgnoreCase("y"));
    }
}
