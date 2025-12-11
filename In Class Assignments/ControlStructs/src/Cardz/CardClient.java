package src.Cardz;


/**
 * Write a description of class CardClient here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CardClient{
    public static void main(String[] args){
        int total = 0;
        
        for(int i = 1; i <=20; i++){
            Card card = new Card();
            total += card.getValue();
            System.out.println(card);
        }
        
        System.out.println("The total value of the cards is: " + total);
    }
}
