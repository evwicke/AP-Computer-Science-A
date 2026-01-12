package Algorithms;


/**
 * Write a description of class MinMax here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MinMax{
    public static void main(String[] args){
        int[] arr = {13,81,5,91,10,23,18,3,12,94};
        
        int min = getMin(arr);
        int max = getMax(arr);
        
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
    }
    
    public static int getMin(int[] arr){
        int min = arr[0];
        for(int i : arr){
            if(i < min){
                min = i;
            }
        }
        return min;
    }
    public static int getMax(int[] arr){
        int max = arr[0];
        for(int i : arr){
            if(i > max){
                max = i;
            }
        }
        return max;
    }
}
