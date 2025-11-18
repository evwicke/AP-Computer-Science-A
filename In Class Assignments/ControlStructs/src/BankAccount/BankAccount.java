package src.BankAccount;


/**
 * Write a description of class BankAccount here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BankAccount{ //header
    //global values
    private double balance;
    private String name;
    //constructors
    public BankAccount(){
        balance = 0.00;
        name = "John Doe";
    }
    public BankAccount(double balance, String name){
        this.balance = balance;
        this.name = name;
    }
    //accessors
    public double getBalance(){
        return balance;
    }
    public String getName(){
        return name;
    }
    //other/mutators
    public void deposit(double d){
        balance += d;
    }
    public void withdraw(double w){
        balance -= w;
    }
    private double round(double value, int places){ // rounds double to a certain place value
        return (int)(value * Math.pow(10, places) + 0.5)/Math.pow(10,places);
    }
    //toString overriding
    public String toString(){ 
        return name + "'s Account Balance: $"+ round(balance,2);
    }
    
    
}
