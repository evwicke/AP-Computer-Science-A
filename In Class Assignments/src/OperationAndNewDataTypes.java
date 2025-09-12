/*

        Author : Evan Wicke
        Date : 9/11/2025
        Purpose: Getting more comfortable with the use of data types and using the compiler.

 */

public class OperationAndNewDataTypes {

    public static void main(String[] args) {
        int age;
        int test1, test2, test3;

        age = 42;
        test3 = 97;
        int numOfSubs = 4;

        double weight, heightCm, gpa;

        weight = 152.7;
        gpa = 4.1;
        double reallyBig = 1.2345E23;

        char firstInitial = 'E';

        char favSymbol = 'e';

        boolean test = false;
        boolean isThisTrue = 13 > 45;
        test1 = 4;
        boolean isTheSame = numOfSubs == test1;
        // System.out.println(isTheSame);
        // System.out.println(test1 != numOfSubs);
        // System.out.println(5 == 8 || 7 < 10);

        //System.out.println(firstInitial + " is " + (int)firstInitial + " in ASCII.");

        //create the ASCII chart

//        for (int i = 1; i <= 128; i++) {
//            System.out.print(i + " - " + (char)i + "\t    " + /* if divisible by 8, go to next line */ ((i%8 == 0)  ?  "\n"  :  "" ));
//
//        }

        //DO NOT USE MATH.ROUND.
        // abs, pow, sqrt, random

        double randNum = Math.random();
        double num1 = 1 * randNum;
        double num2 = -1 * num1;
        System.out.println(randNum);

        int nearestPosInt = (int)(num1 + 0.5);
        System.out.println(num1 + " rounds to " + nearestPosInt);

        int nearestNegInt = (int)(num2 - 0.5);
        System.out.println(num2 + " rounds to " + nearestNegInt);

        double num1Round3 = ((int)((num1 * 1000.0)+.5))/1000.0;

        System.out.println(num1Round3);

    }

}
