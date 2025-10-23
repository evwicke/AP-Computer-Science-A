package src;


/**
 * Making loops like for loops and while loops
 * @evanwicke
 * @10/23/2025
 */
public class FunWithForLoops{
    public static void main(String[] args){
        for(int i = 55; i<=61; i++){ // domain interval notation [55, 61]
            System.out.print(i+ "  ");
        }
        System.out.println(); // to seperate the for loops
        for(int i = 40; i<=50; i++){ // [40, 50]
            if(i%2==0){System.out.print(i+ "  ");} // if its even, print it. if not, dont.
        }
        System.out.println();
        for(int i = 2; i>=-9; i--){
            System.out.print(i+ "  ");
        }
        
        //         int counter = 1;
        //         while(true)/*to make sure it keeps runnning */{
            //             System.out.print(counter + " ");
            //             if(counter%8 == 0){System.out.println();}
            //             counter++;
        //         }
        
    }
}
