package src;


/**
 * Write a description of class SpottedJimmy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
public class SpottedJimmy{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
    
        ArrayList<Integer> catNumList = new ArrayList<Integer>(); //init all of my varibles so they can be changed in the while loop
        char runner;
        String runnerFlip;
        int enemyCount;
		int runCounter = 0;
        do{
            // Clear the catNumList every time ( used for when the user reruns the code )
            catNumList.clear();

			if(runCounter != 0){
				System.out.println("----------------------------------------------");
			 }

            //user input
            print("Input how many enemies you have: ");
            enemyCount = scan.nextInt();
            for(int i = 1; i<=enemyCount;i++){
                print("  How many cats does enemy " + i + " have?\n   : ");
                catNumList.add(scan.nextInt());
            }
            


			// analysis
            int catSum = catNumList.stream().mapToInt(Integer::intValue).sum(); // get the sum of the array
        
            int oddCatAmounts = 0;
            for(int cat : catNumList){
                if(cat % 2 == 1){
                    oddCatAmounts++;
                }
            }
            int catGreater17Div7 = 0;
            for(int cat : catNumList){
                if(cat > 17 && cat % 7 == 0){
                    catGreater17Div7++;
                }
            }

			//outputting and formatting response
            System.out.printf("\n Total Amt of Cats: %d"
                        + "\n Odd Cat Amts: %d"
                        + "\n Cat Amts > 17 and divisible by 7: %d\n",
                        catSum, oddCatAmounts, catGreater17Div7
            );
            
            
            //logic for rerunning
            scan.nextLine(); // CLEAR THE ENTER KEY!!
            print("\n Rerun? (y/n)");
            runner = (char)scan.next().charAt(0); // using to just get the first word the user enters
            runnerFlip = String.valueOf(runner); // turns the char into a string
			runCounter++;
        }while(runnerFlip.equalsIgnoreCase("y"));
    }
    
    public static void print(String arg){
        System.out.print(arg);
    }
}
