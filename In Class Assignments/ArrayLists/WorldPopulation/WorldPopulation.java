package WorldPopulation;



import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class WorldPopulation
{
    public static void main() throws FileNotFoundException{
        File popFile = new File("WorldPopulation/WorldPopulation2025.csv");
        Scanner in = new Scanner(popFile); // scanner on the file
        Scanner keyboard = new Scanner(System.in); // scanner on the file

        int maxPop = Integer.MIN_VALUE;
        String maxCountry = "";

        int minPop = Integer.MAX_VALUE;
        String minCountry = "";

        ArrayList<String> keyCountries = new ArrayList<>();
        System.out.print(" What keyword do you wanna look for ? \n  > ");
        String keyword = keyboard.next().trim().toLowerCase();

        in.nextLine(); // SKIP THE FIRST LINE OF HEADERS.
        while (in.hasNext()){ // if theres a line after this... look at it.
            String lineOfText = in.nextLine();
            String[] parts = lineOfText.split(","); //.. split it over the comma.

            String country = parts[0]; // the name is the first thing in the array, the population is converted from string to int of the second index
            int population = Integer.parseInt(parts[1]);

            //largest
            if (population > maxPop) {
                maxPop = population; 
                maxCountry = country;
            }

            //smallest
            if (population < minPop) {
                minPop = population; 
                minCountry = country;
            }

            if (country.toLowerCase().contains(keyword)) {
                keyCountries.add(country);
            }
        }

        System.out.println("Largest Population: " + maxCountry + " with " + maxPop);
        System.out.println("Smallest Population: " + minCountry + " with " + minPop);
        System.out.println("Countries containing '" + keyword + "':");
        printArrayList(keyCountries);

        
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
