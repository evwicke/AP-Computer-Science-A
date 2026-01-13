
/**
 * Write a description of class ArrUtilClientTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class ArrUtilClientTest{
    public static void main(String[] args){
        int[] test1 = ArrUtil.setArray(5, i -> i>=0 && i<10);
        ArrUtil.printArr(test1);
        
        System.out.println(ArrUtil.getMode(test1));
        
        
        
        
    }
}
