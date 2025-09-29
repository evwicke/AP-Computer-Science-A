package src;


/*------------------------------------------------------------------------------------------*
|                                                                                           |
|             Evan Wicke -- September 23, 2025 -- Sphere -- SyntaxNOperations               |
|                                                                                           |
*__________________________________________________________________________________________*/

import java.util.Scanner;

public class Sphere {

    final static double PI = Math.PI; // put PI into a final double variable. it needs to be static to be used in the main method cuz i didnt wanna put it in the main method

    public static void main(String[] args) {
        Scanner Scan = new Scanner(System.in);

        System.out.print("Enter the radius of the sphere: "); // prompt user for radius and store it in double radius
        double radius = Scan.nextDouble();

        double diameter = round(radius * 2, 2); // solve and store each new data point about this sphere
        double circumference = round(2 * PI * radius, 2);
        double volume = round(PI * Math.pow(radius, 3) * ((double) 4 /3), 2);
        double surfaceArea = round(4 * PI * Math.pow(radius, 2), 2);

        System.out.printf("With a radius of %.2f, the sphere has:\n" + // print out final information, i did the %.2f because without it the numbers have like 6 trailing zeros because of the typecasting rounding
                "\tDiameter: %.2f units\n" +
                "\tCircumference: %.2f units\n" +
                "\tSurface Area: %.2f units\n" +
                "\tVolume: %.2f units\n",
                radius, diameter, circumference, surfaceArea, volume
        );
    }

    public static double round(double value, int places) { // I didn't want to do the round for each one, so I made a method to do it.
        // Multiply by 10^places, cast to int, then divide back
        return (double) ((int) (value * (Math.pow(10, places)) + 0.5)) / (Math.pow(10, places));

    }
}
