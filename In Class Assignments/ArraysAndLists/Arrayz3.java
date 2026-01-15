
/**
 * Write a description of class Arrayz3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arrayz3{
    public static void main(String[] args){
        int[] randArr = ArrUtil.makeRandomIntArray(10, -25, 25);
        ArrUtil.printArr(randArr); 
        
        int[] freqArr = ArrUtil.freqArr(randArr, -25, 25);
        ArrUtil.printArr(freqArr);
        
    }
}
