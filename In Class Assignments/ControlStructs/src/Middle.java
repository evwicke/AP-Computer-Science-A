package src;


/**
 * 
 * Prompt the user to enter their full name (on one line, not separately).  
 * Could be First Middle last or  First last.  Allow the user to re-run the program.

        If the user forgot to enter a space, make them try again.
        Display the number of characters in the name (not including the space).
        Display the 1st letter, the 3rd letter, and the last letter (of the full name).
        Display the name in all caps.
        If the letters A and Z are both in the name, display “both.”
        Display the characters from index #4 to (and including) index #6
        Display the characters from index #2 to the end of the name
        Display the person’s initials only.

 * @evanwicke
 * @11/10/2025
 */

import java.util.*;
import java.util.function.*;
import src.InputSentinel;

public class Middle{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        //variables for the rerunning
        char runner;
        String runnerFlip;
        int runCounter = 0;
        
        Predicate<String> isInRange = s -> s.length() >=2; //the range of the string is if it is 2 letters or more
        do{
            if(runCounter != 0){
                System.out.println("------------------------------------------------");
            }
            
            String name = InputSentinel.sentinel(Function.identity() , isInRange , "Please input your middle name: ");
            name = name.trim().toLowerCase(); // remove all trailing spaces and make all letters lowercase
            
            // question number 1
            boolean firstLetterVowel = name.charAt(0) == 'a' || name.charAt(0) == 'e' ||
                        name.charAt(0) == 'i' || name.charAt(0) == 'o' || name.charAt(0) == 'u';
            System.out.println("  First Letter: " + ((firstLetterVowel)?("Vowel"):("Consonant")));
                        
            //question number 2
            int nameLength = name.length();
            if(nameLength > 8){
                System.out.println("  That name is long.");
            }else if( nameLength <= 8 && nameLength >= 5){
                System.out.println("  That name is medium.");
            }else{
                System.out.println("  That name is short.");
            }
            
            // question number 3
            if(nameLength % 2 == 0){
                System.out.println("  The length of the name is even.");
                if(nameLength % 4 == 0){
                    System.out.println("    It is also divisible by 4");
                }else{
                    System.out.println("    It is also not divisible by 4");
                }
            }else{
                System.out.println("  The length of the name is odd.");
                if(nameLength % 5 == 0){
                    System.out.println("    It is also divisible by 5");
                }else{
                    System.out.println("    It is also not divisible by 5");
                }
            }
            
            //question number 4
            int indexOfA = name.indexOf('a');
            if(indexOfA >= 0){
                System.out.println("  \"A\" found at index: " + indexOfA);
            }else{
                System.out.println("  \"A\" not found.");
            }
            
            //question number 5
            if(name.charAt(0) == name.charAt(nameLength-1)){
                System.out.println("  First and last letters are the same.");
            }else{
                System.out.println("  First and last letters are not the same.");
            }
            
            //question number 6
            if(name.charAt(1) == 'k' && name.charAt(nameLength-2) == 'k'){
                System.out.println("  Second and second to last letters are both k.");
            }else{
                System.out.println("  Second and second to last letters are not both k.");
            }
            
            //logic for rerunning
            System.out.print("\n Rerun? (y/n)");
            runner = (char)scan.next().charAt(0); // using to just get the first word the user enters
            runnerFlip = String.valueOf(runner); // turns the char into a string
            runCounter++;
        }while(runnerFlip.equalsIgnoreCase("y"));
    }
}
