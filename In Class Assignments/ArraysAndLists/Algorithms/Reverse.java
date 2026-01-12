package Algorithms;


/**
 * Write a description of class Reverse here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Reverse{
    public static void main(String[] args){
        int[] arr = {13,81,5,91,10,23,18,3,12,94,23};
        int[] arr2 = {1,3,5,7,9,11,13,15,17,19,21,23,25};
        int[] arr3 = {0,2,4,6,8,10};
        System.out.println("Original");
        printArr(arr2);
        System.out.println("Reversed");
        reverseArr(arr2);
        printArr(arr2);
        System.out.println("Original");
        printArr(arr3);
        System.out.println("Reversed");
        reverseArr(arr3);
        printArr(arr3);
    }
    
    public static void reverseArr(int[] arr){
        int intHalf = arr.length / 2;
        int temp;
        for(int i = 0; i<intHalf; i++){
            temp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = temp;
        }
    }
    
    public static void printArr(int[] arr){
        System.out.print("{");
        for(int i = 0; i<arr.length; i++){
            if(i!= arr.length-1){
                System.out.print(arr[i] + ",");
            }else{
                System.out.print(arr[i]);
            }
        }
        System.out.println("}");
    }
}
