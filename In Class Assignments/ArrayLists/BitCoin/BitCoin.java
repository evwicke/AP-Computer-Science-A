package BitCoin;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class BitCoin{
    public static void main() throws FileNotFoundException{
        File popFile = new File("BitCoin/bitcoindata.csv");
        Scanner in = new Scanner(popFile); // scanner on the file
        Scanner keyboard = new Scanner(System.in); // scanner on the file

        double maxAmt = Double.MIN_VALUE;
        String maxDate = "";

        double minAmt = Double.MAX_VALUE;
        String minDate = "";

        double beforeAmt = 0;
        String beforeDate = "";
        double maxChange = -10000;
        ArrayList<String> maxChangeDates = new ArrayList<>();

        //do the first loop outside of the loop. cuz you cant look back on the first line.

        {
            String lineOfText = in.nextLine();
            String[] parts = lineOfText.split(","); //.. split it over the comma.

            String date = parts[0];
            Double amt = Double.parseDouble(parts[1]);

            if(amt > maxAmt){maxAmt = amt; maxDate = date;}
            if(amt < minAmt){minAmt = amt; minDate = date;}

            beforeAmt = amt;
            beforeDate = date;
        }
        while (in.hasNext()){ // if theres a line after this... look at it.
            
            String lineOfText = in.nextLine();
            String[] parts = lineOfText.split(","); //.. split it over the comma.

            String date = parts[0];
            Double amt = Double.parseDouble(parts[1]);

            if(amt > maxAmt){maxAmt = amt; maxDate = date;}
            if(amt < minAmt){minAmt = amt; minDate = date;}

            double currentChange = amt - beforeAmt; 
            if (currentChange > maxChange) {
                maxChange = currentChange;
                maxChangeDates.clear();
                maxChangeDates.add(beforeDate);
                maxChangeDates.add(date);
            }
            
            beforeAmt = amt;
            beforeDate = date;
        }
        System.out.println("Max: "+maxAmt + " at " + maxDate);
        System.out.println("Min: "+minAmt + " at " + minDate);
        System.out.printf("Max change: %.2f between %s and %s%n", 
                maxChange, maxChangeDates.get(0), maxChangeDates.get(1));
        in.close();
    }

    public static void printArrayList(ArrayList<String> arr){
        System.out.print("[");
        for( int i = 1; i < arr.size()+1; i++){
            System.out.print(arr.get(i-1));
            if(i != arr.size()){System.out.print(", ");}
            if(i % 10 == 0){System.out.println();}
        }
        System.out.print("]");
    }
}
