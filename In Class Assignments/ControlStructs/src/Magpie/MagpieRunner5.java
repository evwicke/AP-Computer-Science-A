package src.Magpie;

import java.util.Scanner;

public class MagpieRunner5
{
   /**
    * Create a Magpie5, give it user input, and print its replies.
    */
   public static void main(String[] args)
   {
      Magpie5 maggie = new Magpie5();
      System.out.println (maggie.getGreeting());
      Scanner in = new Scanner (System.in);
      String statement = in.nextLine();
		
      while (!statement.equals("Bye"))
      {
         System.out.println (maggie.getResponse(statement));
         statement = in.nextLine();
      }
      System.out.println("Thank you for the conversation. Have a nice day.");
      in.close();
   }
}