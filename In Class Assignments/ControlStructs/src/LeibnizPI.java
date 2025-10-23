package src;


/**
 * Write a description of class LeibnizPI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class LeibnizPI{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Please input the iteration accuracy \n  : ");
        int iterations = scan.nextInt();
        
        long sum = 0;
        int denominator = 1;
        for(int i = 1; i<=iterations; i++){
            
            denominator = (2*i)-1;
            if(i % 2 == 0){
                denominator *=-1;
            }
            
            sum += (long)(4.0/(double)denominator);
            
            System.out.println(sum);
        }
        
        System.out.println(sum);
        
    }
}
