package src.Die;

/**
 * Roll 36,000 times and see how many times it is sum 12.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class BoxCars{
    public static void main(String[] args){
        Die die1 = new Die();
        Die die2 = new Die();

        int boxCars = 0;
        for(int i = 1; i<=36000; i++){
            die1.roll();
            die2.roll();
            System.out.print(die1.getCurrentSide()+"|"+die2.getCurrentSide() + " ");
            if(i % 20 == 0){System.out.println();}
           
            if(die1.getCurrentSide() == 6 && die2.getCurrentSide() == 6){
                boxCars++;
            }
        }
        System.out.println("\nThe amount of times there were boxcars was " + boxCars + " times.");
    }
}
