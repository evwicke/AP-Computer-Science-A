package src;


/**
 * ping pong wins.
 * 
 * @evwicke
 * @11.18.25
 */
import java.util.*;
import java.util.function.*;
import src.InputSentinel;
public class PingPong{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        Predicate<Integer> isInRange = d -> d>=5;
        int playerCount = InputSentinel.sentinel(Integer::parseInt , isInRange , "Please input the amount of players (minimum 5): ");
        // the InputSentinel Class is submitted too.
        ArrayList<Integer> winsArray = new ArrayList<Integer>(playerCount);
        for(int i = 1; i<=playerCount;i++){
            Predicate<Integer> isValidCountingNumber = d -> d>=0;
            winsArray.add(InputSentinel.sentinel(Integer::parseInt, isValidCountingNumber,
                                                        "Win count of player " + i + ": "));
            if(winsArray.stream().mapToInt(Integer::intValue).sum() >= 50){
                playerCount = winsArray.size();
                System.out.println("OVERLOAD");
                break;
            }
        }

        int winSum = 0;
        for(int i = 0; i<playerCount;i++){
            winSum += winsArray.get(i);
        }

        double averageWins = (double) winSum / playerCount;

        int mostWins = winsArray.stream().max(Integer::compareTo).get();
        int leastWins = winsArray.stream().min(Integer::compareTo).get();

        int multiDigitWins = 0;
        for(int i = 0; i<playerCount;i++){
            if(winsArray.get(i)>9){
                multiDigitWins++;
            }
        }

        System.out.printf("\n The average number of wins is: %.2f " +
                "\n The most wins is: %d " +
                "\n The least wins is: %d " +
                "\n There are %d players with double digit win counts.",
                averageWins, mostWins, leastWins, multiDigitWins
        );

    }
}
