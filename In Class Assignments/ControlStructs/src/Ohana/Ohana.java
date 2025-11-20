package src.Ohana;


/**
 * Ohana Class ! Family !
 * 
 * @evwicke
 * @11/17/25
 */

import java.util.*;
public class Ohana{
    private Scanner scan = new Scanner(System.in);
    private int peopleInFam;
    private ArrayList<Integer> ages = new ArrayList<Integer>();
    
    public Ohana(){
        setData();
    }
    
    public double getAvg(){
        int total = ages.stream().mapToInt(Integer::intValue).sum(); // get the sum
        return (double)total/peopleInFam;
    }
    public int getOldest(){
        int oldest = 0;
        for(int a : ages){ // for each age in the age array ,  ...
            if(a > oldest){
                oldest = a;
            }
        }
        return oldest;
    }
    public int getYoungest(){
        int youngest = 300;
        for(int a : ages){
            if(a < youngest){
                youngest = a;
            }
        }
        return youngest;
    }
    public int getNumOdds(){
        int numOdd=0;
        for(int a : ages){
            if(a % 2 == 1){
                numOdd++;
            }
        }
        return numOdd;
    }
    public int getNumEvens(){
        int numEven=0;
        for(int a : ages){
            if(a % 2 == 0){
                numEven++;
            }
        }
        return numEven;
    }
    public int getNumAdults(){
        int numAdults=0;
        for(int a : ages){
            if(a >= 20){
                numAdults++;
            }
        }
        return numAdults;
    }
    public int getNumTeens(){
        int numTeens=0;
        for(int a : ages){
            if(a <= 19 && a >=13){
                numTeens++;
            }
        }
        return numTeens;
    }
    public int getNumKids(){
        int numKids=0;
        for(int a : ages){
            if(a <= 12){
                numKids++;
            }
        }
        return numKids;
    }
    
    public void setData(){
        System.out.print(" > How many people are in your family?\n  : ");
        peopleInFam = scan.nextInt();
        
        System.out.print(" > How old are each person?\n");
        for(int i = 0; i < peopleInFam; i++){
            System.out.print("  : ");
            
            int counter = 0;
            int age;
            do{
                if(counter!=0){System.out.print(" *** TRY AGAIN *** ");}
                age = scan.nextInt();
                counter++;
            }while(age<1);
            
            ages.add(age);
        }
    }
    
    //tostring
    public String toString(){
        return "Average: " + getAvg() + "\n"
                +"Oldest: " + getOldest()+ "\n"
                +"Youngest: " + getYoungest()+ "\n"
                +"Num Odd: " + getNumOdds()+ "\n"
                +"Num Even: " + getNumEvens()+ "\n"
                +"Num Teens: " + getNumTeens()+ "\n"
                +"Num Adults: " + getNumAdults()+ "\n"
                +"Num Kids: " + getNumKids();
    }
}
