package src;


/**
 * greets walter white, walter, or a random person.
 * 
 * @evanwicke
 * @10/22/2025
 */
import java.util.*;
public class Walter{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        System.out.print("What is your name? \n  : ");
        String name = scan.nextLine(); //do nextLine not just next to get whole line not first word
        String[] splitName = name.split(" "); // split sentence by the spaces
        
        if(splitName[0].equals("Walter") && splitName[splitName.length-1].equals("White")){ // if the first name is walter and the last name white, this is true
            System.out.println("Heisenberg. Your name is.. Heisenberg.");
            
        }else if(splitName[0].equals("Walter")){ // else if the first name is walter, this is true
            System.out.println("Oh the great Walter has arrived!");
            
        }else{
            System.out.printf("Welcome %s %s.",splitName[0],splitName[splitName.length-1]); //otherwise it greets you.
        }
    }
}
