package src.Fraction;


/**
 * Write a description of class FractionDriver here.
 * 
 * @evwicke
 * @11.17.25
 */
public class FractionDriver{
    public static void Main(){ //drivers dont need Sreing args
        //create a fraction object
        Fraction frac1 = new Fraction();
        System.out.println(frac1);
        Fraction frac2 = new Fraction(12,32);
        System.out.println(frac2);
        
        frac2.reduce();
        System.out.println("Reduced frac2: " +frac2);
        
        Fraction frac3 = new Fraction(48,12);
        System.out.println(frac3);
        frac3.reduce();
        System.out.println("Reduced frac3: " +frac3);
        
        frac1.setNumerator(5);
        frac1.setDenominator(10);
        
        System.out.println("frac1 num = " +frac1.getNumerator());
        System.out.println("frac1 denom = " +frac1.getDenominator());
        frac1.reduce();
        System.out.println("frac1 num = " +frac1.getNumerator());
        System.out.println("frac1 denom = " +frac1.getDenominator());
        
        System.out.println(Fraction.getFractionCount());
        System.out.println(Fraction.FRACTION_FORM);
    }
}
