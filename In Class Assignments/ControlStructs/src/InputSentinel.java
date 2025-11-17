package src;


/**
 * Write a description of class InputSentinel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import java.util.function.*;
public class InputSentinel{
    public static <T> T sentinel(Function<String, T> converter, Predicate<T> condition, String prompt){
        Scanner scanner = new Scanner(System.in);
        T input;
        int counter = 0;
        while (true) {
            if(counter == 0){
                System.out.print(prompt + "\n   : ");
            }else{
                System.out.print("   : ");
            }
            String line = scanner.nextLine();

            try {
                // Convert the String input to the desired type
                input = converter.apply(line);

                // Test the input against the sentinel condition
                if (condition.test(input)) {
                    return input; // Return the valid input and exit the loop
                } else {
                    System.out.println("  Invalid input.");
                }
            } catch (Exception e) {
                System.out.println("Invalid format.");
            }
            counter++;
        }
    }
}
