package src.Die;

/**
 * Roll the dice 1 time and display the result
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
public class DieClient{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        System.out.print("How many sides does the die have?\n  : ");
        int sideCount = scan.nextInt();
        Die d6 = new Die(sideCount);
        d6.roll();
        
        System.out.println("  " + d6);
    }
}
