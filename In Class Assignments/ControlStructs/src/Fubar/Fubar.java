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

    public Fubar(){
        this.age = 42;
    }

    public Fubar(int age){
        this.age = age;
    }

    public boolean ageDiv(){
        if(age % 5 == 0){return true;}
        else{return false;}
    }
    public double abs(double n){
        if(n<0){n*=-1;}; return n;
    }
    public double abs(double n1, double n2){
        double smaller = (n1 < n2) ? n1 : n2;
        return abs(smaller);
    }
    public char nextToLast(String w){
        return w.charAt(w.length()-2);
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
    public boolean same(String w1, String w2) {
        return w1.equals(w2);
    }

    public boolean same(String w) {
        return w.equals("bird");
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
        digits[0] = n / 100;
        digits[1] = (n % 100) / 10;
        digits[2] = (n % 10);
        return digits[0] + digits[1] + digits[2];
    }
    public int convertToDecimal(String s){
        int decimal = 0;
        for (int i = 0; i < 8; i++) {
            decimal = decimal * 2;
            if (s.charAt(i) == '1') {
                decimal = decimal + 1;
            }
        }
        return decimal;
    }
    private void displayGreeting() {
        System.out.println("oh hey.");
    }

    public void letterGame() {
        displayGreeting();
        char target = (char) ('a' + (int) (Math.random() * 26));
        System.out.println("Guess the letter (a-z). You have 10 tries.");

        for (int i = 0; i < 10; i++) {
            String guess = scan.next();
            if (guess.charAt(0) == target) {
                System.out.println("You guessed it!");
                return;
            }
        }
        System.out.println("You ran out of guesses. It was: " + target);
    }
}
