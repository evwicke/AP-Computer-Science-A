import java.util.*;
public class ClassroomDriver{
    public static void Main(){
        Scanner scan = new Scanner(System.in);
        
        System.out.print("How many rows in your class?\n  : ");
        int rows = scan.nextInt();
        System.out.print("How many columns in your class?\n  : ");
        int cols = scan.nextInt();
        
        Classroom myClass = new Classroom(rows, cols);
        
        clearScreen();
        myClass.printClass();

        askSeat(rows, cols, myClass, scan);
        clearScreen();
        myClass.printClass();
    }

    public static void clearScreen() {
        System.out.print('\u000c');
    }
    
    public static void askSeat(int rows, int cols, Classroom myClass, Scanner scan){
        try{
            clearScreen();
            myClass.printClass();
            System.out.println("Which row do you want to sit in? \n  : ");
            int row = scan.nextInt();
            System.out.print("Which column do you want to sit in? \n  : ");
            int col = scan.nextInt();
            if(myClass.seatFilled(row, col)){
                askSeat(rows, cols, myClass, scan);
                System.out.println("Seat taken.");
            }else{
                System.out.println("What are your initials? \n  : ");
                scan.next();
                String init = scan.nextLine();
                
                myClass.setSeat(row, col, init);
            }
        }catch(Exception e){
            
            
            askSeat(rows, cols, myClass, scan);
            System.out.println("Seat out of the classroom.");
            
        }
    }
}
