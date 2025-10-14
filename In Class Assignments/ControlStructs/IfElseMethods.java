
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
