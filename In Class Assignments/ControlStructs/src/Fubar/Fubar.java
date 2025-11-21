package src.Fubar;

/**
 * Write a description of class Fubar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class Fubar{
    private int age;
    private Scanner scan = new Scanner(System.in);

    public Fubar(int age){
        this.age = age;
    }

    public boolean ageDiv(){
        if(age % 5 == 0){return true;}else{return false;}
    }
    public double abs(double n){
        if(n<0){n*=-1;}; return n;
    }
    public char nextToLast(String w){
        return w.charAt(w.length()-1);
    }
    public String getName(){
        System.out.println(" > What is your first name? ");
        String name = scan.next();
        return name + ", the Knucklehead";
    }
    public void displayStuff(int n, String w){
        for(int i = 1; i<= n; i++){System.out.print(w + "  ");}
    }
    public int findIndex(String w, char c){
        int temp = w.indexOf(c);
        if(temp == -1){return 999;}else{return temp;}
    }
    public boolean isItPrime(int n){
        if (n <= 1) {return false;} // all negatives are composite, and both 0 and 1.
        if (n == 2) {return true;} // 2 is prime.
        if (n % 2 == 0) {return false;}// evens are not prime.
        for (int i = 3; i * i <= n; i += 2) { // as long as there isnt a factor within [3, sqrt(n)], it is prime.
            if (n % i == 0) {return false;}
        }
        return true;
    }
    public int getPrimez(int lowerBound, int upperBound){
        int counter = 0;
        for(int i=lowerBound; i<=upperBound; i++){
            if(isItPrime(i)){counter++;}
        }
        return counter;
    }
    public int sumOfDigits(int n){
        int[] digits = {0,0,0}; 
        
    }
}
