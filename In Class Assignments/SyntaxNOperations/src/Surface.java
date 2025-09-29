package src;


/*------------------------------------------------------------------------------------------*
|                                                                                           |
|            Evan Wicke -- September 23, 2025 -- Surface -- SyntaxNOperations               |
|                                                                                           |
*__________________________________________________________________________________________*/

import java.util.Scanner;

public class Surface {
    public static void main(String[] args) {
        Scanner Scan = new Scanner(System.in); // initialize scanner

        System.out.print("Enter the length of the cube: "); // prompt the user for the length of the cube face
        int length = Scan.nextInt(); // store variable in int length

        int surfaceArea = (int) ((Math.pow((double)length, 2.0))*6); // convert length to surface area

        System.out.printf("The surface area of the cube is %d.", surfaceArea); // print out final surface area
    }
}
