package Algorithms;


/**
 * Write a description of class IsSorted here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IsSorted{
    public static void main(String[] args){
        int[] arr = {13,81,5,91,10,23,18,3,12,94};

        boolean arrIsSorted = isSorted(arr);
        System.out.println(arrIsSorted);
    }
    
    public static boolean isSorted(int[] arr){
        boolean flag = true;
        for(int i = 1; i<arr.length; i++){
            if(arr[i] < arr[i-1]){
                flag = false;
                break;
            }
        }
        return flag;
    }
}
