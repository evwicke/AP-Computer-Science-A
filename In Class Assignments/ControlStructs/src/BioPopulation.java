package src;


/**
 * This class should accept inputs and display a prediction of the total population. 
 * This is practice with using loops!! YOU MUST use a LOOP not the formula
 * 
 * @evanwicke
 * @10/24/2025
 */
import java.util.*;
public class BioPopulation{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Please enter information about the isolated system:\n\n  Population: ");
        double initialPop = scan.nextDouble();
        
        System.out.print("  Growth Factor (per time length): ");
        double gFactor = scan.nextDouble();
        
        System.out.print("  Time Length (in hrs): ");
        int gHours = scan.nextInt();

        System.out.print("  Duration of Test (in hrs): ");
        int dHours = scan.nextInt();
        
        if(dHours%gHours == 0){ // if the hours per iteration fit into the duration,
            for(int i = 0; i<dHours; i+=gHours){ // do all iterations.
                initialPop*=gFactor; //for each set of hours, multiply by the growth factor
            }
        }else{ //if they dont,
            for(int i = 0; i<dHours-gHours; i+=gHours){ //dont do the last iteration, it will go over the duration.
                initialPop*=gFactor; //for each set of hours, multiply by the growth factor
            }
        }
        
        System.out.println("\n The new population is: " + (int)(initialPop) + ".");
        
    }
}
