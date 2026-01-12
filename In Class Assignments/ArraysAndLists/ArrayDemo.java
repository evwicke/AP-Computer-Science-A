//import java.util.Arrays;
//import java.util.Scanner;
import java.util.*;
public class ArrayDemo{
    public static void main(){

        Scanner scan = new Scanner(System.in);
        ///////////////////  Arrays   ////////////////////////
        //       * An array is a single variable that holds more 
        //             than one value. Each value is called an element, 
        //             or a member, of the array.
        //       * subscript notation identifies each element 
        //              (the first element is #0)
        //       *  General syntax for declaring an array:
        //              Type[] array_Name = new Type[Length];
        //              int[] myIntArray = new int[10];

        //              Array types in Java are reference types because Java treats arrays as objects.
        //                   Objects are not contained by variables. Instead, a variable contains a reference to an object.
        //                    A reference is similar to what is called a pointer in other languages. If there are two variables
        //                    of the same reference type and one variable is assigned to the other, both variables refer to
        //                    the same object. If the information in that object is changed, the change is visible through both variables.

        //      *    Once created, the size of an array cannot be changed
        //      *Trying to access an array element that does not exist causes an IndexOutOfBounds exception     

        //     *   .length (with NO parentheses) is the size of an array, so the last element is # length-1
        // Three ways to declare and initialize an array
        // syntax for declaring
        //  int[] grade = 
        //             or
        // int grade[] =

        int[] grade = new int[5]; 
        //  NOTE!!! all elements are zero(0) "Primitive types" when declared (not null)
        //
        // Declare and initialization
        int[] grade1 = {5,5,5,15};
        int[] grade2 = new int[] {1,2,3,2,3,3,3,4,5};

        ////////////////////////////////////////////////////
        // other ways

        int[] abc, xyz;
        abc = new int[50];
        xyz = new int[50];
        ///   or    /////////////
        //int[] abc = new int[50], xyz = new int[50];
        ///////////////////////////////////////////////////

        int[] grade3 = new int[10];
        int[] grade4 = {1,2,3,4,5,6,7,8,98};

        //         Printing an array? 
        //System.out.println(grade4);  //memeoryy location
        //printArr(grade4);

        //        Make an array of 10 ints and collect the numbers
        //        from the user
        //         System.out.println("");
        //         for(int i = 0; i< grade3.length; i++){
        //             System.out.print("Number " + (i+1) + " :  ");
        //             grade3[i] = umid.nextInt();
        //         }
        //         printArr(grade3);

        // Find an average of an array.

        //int total = 0;
        //for(int i : grade4){total += i;}
        //double average = total / (double)grade4.length;
        //printArr(grade4);
        //System.out.printf("\nThe average of array grade4 is %.8f", average);

        //         Lets make a method to generate an array of random ints?

        System.out.println("How many in the array?");
        int arrSize = scan.nextInt();
        System.out.println("Lower Bound?");
        int lowerBound = scan.nextInt();
        System.out.println("Upper Bound?");
        int upperBound = scan.nextInt();

        int[] myRandIntArray = makeRandomIntArray(arrSize, lowerBound, upperBound);
        printArr(myRandIntArray);

        //          make an array of the occurrence of each element
        //                   in an array of integers. 
        // values from 1 -> 50. then track the occurrence of each number there.

        int[] freqArr = freqArr(myRandIntArray);
        printArr(freqArr);
        
        for(int i = 0; i < getMax(myRandIntArray); i++){
            System.out.println((i+lowerBound) + ": " + freqArr[i]);
        }
        //          Find the mode of an array
        //         syntax for a For-Each loop (APCSA calls this an enhanced for loop)
        //  . . . used only with arrays, steps through an entire array, helps avoid "IndexOutOfBounds exception
        // for (dataType item : array)
        // {
        //          statements using item;
        // }

    }

    public static int[] freqArr(int[] arr){
        int maxValue = getMax(arr);
        int minValue = getMin(arr);
        int[] freqArr = new int[maxValue+1];
        for(int i = 0; i<maxValue-1;i++)freqArr[i] = 0;
        for(int i = minValue; i < maxValue; i++){
            for(int j : arr){
                if(j == i){
                    freqArr[i] = freqArr[i] + 1;
                }
            }
        }
        return freqArr;
    }

    public static int[] makeRandomIntArray(int size, int lower, int upper){
        int[] tempArray = new int[size];
        for(int i = 0; i<size; i++){
            tempArray[i] = (int)(Math.random() * (upper - lower + 1)) + lower;
        }
        return tempArray;
    }

    public static void printArr(int[] arr){
        System.out.print("\n{");
        for(int i = 0; i<arr.length; i++){
            if(i!= arr.length-1){
                System.out.print(arr[i] + ",");
                if(i % 20 == 0 && i != 0)System.out.println();
            }else{
                System.out.print(arr[i]);
            }
        }
        System.out.println("}");
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

    public static int getMin(int[] arr){
        int min = arr[0];
        for(int i : arr){
            if(i < min){
                min = i;
            }
        }
        return min;
    }
}