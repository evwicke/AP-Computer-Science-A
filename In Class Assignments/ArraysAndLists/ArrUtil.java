import java.util.function.*;
import java.util.*;
public class ArrUtil{
    public static int[] makeRandomIntArray(int size, int lower, int upper){
        int[] tempArray = new int[size];
        for(int i = 0; i<size; i++){
            tempArray[i] = (int)(Math.random() * (upper - lower + 1)) + lower;
        }
        return tempArray;
    }

    public static int[] freqArr(int[] arr, int minValue, int maxValue){
        int[] freqArr = new int[maxValue - minValue + 1]; // to get the amount of "spaces" you need.
        for (int j : arr) { // "j" is arr[i], is the value that we are looking at.
            freqArr[j - minValue]++; // add i to the index of the value shifted over by the lower bound.
        }
        return freqArr;
    }
    //▪
    public static void graphicalFreq(int[] arr){
        int[] groupedArr = new int[10];
        double indexer = 0.1;
        for(int i = 0; i<arr.length; i++){
            groupedArr[(int)indexer]+=arr[i];
            indexer += 0.1;
        }
        
        for(int i = 0; i<groupedArr.length; i++){
            System.out.print("\n0-10: "); printChars('▪', groupedArr[i]);
        }
    }

    public static void printChars(char value, int amt){
        for(int i = 1; i<=amt; i++){
            System.out.print(value);
        }
    }
    
    public static void printArr(int[] arr){
        System.out.print("\n{");
        for(int i = 0; i<arr.length; i++){
            if(i!= arr.length-1){
                System.out.print(arr[i] + ",");
                if(((i+1)%15 == 0))System.out.print("\n ");
            }else{
                System.out.print(arr[i]);
            }
        }
        System.out.println("}");
    }

    public static int[] setArray(int amtOfNums, Predicate<Integer> condition){
        Scanner scan = new Scanner(System.in);
        int[] tempArr = new int[amtOfNums];
        for (int i = 0; i < tempArr.length; i++) {
            System.out.print("  " + (i+1) + ": ");
            int tempVal = scan.nextInt();
            if (!condition.test(tempVal)) {
                System.out.println("Invalid input. Please try again.");
                i--; 
            } else {
                tempArr[i] = tempVal;
            }
        }
        return tempArr;
    }

    public static int getMode(int[] arr) {
        int maxValue = getMax(arr);
        int minValue = getMin(arr);
        int[] freqArr = new int[maxValue - minValue + 1];
        for (int j : arr) {
            freqArr[j - minValue]++;
        }
        int maxCount = 0;
        int modeValue = -1;
        for (int i = 0; i < freqArr.length; i++) {
            if (freqArr[i] > maxCount) {
                maxCount = freqArr[i];
                modeValue = i + minValue;
            }
        }
        if (maxCount > 1) {
            return modeValue;
        } else {
            return -1;
        }
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
