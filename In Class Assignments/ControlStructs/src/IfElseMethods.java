package src;

 


/**
 * Demo in class 10/14 - 10/
 * 
 * @evanwicke
 * @10/14
 * 
 * Learn control structures and intro to methods
 */

import java.util.Scanner;
public class IfElseMethods{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter your test score: ");
        double myTest = scan.nextDouble(); System.out.println("");
        
        DisplayGrade(myTest);
        
        //Short Circuit
        int x = 0;
        int y = 0;
        if(x!=0 && x/y == 0){
            System.out.println("\nDid this get printed?");
            
        }
        System.out.println("\nOutside If Statement");
        
        // get smaller num method
        System.out.print("Enter your first value: ");
        int myInt1 = scan.nextInt();
        System.out.print("Enter your second value: ");
        int myInt2 = scan.nextInt();
        
        int smallerValue = getSmallerNum(myInt1, myInt2);
        System.out.printf("\nThe smaller value of %d and %d is %d", myInt1, myInt2, smallerValue);
        
        
        //math class methods (abs, pow, sqrt, random)
        
        double temp = 17.0;
        double sqrtTemp = Math.sqrt(temp);
        System.out.println("the square root of " + temp +" is  " + sqrtTemp);
        double myNum = Math.pow(3,4); //Only returns a double
        System.out.println(myNum);
        myNum = Math.abs(-4.5);// ints or doubles
        System.out.println(myNum);
        //randpm
        System.out.println(Math.random());
        
        //random int from -5 to +5
        int start = -5; int end = 5;
        int myRandInt =   (int)   (( Math.random() * ( Math.abs( start - end ) + 1 )) + start );
        System.out.println(myRandInt);
        //simulate rolling a number cube
        int roll = (int)(Math.random() * 6) + 1;
        
        //Math.PI        Math.E
        // OK BUT NOT ON THE AP EXAM!!
        
        double newDouble = 342.784239102847;
        System.out.println(Math.round(newDouble));
        System.out.println(Math.ceil(newDouble)); // ceiling, rounds up.
        System.out.println(Math.floor(newDouble)); // floor, rounds down.
        
        newDouble = 1234.56789;
        System.out.printf("Your bank account has $%.2f and $%.3f in it",newDouble, Math.sqrt(newDouble));
        
    }
    
    public static int getSmallerNum(int mI1, int mI2){
        int small;
        if(mI1 > mI2){
            small = mI2;
        }else{
            small = mI1;
        }
        return small;
    }
    
    
    public static void DisplayGrade(double grade){
        if(grade >= 70.0){
            System.out.println("Congrats, you passed!");
        }else if (grade >=60.0 && grade <70){
            System.out.println("Maybe study more.");
        }else{
            System.out.println("You failed.");
        }
    }
    
}
