
/**
 * Write a description of class Arrayz4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arrayz4{
    public static void main(String[] args){
        int[] randArr = ArrUtil.makeRandomIntArray(100, 0, 100);
        ArrUtil.printArr(randArr); 
        
        int[] freqArr = ArrUtil.freqArr(randArr, 0, 100);
        ArrUtil.printArr(freqArr);
        
        ArrUtil.graphicalFreq(freqArr);
    }
}
