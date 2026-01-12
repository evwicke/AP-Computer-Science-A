package Algorithms;


/**
 * Write a description of class Shift here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shift{
    public static void main(String[] args){
        int[] arr = {13,81,5,91,10,23,18,3,12,94,23};
        int[] arr2 = {1,3,5,7,9,11,13,15,17,19,21,23,25};
        System.out.println("Original");
        printArr(arr2);
        System.out.println("Right");
        shiftRight(arr2);
        printArr(arr2);
        System.out.println("Back to Original");
        shiftLeft(arr2);
        printArr(arr2);
        System.out.println("Left");
        shiftLeft(arr2);
        printArr(arr2);
    }

    public static void shiftRight(int[] arr){
        int temp = arr[arr.length-1];
        for(int i = arr.length-1; i>0; i--){
            arr[i] = arr[i-1];
        }
        arr[0] = temp;
    }
    
    public static void shiftLeft(int[] arr){
        int temp = arr[0];
        for(int i = 0; i<arr.length-1;i++){
            arr[i] = arr[i+1];
        }
        arr[arr.length-1] = temp;
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
