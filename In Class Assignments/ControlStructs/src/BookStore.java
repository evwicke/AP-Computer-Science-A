package src;


/**
 * Write a description of class BookStore here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class BookStore{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        ArrayList<Double> bookPricesMarkup = new ArrayList<>();
        int counter = 0;
        double price = 0;
        while(price != -1){
            try{
                if(counter==0){
                    System.out.print("Please input the prices of the books.\n   : ");
                }else{
                    System.out.print("   : ");
                }
                price = scan.nextDouble();
                bookPricesMarkup.add(price);
                
                counter++;
            }catch(Exception e){System.out.println("Error");}
        }
        bookPricesMarkup.remove(bookPricesMarkup.size()-1);
        
        ArrayList<Double> bookPricesNormal = new ArrayList<>();
        int c = 0;
        double markupPrice = 0;
        for(double p : bookPricesMarkup){
            double markedPrice = bookPricesMarkup.get(c);
            bookPricesNormal.add(markedPrice - markedPrice*0.1);
            markupPrice+=bookPricesMarkup.get(c);
            c++;
        }
        
        double totPrice = 0;
        for(double p : bookPricesNormal){
            totPrice+=p;
        }
        System.out.println(bookPricesMarkup);
        System.out.println(bookPricesNormal);
        System.out.println(markupPrice);
        System.out.println(totPrice);
        
        double totMarkup = markupPrice - totPrice;
        System.out.println(totMarkup);
        System.out.printf("\n The total price is $%.2f\n The markup of all the books is $%.2f", totPrice,totMarkup);
    }
}
