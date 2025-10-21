
/**
 * To check if a set of 3 triangle sides closes to make a real triangle, a right triangle, or a non-real triangle.
 * 
 * @evanwicke
 * @10/21/2025
 */

import java.util.*;
public class RtTriChecker
{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the 3 side lengths\n  : ");
        int side1 = scan.nextInt();
        System.out.print("  : ");
        int side2 = scan.nextInt();
        System.out.print("  : ");
        int side3 = scan.nextInt();
        
        RtTriChecker(side1,side2,side3);
    }
    
    public static void RtTriChecker(int a, int b, int c){
        int nums[] = {a,b,c};
        Arrays.sort(nums);  // sorts the array lowest to greatest
        int max = nums[2]; // the biggest is the last in the array
        int min1 = nums[0]; // the other 2 are the first and second entry in the array.
        int min2 = nums[1];
        
        if((int)(Math.pow(min1,2))+(int)(Math.pow(min2,2)) == (int)(Math.pow(max,2))){
            System.out.print("The triangle is a real right triangle.");
            //if the triangle fits the pythagorean theorem
        }else if((int)(Math.pow(min1,2))+(int)(Math.pow(min2,2)) >= (int)(Math.pow(max,2))){
            System.out.print("The triangle is real.");
            //if the triangle's smallest 2 sides squared and summed is greater than the large side squared.
        }else{
            System.out.print("The triangle is not real.");
            // if the triangle cannot exist.
        }
    }
}
