package SyntaxNOperations.src;


/*------------------------------------------------------------------------------------------*
|                                                                                           |
|             Evan Wicke -- September 17, 2025 -- MyInfo -- Syntax NOperations              |
|                                                                                           |
*__________________________________________________________________________________________*/

import java.util.Scanner;

public class MyInfo {
    public static void main(String[] args) {
        Scanner Scan = new Scanner(System.in);  // initialize the scanner

        System.out.println("Input your age: "); // prompt the user for their age and store it in int age
        int age = Scan.nextInt();

        // prompt the user for their 9 favorite integers and store them in int var1, var2, etc.
        System.out.println("Input your 9 most favorite integers, seperated by enter keys: ");
        int var1 = Scan.nextInt(), var2 = Scan.nextInt(), var3 = Scan.nextInt(), var4 = Scan.nextInt(), var5 = Scan.nextInt(),
                var6 = Scan.nextInt(), var7 = Scan.nextInt(), var8 = Scan.nextInt(), var9 = Scan.nextInt();

        // take the average of the 9 integers
        double average = (double)(var1 + var2 + var3 + var4 + var5 + var6 + var7 + var8 + var9) / 9;

        // prompt the user for their middle initial and store it in char initial
        System.out.println("Input your middle initial: ");
        char initial = Scan.next().charAt(0);

        // consume enter key and then prompt the user for their favorite book and store it in String book
        Scan.nextLine();
        System.out.println("Input your favorite book: ");
        String book = Scan.nextLine();

        // print out the user's information using printf
        System.out.printf("Your age is %d, your middle initial is %c, and your favorite book is %s.\n", age, initial, book);
        System.out.printf("Your average is %.2f", average);
    }
}