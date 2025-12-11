package src.Calculataz;


/**
 * calc client.
 * 
 * @evwicke
 * @12.1
 */
public class CalcTester{
    public static void main(String[] args){
        Calc mathz = new Calc();
        System.out.println("6 + 7 = " + mathz.add(6,7));
        System.out.println("6 - 7 = " + mathz.subtract(6,7));
        System.out.println("6 * 7 = " + mathz.multiply(6,7));
        System.out.println("6 / 7 = " + mathz.divide(6,7));
        System.out.println("6 % 7 = " + mathz.modulus(6,7));
        
        System.out.println("6! = " + mathz.factorial(6));
    }
}
