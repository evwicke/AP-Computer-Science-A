package src;

/**
 * Outputs the powers of 2 based on input from the user.
 * Uses while loop to ask as many times as the user wants, can be exited by inputting (-1)
 * @evanwicke
 * @10/24/2025
 */
import java.util.*;
import java.util.function.*;
public class Binary
{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.print("This program will display the powers of 2.\n"
            +"Note: Enter -1 to halt the program.");
        int counter = 0;
        int exp = 0;
        Predicate<Integer> isInRange = d-> d>=-1 && d<=63; // conditional statement i can pass into the inputSentinel.
        do {
            exp = inputSentinel(Integer::parseInt, isInRange, "\nPlease input a number between 0 and 63 (long max)");
                                // type = int,     isInRange = true ,    "String"
            if (exp != -1) {
                long ans = 1;
                for(int i = 0; i<exp; i++){
                    ans *=2;
                }
                System.out.printf("  2^%d is %d.\n", exp, ans);
            }
        } while (exp != -1);
    }
    //for the next few things ill abstract it into a class i can call
    // public static.. nonSpecific type T inputsentinel ( Turn the inputted string into type T, with the predicate condition of type T, and the prompt String prompt );
    public static <T> T inputSentinel(Function<String, T> converter, Predicate<T> condition, String prompt){
        /**
         * Predicate<Integer> isInRange = d-> d>=0 && d<=100;
         * Integer myNumber = inputSentinel(Integer::parseInt, isInRange , "Please input a number between 0 and 100 inclusive");
         */
     
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
                    return input;
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
