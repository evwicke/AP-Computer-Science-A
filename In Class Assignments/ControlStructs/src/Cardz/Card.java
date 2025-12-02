package src.Cardz;


/**
 * Write a description of class Card here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Card{
    private int value;
    private String suit;
    
    public Card(){
        value = (int)(Math.random()*13)+1;
        int tempSuit = (int)(Math.random()*4)+1;
        switch(tempSuit){
            case 1:
                suit = "Diamonds"; break;
            case 2:
                suit = "Clubs"; break;
            case 3:
                suit = "Spades"; break;
            case 4:
                suit = "Hearts"; break;
        }
    }
    
    public int getValue(){
        return value;
    }
    public String getSuit(){
        return suit;
    }
    
    public String toString(){
        String rank;
        switch(value){
            case 11: 
                rank = "Jack"; break;
            case 12: 
                rank = "Queen"; break;
            case 13: 
                rank = "King"; break;
            case 1: 
                rank = "Ace"; break;
            default: 
                rank = Integer.toString(value); break;
        }
        
        return rank + " of " + suit;
    }
}
