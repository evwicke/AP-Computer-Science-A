package src;


/**
 * Write a description of class Numbahz here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class Numbahz
{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        System.out.print("What was your grade? \n  : "); int grade; int counter = 0;
        do{
            if(counter != 0){System.out.print("\nThat wasn't a grade silly. Try again. \n  : ");}
            grade = (int)(round(scan.nextInt(),1));
            counter++;
        }while(grade > 100 || grade < 0);
        
        System.out.printf("\n  Grade: %s", letterGrade(grade));
        System.out.print("\n  Even / Odd: " + ((grade % 2 == 0)?"Even":"Odd"));
        System.out.print("\n  Prime: " + isPrime(grade));
        System.out.print("\n  Divisible By 7: " + ((grade % 7 == 0)?"true":"false"));
        
    }
    public static double round(double value, int places) { // rounding function outpuyttng a double.
        // Multiply by 10^places, cast to int, then divide back
        return (((int) (value * (Math.pow(10, places)) + 0.5)) / (Math.pow(10, places)));
    }
    public static String letterGrade(int grade){
        String letterGrade = (grade>=90)?"A":(grade>=80)?"B":(grade>=70)?"C":
                            (grade>=60)?"D":(grade>=50)?"F":"Super F!";
        return letterGrade;
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
