package src;


/**
 * Does a bunch of stuff with a for loop and a sentence.
 * @evan wicke
 * @10/30/2025
 */

import java.util.*;
import java.util.function.*;
import src.InputSentinel;
public class ForCounter{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        Predicate<String> isInRange = s -> s.length() >=10 && s.length() <=25 && s.contains(" ");
        String mySentence = InputSentinel.sentinel(Function.identity() , isInRange , "Please input your sententence: ");
        // the InputSentinel Class is submitted too.
        ArrayList<Character> splitArray = new ArrayList<Character>();
        for(int i = 0; i< mySentence.length(); i++){
            splitArray.add(mySentence.charAt(i));
        } // splits the sentecne -> [s,e,n,t,e,n,c,e]
        ArrayList<Integer> counterArray = new ArrayList<Integer>(Arrays.asList(0,0,0,0)); // (e, v, a, n)
        for(int i = 0; i< mySentence.length(); i++){ // for each letter in the sentence
            if(i%2 == 0){System.out.println(splitArray.get(i));} // if the index is even, print the char
            
            char ch = Character.toLowerCase(splitArray.get(i)); // the char at index == ch
            switch (ch) { // switch case for if each letter is mathcing, add 1 to the counter at that location
                case 'e':
                    counterArray.set(0, counterArray.get(0) + 1); break;
                case 'v':
                    counterArray.set(1, counterArray.get(1) + 1); break;
                case 'a':
                    counterArray.set(2, counterArray.get(2) + 1); break;
                case 'n':
                    counterArray.set(3, counterArray.get(3) + 1); break;
            }
        }
        
        int totalNameLetterCount = counterArray.get(0) + counterArray.get(1) + counterArray.get(2) + counterArray.get(3);
        //[1,4,2,3] -> 1 + 4 + 2 + 3 = 8.
        
        System.out.println("letter name matches : " + totalNameLetterCount);
        
        boolean divisible = totalNameLetterCount % 3 == 0;
        if(divisible){ // if its divisible,  else its not divisible.
            System.out.printf(" %d is divisible by 3.", totalNameLetterCount);
        }else{
            System.out.printf(" %d is not divisible by 3.", totalNameLetterCount);
        }
       
    }
}
