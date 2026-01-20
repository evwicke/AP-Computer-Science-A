
/**
 * Write a description of class Arrayz5 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import Die.Die;
public class Arrayz5{
    public static void main(String[] args){
        Die die1 = new Die();
        Die die2 = new Die();
        
        final int ROLL_COUNT = 720;
        int[] rollSumArr = new int[ROLL_COUNT];
        for(int i = 0; i<ROLL_COUNT;i++){
            die1.roll();
            die2.roll();
            rollSumArr[i] = (die1.getCurrentSide()) + (die2.getCurrentSide());
        }
        
        int[] freqArr = ArrUtil.freqArr(rollSumArr, 2, 12);
        ArrUtil.printArr(freqArr);
        
        ArrUtil.autoSimpleGraphicalFreq(freqArr, 40);
    }
}
