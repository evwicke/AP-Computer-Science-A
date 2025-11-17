package src.BankAccount;


/**
 * Write a description of class BankAccount here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BankAccount{
    
    private double balance;
    private String name;
    
    public BankAccount(){
        balance = 0.00;
        name = "John Doe";
    }
    public BankAccount(double balance, String name){
        this.balance = balance;
        this.name = name;
    }
    
    public double getBalance(){
        return balance;
    }
    public String getName(){
        return name;
    }
    
    public void deposit(double d){
        balance += d;
    }
    
    public void withdraw(double w){
        if(w<=balance){
            balance -= w;
        }else{
            System.out.println("Not enough money in account to withdraw.");
        }
        
    }
    
    
}
