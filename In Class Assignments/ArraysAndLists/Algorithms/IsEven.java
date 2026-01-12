package Algorithms;

/**
 * Write a description of class IsEven here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IsEven{
    public static void main(String[] args){
        int[] arr = {13,81,5,91,10,23,18,3,12,94};

        boolean isAllEven = checkIsEven(arr);
        System.out.println("Is all even: " + isAllEven);
    }

    public static boolean checkIsEven(int[] arr){
        boolean flag = true;
        for(int i : arr){
            if( i % 2 != 0){
                flag = false;
            }
        }
        return flag;
    }
}
