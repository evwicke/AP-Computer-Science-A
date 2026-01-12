package Algorithms;

/**
 * Write a description of class HasDuplicates here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HasDuplicates{
    public static void main(String[] args){
        int[] arr = {13,81,5,91,10,23,18,3,12,94,23};
        System.out.println(hasDuplicates(arr));
    }

    public static boolean hasDuplicates(int[] arr){
        for(int i = 0; i<arr.length-1; i++){
            for(int j = i+1; j<arr.length;j++){
                if(arr[i] == arr[j]){
                    return true;
                }
            }
        }
        return false;
    }
}
