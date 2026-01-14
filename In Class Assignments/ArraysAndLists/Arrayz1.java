
/**
 * Write a description of class Arrayz1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import java.util.function.*;
public class Arrayz1{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print(" > How many grades are you inputting?\n   : ");
        final int AMT_OF_GRADES = scan.nextInt();
        int[] grades = ArrUtil.setArray(AMT_OF_GRADES, i -> i<=100 && i>=0);
        String[] letterGrades = getLetterGrades(grades);
        for(int i = 0; i<AMT_OF_GRADES; i++){
            System.out.println("  Score #"+ (i+1) + " = " + grades[i] + "%, which is a " + letterGrades[i] + ".");
        }
    }
    public static String[] getLetterGrades(int[] arr){
        String[] returnedArray = new String[arr.length];
        for(int i = 0; i<arr.length; i++){
            if(arr[i]>=96){returnedArray[i] = "A+";}
            else if(arr[i]>=93){returnedArray[i] = "A";}
            else if(arr[i]>=89){returnedArray[i] = "A-";}
            else if(arr[i]>=86){returnedArray[i] = "B+";}
            else if(arr[i]>=83){returnedArray[i] = "B";}
            else if(arr[i]>=79){returnedArray[i] = "B-";}
            else if(arr[i]>=76){returnedArray[i] = "C+";}
            else if(arr[i]>=73){returnedArray[i] = "C";}
            else if(arr[i]>=69){returnedArray[i] = "C-";}
            else if(arr[i]>=66){returnedArray[i] = "D+";}
            else if(arr[i]>=63){returnedArray[i] = "D";}
            else if(arr[i]>=59){returnedArray[i] = "D-";}
            else{returnedArray[i] = "F";}
        }
        return returnedArray;
    }
}
