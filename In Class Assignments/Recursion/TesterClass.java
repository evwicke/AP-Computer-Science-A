
/**
 * Tester class for all the recursive projects
 * @evwicke
 * 3/23/2026 -> x/xx/2026
 */
import java.util.Scanner;
import java.util.*;
public class TesterClass{
    public static void Main(){
        Scanner in = new Scanner(System.in);

        /*
         * Factorial Tester
         */
        System.out.print("What do you want to factorial? \n  > ");
        int num = in.nextInt();
        System.out.println(num + "! = " + Recursion.factorial(num));
        // ----------------------------------------------------

        /*
         * ArraySum Tester
         */
        ArrayList<Integer> arraySumList = new ArrayList<>(Arrays.asList(5,10,15,10,5));
        System.out.print("Array to sum \n  > " + arraySumList);
        System.out.println("\nSum of list is " + Recursion.arraySum(arraySumList));
        // ----------------------------------------------------

        /*
         * EvenCount Tester
         */
        ArrayList<Integer> evenCountList = new ArrayList<>(Arrays.asList(12,9,13,25,16,9,54,23,18));
        System.out.print("Array to sum \n  > " + evenCountList);
        System.out.println("\nAmount of evens in list is " + Recursion.evenCount(evenCountList));
        // ----------------------------------------------------

        /*
         * Euclid Tester
         */
        System.out.print("What is the first number you want to Euclid (bigger)? \n  > ");
        int gcdNum = in.nextInt();
        System.out.print("What is the second number you want to Euclid (smaller)? \n  > ");
        int gcdNum2 = in.nextInt();
        System.out.println("GCD("+gcdNum+" + "+gcdNum2+") = " + Recursion.gcd(gcdNum, gcdNum2));
        // ----------------------------------------------------

        /*
         * Pascal Tester
         */
        System.out.print("What is the line number of Pascal's triangle you want? \n  > ");
        int pascalNum = in.nextInt();

        System.out.println("The line is: " + Recursion.pascal(pascalNum));
        // ----------------------------------------------------
    }
}

class Recursion{
    public static int factorial(int num){
        if(num == 0){return 1;} // base case, 0! = 1.

        return num * factorial(num-1); // same logic of 5! = 5 * 4! = 5 * 4 * 3!... etc.
    }

    public static int arraySum(ArrayList<Integer> list){
        if(list.size() <= 0){return 0;}
        /* if the list is empty, return 0. This stops the recursive
         * calls from keeping going.*/

        return list.remove(0) + arraySum(list);
        /* return the first value, then arraySum the 2nd value onwards.*/ 
    }

    public static int evenCount(ArrayList<Integer> list){
        if(list.size() <=0){return 0;} // same as arraySum. it stops the recursive calls.
        else if(list.get(0) % 2 == 1){list.remove(0); return 0 + evenCount(list);}
        /* if the value is odd, remove it, then recurse over the new list.*/
        else{list.remove(0); return 1 + evenCount(list);}
    }

    public static int gcd(int a, int b){
        if(a%b == 0){return b;} 
        // if a goes into b, return b because it is the gcd.

        return gcd(b, a%b); 
        // if it doesnt fit, find the gcd of the second number 
        // and how far off a and b are from being divisible.
        /* EXAMPLE:
         * 
         *  60 % 18 == 6
         *  
         *  SHIFT ALL OVER BY 1 (this is what the return statement does)
         *  
         *  18 % 6 == 0
         *       | 
         *       V
         *       returned 6.
         */
    }

    /**
     * Precondition: n must be greater than 0.
     */
    public static ArrayList<Integer> pascal(int n){
        ArrayList<Integer> list = new ArrayList<>();
        //base case
        if (n == 0) { //cuz the triangle starts at 1
            list.add(1);
            return list;
        }

        ArrayList<Integer> last = pascal(n-1);
        //1 3 3 1
        list.add(1);
        // 1 3 3 1 (last recursion)
        // 1 (new recursion, the one we will return)
        for(int i = 1; i < last.size(); i++){
            list.add(last.get(i-1) + last.get(i));
            /* where i = 1:
             *      taking the one and 3 and adding them, add a 4 to the list.
             *      1 4
             * where i = 2:
             *      taking the 3 and 3 and adding them, add a 6 to the list.
             *      1 4 6
             * where i = 3:
             *      taking the 3 and 1 and adding them, add a 4 to the list.
             *      1 4 6 4
             * where i = 4:
             *      loop does not execute ( 4 !< 4 ).
             */
        }
        list.add(1);
        // 1 4 6 4 1
        
        return list;

        /* 1
         * (11) these go to the 2
         * (1(2)1) those are the 2 groupings and they both go to 3.
         * (1(3)(3)1) these are the 3 groupings, the outer ones go to 4, and the inner ones go to 6
         * 14641
         */
    }
}
