package src;

import java.util.*;

public class binary_to_decimal
{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Binary:");
        String binaryNumber = scan.nextLine();
        int decimalNumber = Integer.parseInt(binaryNumber, 2);
        System.out.println("Binary: " + binaryNumber + " -> Decimal: " + decimalNumber); // Output: Binary: 10101 -> Decimal: 21
    }
    
}
