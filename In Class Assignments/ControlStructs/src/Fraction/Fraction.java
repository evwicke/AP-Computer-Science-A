package src.Fraction;


/**
 * review classes
 * 
 * @evwicke
 * @11/17/25
 */
public class Fraction{ // H
    // A
    //instance variables
    private int numer,denom;
    
    //class variable. static == can only be accessed 
    private static int fractionCount = 0; 
    
    public static final String FRACTION_FORM = "a/b"; // const are declared as public.
    //C
    public Fraction(){
        numer = 1;
        denom = 1;
        
        fractionCount++;
    }
    
    public Fraction(int n, int d){
        numer = n;
        this.denom = d;
        
        fractionCount++;
    }
    //A
    //access methods "getters"
    public int getNumerator(){
        return numer;
    }
    public int getDenominator(){
        return denom;
    }
    public static int getFractionCount(){
        return fractionCount;
    }
    //Mutators "setters"
    public void setNumerator(int n){
        numer = n;
    }
    public void setDenominator(int d){
        denom = d;
    }
    
    //other methods
    public void reduce(){
        int GCF = 1;
        for(int i = 2; i <= numer; i++){
            if(numer % i == 0 && denom % i == 0){
                GCF = i;
            }
        }
        numer /= GCF;
        denom /= GCF;
    }
    
    //tostring
    public String toString(){
        return numer + " / " + denom;
    }
    
}
