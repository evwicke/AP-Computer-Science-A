
/**
 * use loops
 * 
 * @evanwicke
 * @10/15/2025
 */

import java.util.Scanner;
public class WhileDemo{
    public static void main(String[] args){

        /*
         * Types of loops:
         * // "pre conditional loop"
         * while
         * 
         * //will always run at least 1 time. "Post-conditional loop"
         * do{
         *     statements;
         * }while(condition);
         * 
         * for // counter - controlled.
         * for each 
         * 
         * 
         */

        int counter1 = 1;
        while(counter1<10){

            System.out.print(counter1 + "   ");

            counter1++;
        }

        // count backwards
        int counter2 = 10;
        System.out.print("\n");
        while(counter2>0){
            System.out.print(counter2 + "   ");
            counter2--;
        }

        //summing up all numbers from 54 to 267
        System.out.print("\n");
        int start = 1; int end = 100;
        int tempStart = start;
        int sum1=0;
        while(tempStart<=end){
            sum1 += tempStart;
            tempStart++;
        }
        System.out.printf("\n\nThe sum of the values from %d to %d is %d",start, end, sum1);

        //sentinels 
        Scanner scan = new Scanner(System.in);

        System.out.print("\n Please enter test scores ( -1 to exit ): ");
        int myTest = scan.nextInt();

        int sumOfScores = 0;
        int numOfTests = 0;
        while ( myTest != -1 ){
            numOfTests++;
            sumOfScores +=myTest;

            System.out.print("  : ");
            myTest = scan.nextInt();

        }
        double average = sumOfScores / numOfTests;
        System.out.printf("\n The sum is %d, \n The number of tests entered was %d, \n The average score is %.2f percent.",
            sumOfScores, numOfTests, average);

         
        //while loop for error checking
        
        System.out.print("\nPlease enter your age: ");
        int age = scan.nextInt();
        while (age  <0  ||  age>117){ // Demorgans law !( age>=0 && age <=117)
            // error message
            System.out.print("\nPlease input your real age: ");
            age = scan.nextInt();
        }
    }
}
