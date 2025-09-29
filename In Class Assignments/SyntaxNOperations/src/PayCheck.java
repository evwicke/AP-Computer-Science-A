package SyntaxNOperations.src;


/**
 * Finds amount of money youll get on your paycheck
 * 
 * Evan Wicke
 * 9/25/2025
 */

import java.util.Scanner;

public class PayCheck
{
    public static void main(){
        Scanner Scan = new Scanner(System.in); //initialize scanner
        
        System.out.print("Enter your name: "); // prompt user for name and store to string
        String employeeName = Scan.nextLine();
        
        System.out.print("\nEnter the amount of hours you worked this week: "); // prompt user for hours worked and store
        double hoursWorked = Scan.nextDouble();
        
        System.out.print("\nEnter your hourly wage: "); // prompt user and store hourly pay
        double hourlyPay = Scan.nextDouble();

        int overtimeSwitch = (int)(hoursWorked / 40);
        double overtimeHours = (hoursWorked - 40) * overtimeSwitch;
        double normalHours = hoursWorked - overtimeHours;
        double normalPay = hourlyPay * normalHours;
        double overtimePay = overtimeHours * hourlyPay * 1.5; // find overtime pay
        
        double totalPay = overtimePay + normalPay; // sum of overtime pay and normal pay is the total pay.
        
        System.out.printf("\nEmployee name: %s\nWage: $%.2f\nHours Regular Pay: %.2f\nRegular Pay: $%.2f\n" +
                            "Overtime Hours: %.2f\nOvertime Pay: $%.2f\nTotal Weekly Pay: $%.2f\n",
                            employeeName,hourlyPay,normalHours,normalPay,overtimeHours,overtimePay,totalPay);
                            // print all the info and round doubles to hundreds place.
        
        
    }
}
