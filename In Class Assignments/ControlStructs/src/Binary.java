package ControlStructs.src;


/**
 * Outputs the powers of 2 based on input from the user.
 * Uses while loop to ask as many times as the user wants, can be exited by inputting (-1)
 * @evanwicke
 * @10/24/2025
 */
import java.util.*;
public class Binary
{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        int exp = 0; //initiate exponent variable before loop so that the loop can see it in its scope.
        System.out.print("This program will display the powers of 2.\n"
                +"Note: Enter -1 to halt the program.");

        while(exp != -1){  // while the input isn't -1, keep running.
            System.out.print("\n  Please enter a positive exponent: ");
            exp = scan.nextInt();

            long answer = 1; // 2^0 = 1, 2^1 = 2, ... etc
            for(int i = 1; i<=exp; i++){
                answer *=2;
            }
            if(exp!=-1){
                System.out.printf("  2^%d is %d.", exp, answer); //prints answer
            }else{
                System.out.println("Goodbye");
            }
        }
        
    }
}
