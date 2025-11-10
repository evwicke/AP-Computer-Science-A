package src;


/**
 * 
 * Prompt the user to enter their full name (on one line, not separately).  
 * Could be First Middle Last or  First Last.  Allow the user to re-run the program.

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

public class Lettahs{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        //variables for the rerunning
        char runner;
        String runnerFlip;
        int runCounter = 0;
        
        Predicate<String> isInRange = s -> s.indexOf(" ") != -1; //the range of the string is if it has a space or not. it should.
        do{
            if(runCounter != 0){
                System.out.println("------------------------------------------------");
            }
            
            String name = InputSentinel.sentinel(Function.identity() , isInRange , "Please input your full name: ");
            String[] nameArray = name.trim().split(" "); // remove the leading and trailing spaces and split based on spaces.
            ArrayList<String> nameArrayList = new ArrayList<String>(); // turn the primitive array into an ArrayList
            for(String w : nameArray){
                nameArrayList.add(w);
            }
            
            int numChars = name.length() - (nameArrayList.size() - 1); // number of chracters is the total character count minus the amount of spaces all plus 1
            
            char firstLetter, thirdLetter, lastLetter;
            firstLetter = name.charAt(0);
            thirdLetter = name.charAt(2);
            lastLetter = name.charAt(name.length()-1);
            
            String nameCaps = name.toUpperCase();
            
            boolean bothAandZ = nameCaps.indexOf('A')!=-1 && nameCaps.indexOf('Z')!=-1;
            
            String substringOne = name.substring(4,7);
            String substringTwo = name.substring(2);
            
            ArrayList<Character> initials = new ArrayList<Character>();
            for(String s : nameArray){
                initials.add(s.charAt(0));
            }
            
            String initialTot = "";
            for(char c : initials){
                initialTot += String.valueOf(c) + " ";
            }
            
            System.out.printf("  Characters in name: %d\n" + "  First, third, last letters: %c %c %c\n" + "  ALL CAPS: %s\n" + 
                    "  Contains A and Z: %b\n" + "  Substring 1: %s\n" + "  Substring 2: %s\n" + "  Initials: %s\n", numChars, firstLetter, 
                    thirdLetter, lastLetter, nameCaps, bothAandZ, substringOne, substringTwo, initialTot
            );
            
            //logic for rerunning
            System.out.print("\n Rerun? (y/n)");
            runner = (char)scan.next().charAt(0); // using to just get the first word the user enters
            runnerFlip = String.valueOf(runner); // turns the char into a string
            runCounter++;
        }while(runnerFlip.equalsIgnoreCase("y"));
    }
}
