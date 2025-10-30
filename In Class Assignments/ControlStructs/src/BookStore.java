package src;

/**
 * gets the pre-markup total and the amount added on by the markup rate.
 * @evanwicke
 * @10/29/2025
 */

import java.util.*;
public class BookStore {
    static final double MARKUP_RATE = 0.1; //made this a constant

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double price, totalPrice = 0, markupPrice = 0; //initialize all my variables

        System.out.println("Enter book prices (enter -1 to finish):\n");
        while (true) {
            System.out.print("   : ");
            try {
                price = scanner.nextDouble();
                if (price == -1) break; // yes yes yes i know i shouldnt use break statements, but i think this is a perfectly valid use case.
                                        // I dont want the -1 going through the rest of the loop, like being added to the total values.
                totalPrice += price / (1 + MARKUP_RATE);
                markupPrice += price;
            } catch (Exception e) {
                System.out.println("Invalid input.");
                scanner.next();
            }
        }

        double totalMarkup = markupPrice - totalPrice;
        System.out.printf("\n Total price: $%.2f\n Total markup: $%.2f\n", totalPrice, totalMarkup);
    }
}
