package src;

 


/**
 * To do integer division with remainder
 * 
 * @evanwicke
 * @10/21/2025
 */
import java.util.*;
public class Dividing
{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String repeat; //found out this needs to be initialized BEFORE the loop runs, cannot be
                       // initialized inside the loop.
        int counter = 0;
        do{
            if(counter != 0){
                System.out.println("\n");
            } //other than the first time, put 2 new lines before the loop runs.
            
            System.out.print("Enter the 2 numbers to be divided.\n  : ");
            int num1 = scan.nextInt();
            System.out.print("  : ");
            int num2 = scan.nextInt();
            
            IntDivide(num1,num2);
            
            scan.nextLine(); //CONSUME THE ENTER KEY
            System.out.print("Input \"y\" to run again or \"n\" to exit the program \n  : ");
            repeat = scan.nextLine();
            
            counter++;
        }while(repeat.equals("y"));
    }
    public static void IntDivide(int a,int b){
        if(b>a){
           a = a + b;
           b = a - b; 
           a = a - b; 
        } // if b is bigger, swap a and b to make a the bigger one.
        
        int remainder = a%b; //remainder is just the modulus
        int divided = (a/b); // THE DIVISION IS INTEGER DIVISION!!! no casting required
        System.out.println(divided + "r" + remainder);
        
    }
}
