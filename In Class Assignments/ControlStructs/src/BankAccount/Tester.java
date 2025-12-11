package src.BankAccount;


/**
 * Next, create a Tester class that has a main( ) method. 
 * In that method you should input from the keyboard the amount (1000) of money initially 
 * to be put into the account (via the constructor) along with the name of the person to whom the account belongs.

Use these two pieces of data to create a new BankAccount object called myAccount.
Call the deposit method to deposit $505.22.
Print the balance instance variable.
Call the withdraw method to withdraw $100.
Print the remaining balance in this form as demonstrated below. Note: a while loop will be required, make sure you test for valid funds.
 * 
 * @evwicke
 * @11.18.25
 */
import java.util.*;
public class Tester{
    public static void main(String[] args){
        
        Scanner scan = new Scanner(System.in);
        System.out.print("Input your name\n : ");
        String name = scan.nextLine();
        System.out.print("Input your initial deposit amount\n : ");
        double initialDeposit = scan.nextDouble();
        src.BankAccount.BankAccount acc01 = new src.BankAccount.BankAccount(initialDeposit, name);
        
        char input = ' '; // set the input to initlaly be a space so the loop runs. (instead of doing do while.)
        while(input != 'q'){
            System.out.print("Would you like to deposit, withdraw, or quit? (d, w, or q)\n  : ");
            input = scan.next().toLowerCase().charAt(0); //gets the first letter, to lowercased.
            
            if(input == 'd'){
                System.out.print("How much would you like to deposit?\n   -> ");
                double deposit = scan.nextDouble();
                acc01.deposit(deposit);
            }else if(input == 'w'){
                while(true){
                    System.out.print("How much would you like to withdraw?\n   -> ");
                    double withdraw = scan.nextDouble();
                    if(withdraw <= acc01.getBalance()){
                        acc01.withdraw(withdraw);
                        break;
                    }else{
                        System.out.println("  ## NOT ENOUGH MONEY IN ACCOUNT ##  ");
                    }
                }
            }
            System.out.println(acc01); //after withdraw or deposit, tell the person how much money they have in their account.
        }
        System.out.println("Have a nice day, " + name + "."); // say goodbye to them.
    }
}
