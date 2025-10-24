package src;


/**
 * Write a description of class Binary here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class Binary
{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        int exp; //initiate exponent variable before loop so that the loop can see it in its scope.
        System.out.print("This program will display the powers of 2.\n"
                +"Note: Enter -1 to halt the program."); 
        do{
            System.out.print("\n  Please enter a positive exponent: ");
            exp = scan.nextInt();
            int answer = 1; // 2^0 = 1, 2^1 = 2, ... etc
            for(int i = 1; i<=exp; i++){
                answer *=2;
            }
            System.out.printf("  2^%d is %d.", exp, answer); //prints answer
        }while(exp != -1); // while the input isnt -1, keep running.
        
    }
}
