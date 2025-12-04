package src;

/**
 * binary to decimal or decimal to binary
 * 
 * @evwicke
 * @12.3.2025
 */

import java.util.*;
public class BinaryConverter{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int choice;
        do{
            System.out.print("(1)Binary to Decimal  (2)Decimal to Binary  (3)To end\n   : ");
            choice = scan.nextInt();
            if(choice == 1){
                System.out.print("  Enter your binary number :  ");
                System.out.printf("  Your converted decimal number is :  %d\n\n", BiToDec(scan.next()));
            }
            if(choice == 2){
                System.out.print("  Enter your decimal number :  ");
                System.out.printf("  Your converted binary number is :  %s\n\n", DecToBi(scan.nextInt()));
            }
        }while(choice != 3);
    }
        
    static int BiToDec(String s){
        int decimal = 0;
        for (int i = 0; i < s.length(); i++) {
            decimal = decimal * 2; // doubles all "parts" of the number, essentially raising each's power by 1. ex: 8 + 0 + 2 + 1 --> 16 + 0 + 4 + 2 + (1 or 0 depending)
            if (s.charAt(i) == '1') { 
                decimal = decimal + 1;
            }
        }
        return decimal;
    }
    static String DecToBi(int d){
        if (d == 0) { // loop wont "see" 0, so do this edge case outside the loop.
            return "0";
        }
        String binary = ""; // start with empty string.
        while (d > 0) {
            int remainder = d % 2; // get remainder when dividing by 0. 
            binary = remainder + binary; // make that remainder the new first number in the string, shift all others over 1.
            d = d / 2; // then do integer division on the number.
        } // repeat until you get 1%2 == 1 or 2%2 == 0.
        return binary;
    }
}
