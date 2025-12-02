package src.Calculataz;


/**
 * calculator.
 * 
 * @evwicke
 * @12.1
 */
public class Calc{
    int add(int a, int b){
        return a+b;
    }
    int subtract(int a, int b){
        return a-b;
    }
    int multiply(int a, int b){
        return a*b;
    }
    double divide(int a, int b){
        return (double)a/b;
    }
    int modulus(int a, int b){
        return a%b;
    }
    
    int factorial(int a){
        int temp = 1;// multiplication is commutative, so im gonna do the factorial "backwards".
        for(int i = 1; i<=a;i++){ // from 1 to the number, multiply. ( doing 1 instead of 2 because what if its "1!")
            temp*=i;
        }
        if(a!=0){return temp;}else{return 1;} // for if its 0!
    }
}
