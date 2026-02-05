
/**
 * Write a description of class Arrayz2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arrayz2{
    public static void main(String[] args){
        int[] randArr = ArrUtil.makeRandomIntArray(20, 0, 50);
        ArrUtil.printArr(randArr); 
        
        int[] freqArr = ArrUtil.freqArr(randArr,1, 10);
        ArrUtil.printArr(freqArr);
        
    }
}
