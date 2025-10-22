package src;

 

/**
 * Example of a for loop
 *  Includes the IsItPrime method that check to
 *          see if a number is prime or not
 * 
 * @dlynch1   
 * 
 * @October
 */
import java.util.Scanner;
public class forLoopDemo
{
    public static void Main()
    {
      
        System.out.println("**************** example 1  ****************");

        for(int i = 0; i<10; i++){
            System.out.print(i + " ");
        }
        
        
        System.out.println();
        System.out.println("**************** example 2  ****************");
        //print the odd numbers from 1 to 10
        for (int i = 1; i<11; i +=2){
            System.out.print(i + " ");
        }
        
        System.out.println();
        System.out.println();
        //print the odd number from 1 to 10 using %
        for(int i = 1; i<=10; i++){
            if(i % 2 == 1){
                System.out.print(i + " ");
            }
        }
        
        
        System.out.println();
        System.out.println("**************** example 3  ****************");
        // prints 10 to 1
       
        
        
        System.out.println();
        System.out.println("**************** example 4  ****************");
        // print numbers from 37 to 192 that are multiples of 13 & even
        int start = 37;
        int finish = 192;
        //code
        for (int i = start; i<=finish; i++){
            if(i % 13 == 0 && i % 2 == 0){
                System.out.print(i + " ");
            }
        }
        


        System.out.println();
        System.out.println("**************** example 5  ****************");
        /// finding primes between two numbers
        //  ask the start and end number the view the primes in between
        //   and count how many primes are between those numbers
        Scanner scanny = new Scanner(System.in);
        System.out.print("Please enter a integer:");
        int begin = scanny.nextInt();
        System.out.print("Please enter a bigger integer:");
        int end = scanny.nextInt();
        // error loop check to see if a bigger number was entered
        while(begin >= end)
        {
            System.out.print("Please enter a number that is bigger than " 
                                            + begin + ": ");
            end = scanny.nextInt();
        }
        int count = 0;
        
        for(int i = begin; i<= end; i++){
            if(isPrime(i)){
                System.out.print(i + "  ");
                count++;
            }
        }
        
        
        
        
        System.out.println("\nNumber of primes was: " + count);


    }
    
    public static boolean isPrime(int num){
        boolean isPrime = true; // assume its prime.
        if (num == 1) isPrime = false;
        for(int i = 2; i< num; i++){
            if (num % i == 0){
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
   
    
}