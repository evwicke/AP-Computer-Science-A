 

import java.util.*;
public class ClassroomDriver{
    public static void Main(){
        Scanner scan = new Scanner(System.in);

        System.out.print("How many rows in your class?\n  : ");
        int rows = scan.nextInt();
        System.out.print("How many columns in your class?\n  : ");
        int cols = scan.nextInt();
        System.out.print("How many people in your class?\n  : ");
        int people = scan.nextInt();

        Classroom myClass = new Classroom(rows, cols);

        clearScreen();
        myClass.printClass();

        for(int i = 0; i<people; i++){
            clearScreen();
            askSeat(rows, cols, myClass, scan);
            clearScreen();
            myClass.printClass();
        }
    }

    public static void clearScreen() {
        System.out.print('\u000c');
    }
    
    static boolean flip = false;
    public static void askSeat(int rows, int cols, Classroom myClass, Scanner scan){
        if(flip == true){
            System.out.println("Seat not available. Try again.");
            flip = false;
        }

        try{
            myClass.printClass();
            System.out.print("Which row do you want to sit in? \n  : ");
            int row = scan.nextInt();
            System.out.print("Which column do you want to sit in? \n  : ");
            int col = scan.nextInt();
            if(myClass.seatFilled(row, col)){
                flip = true;
                askSeat(rows, cols, myClass, scan);
            }else{
                scan.nextLine();
                System.out.print("What are your initials? \n  : ");
                String init = scan.nextLine();

                myClass.setSeat(row, col, init);
            }
        }catch(Exception e){
            scan.nextLine(); // clear the enter key
            flip = true;
            askSeat(rows, cols, myClass, scan);
        }
    }
}
