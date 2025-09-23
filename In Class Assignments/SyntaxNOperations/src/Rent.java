
/*------------------------------------------------------------------------------------------*
|                                                                                           |
|             Evan Wicke -- September 22, 2025 -- Rent -- Syntax NOperations                |
|                                                                                           |
*__________________________________________________________________________________________*/

import java.util.Scanner;

public class Rent {
    public static void main(String[] args) {
        final int MINUTES_PER_HOUR = 60; // constants to use to convert years to minutes
        final int HOURS_PER_DAY = 24;
        final double DAYS_PER_YEAR = 365.25;

        Scanner Scan = new Scanner(System.in); // initialize scanner
        while(true){ // while loop lets me prompt the user to repeat parts of the code

            System.out.print("Enter the amount of years you would like to convert to minutes: ");
            double years = Scan.nextDouble(); // prompt users for year count

            long totalMinutes = (long)(years*MINUTES_PER_HOUR*HOURS_PER_DAY*DAYS_PER_YEAR); // convert year count to minute count

            System.out.printf("Your amount of minutes is %d.\n", totalMinutes); // print out product

            System.out.print("Would you like to re-run the calculator? (y/n): "); // prompt for if you wanna re-run the program
            Scan.nextLine(); // consume enter key
            String answer = Scan.nextLine();

            if(answer.equals("y")){ // logic to rerun the program if the user answers y
                continue;
            }else{
                break; // otherwise, end the program.
            }
        }
    }

}
