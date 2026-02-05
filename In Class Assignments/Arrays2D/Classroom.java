package Arrays2D;

/**
 * Write a description of class Classroom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Classroom{
    private int rows;
    private int cols;
    private String[][] layout;
    
    public Classroom(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        this.layout = new String[rows][cols]; 
        resetSeats(layout);
    }
    public Classroom(){
        this.rows = 5;
        this.cols = 5;
        this.layout = new String[rows][cols]; 
        resetSeats(layout);
    }
    
    private void resetSeats(String[][] arr2D){
        for(int i=0; i<arr2D.length; i++){
            for(int j=0; j<arr2D[i].length; j++){
                arr2D[i][j] = "-";
            }   
        }
    }
    
    public void setSeat(int row, int col, String init){
        layout[row-1][col-1] = init;
    }
    
    public boolean seatFilled(int row, int col){
        if(layout[row-1][col-1].equals("-")){
            return false;
        }else{
            return true;
        }
    }
    
    public void printClass(){
        System.out.print("    ");
        for(int k = 1; k<cols+1; k++){System.out.printf("%-3s ", k);} System.out.println();
        for(int i=0; i<layout.length; i++){
            System.out.printf(" %-3s ", (i+1));
            for(int j=0; j<layout[i].length; j++){
                System.out.printf("%-3s ", layout[i][j]);
            }   
            System.out.println();
        }
    }
}
