package src;


/**
 * Write a description of class PingPong here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import java.util.function.*;
import src.InputSentinel;
public class PingPong{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        Predicate<Integer> isInRange = d -> d>=5;
        int playerCount = InputSentinel.sentinel(Integer::parseInt , isInRange , "Please input the amount of players (minimum 5: ");
        // the InputSentinel Class is submitted too.
        ArrayList<Integer> winsArray = new ArrayList<Integer>(playerCount);
        for(int i = 1; i<=playerCount;i++){
            Predicate<Integer> isValidCountingNumber = d -> d>=0;
            winsArray.add(InputSentinel.sentinel(Integer::parseInt, isValidCountingNumber,
                                                        "Win count of player " + i + ": "));
            
            
        }
        
        System.out.println(winsArray);
        System.out.println(playerCount);
        
        
        
        
        
    }
}
