package src;

 


/**
 * Showing you rounding error in the compiler.
 * 
 * @evanw
 * @10/15/2025
 */
public class RoundingError{
    public static void main(String[] args){
        
        double x = 4.35; double y = (x * 100.0);
        //X+Y should equal 439.35;
        if(x+y == 439.35){
            System.out.println("Giddy up");
        }else{
            System.out.println("Youre a knucklehead!");
        }
        System.out.println(x + y);
        
        
        
        if(Math.abs(x+y - 439.35) < 0.001){
            System.out.println("Giddy up");
        }else{
            System.out.println("Youre a knucklehead!");
        }
    }
    
    
    
}
