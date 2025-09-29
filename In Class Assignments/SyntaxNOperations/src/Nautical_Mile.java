package src;

/*------------------------------------------------------------------------------------------*
|                                                                                           |
|          Evan Wicke -- September 22, 2025 -- Nautical Mile -- SyntaxNOperations           |
|                                                                                           |
*__________________________________________________________________________________________*/


import java.util.Scanner;


public class Nautical_Mile {
    public static void main(String[] args) {
        Scanner Scan = new Scanner(System.in); // initialize scanner

        System.out.println("Input the number of kilometers you want to convert to nautical miles: "); //prompt the user for input
        double kilometers = Scan.nextDouble(); // store input in double variable

        double nauticalMiles = ((kilometers / 10000) * 90) * 60; // convert kilometers to nautical miles
        // first it divides by 10,000, which converts the kilometer count into percentage of the 90 degrees from the equator to the poles.
        // second it multiplies by 90 to get the amount of degrees ( usually is below 1 )
        // third it multiplies by 60 to convert from degrees to nautical miles

        System.out.printf("%.2f kilometers is %.2f nautical miles.\n", kilometers, nauticalMiles); // prints out the final conversion

    }
}
