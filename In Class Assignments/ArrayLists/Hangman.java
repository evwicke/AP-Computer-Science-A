
/**
 * Write a description of class Hangman here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class Hangman{
    public static void Main(){
        Scanner in = new Scanner(System.in);
        String input;
        do{
            System.out.print(" - Choose a phrase:\n  > ");
            input = in.nextLine();
        }while(input.equals(""));

        ArrayList<String> splitPhrase = stringToArrayList(input, "");
        ArrayList<String> wrongLetters = new ArrayList<>();

        //set all the spaces to be visible
        for(int i = 0 ; i < splitPhrase.size() ; i++){
            if(splitPhrase.get(i).equals(" ")){
                splitPhrase.set(i, ("&" + splitPhrase.get(i) + " "));
            }
        }

        //make the guessing loop.
        boolean running = true;
        int misses = 6;
        
        System.out.println("\f");
        printMan(misses);
        printList(splitPhrase);
        
        while(running){

            //print out the list with underscores
            System.out.println("\nMisses: " + misses);
            System.out.println("Wrong letters: " + wrongLetters);
            //ask for user input
            System.out.print("\n - Guess a letter:\n  > ");
            String letterGuess = in.nextLine().charAt(0) + "";
            letterGuess = letterGuess.toLowerCase();

            //go thru array and check for the letter. if its there then show it in the next printlist call.
            if(wrongLetters.contains(letterGuess) || splitPhrase.contains("&"+letterGuess) || splitPhrase.contains("&"+letterGuess.toUpperCase())){
                System.out.print(" - Guess a letter that you haven't guessed before!\n");
                in.nextLine();
            }else if(splitPhrase.contains(letterGuess) || splitPhrase.contains(letterGuess.toUpperCase())){ 
                for(int i = 0 ; i < splitPhrase.size() ; i++){
                    if(splitPhrase.get(i).toLowerCase().equals(letterGuess)){
                        splitPhrase.set(i, ("&" + splitPhrase.get(i)));
                    }
                }
            }else{
                wrongLetters.add(letterGuess);
                misses--;
            }
            
            System.out.println("\f");
            printMan(misses);
            printList(splitPhrase);
            
            if(winCheck(splitPhrase)){
                System.out.println("\f  YOU WON!!! \n\n The word: ");
                printList(splitPhrase);
                printMan(misses);
                running = false;
            }
            if(misses <=0){
                System.out.println("\f  YOU LOST :(((( \n\n The word: \n" + input);
                printMan(misses);
                running = false;
            }
            
        }
    }

    public static void printMan(int misses) {
        System.out.println(); // Prints a blank line for spacing

        switch (misses) {
            case 6:
            System.out.println("  +---+");
            System.out.println("  |   |");
            System.out.println("      |");
            System.out.println("      |");
            System.out.println("      |");
            System.out.println("      |");
            System.out.println("=========");
            break;
            case 5: // Head
            System.out.println("  +---+");
            System.out.println("  |   |");
            System.out.println("  O   |");
            System.out.println("      |");
            System.out.println("      |");
            System.out.println("      |");
            System.out.println("=========");
            break;
            case 4: // Head and Body
            System.out.println("  +---+");
            System.out.println("  |   |");
            System.out.println("  O   |");
            System.out.println("  |   |");
            System.out.println("      |");
            System.out.println("      |");
            System.out.println("=========");
            break;
            case 3: // Head, Body, and One Arm
            System.out.println("  +---+");
            System.out.println("  |   |");
            System.out.println("  O   |");
            System.out.println(" /|   |");
            System.out.println("      |");
            System.out.println("      |");
            System.out.println("=========");
            break;
            case 2: // Head, Body, and Both Arms
            System.out.println("  +---+");
            System.out.println("  |   |");
            System.out.println("  O   |");
            System.out.println(" /|\\  |");
            System.out.println("      |");
            System.out.println("      |");
            System.out.println("=========");
            break;
            case 1: // Head, Body, Both Arms, and One Leg
            System.out.println("  +---+");
            System.out.println("  |   |");
            System.out.println("  O   |");
            System.out.println(" /|\\  |");
            System.out.println(" /    |");
            System.out.println("      |");
            System.out.println("=========");
            break;
            case 0: // Full Body
            System.out.println("  +---+");
            System.out.println("  |   |");
            System.out.println("  O   |");
            System.out.println(" /|\\  |");
            System.out.println(" / \\  |");
            System.out.println("      |");
            System.out.println("=========");
            break;
        }
    }

    public static boolean winCheck(ArrayList<String> arr){
        boolean returner = true;
        for(String x : arr){
            if(!x.substring(0,1).equals("&")){
                returner = false;
            }
        }
        return returner;
    }

    public static void printList(ArrayList<String> arr){
        System.out.println("");
        for(String x : arr){
            if(x.substring(0,1).equals("&")){
                System.out.print(x.substring(1,2));
            }else{
                System.out.print("-");
            }
        }
    }

    public static ArrayList<String> stringToArrayList(String inputStr, String delim){
        String[] tempArr = inputStr.split(delim);
        ArrayList<String> tempArrList = new ArrayList<>(Arrays.asList(tempArr)); // Arrays.asList lets you make an arrayList with an array as the starting point.

        return tempArrList;
    }
}