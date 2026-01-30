/**
 * Demo of 2D Arrays
 *          Array of arrays
 * @dlynch1
 * @February 
 */
public class twoDArrayDemo
{
    public static void main()
    {
        String[][] letters = new String[3][2];  //3 rows 2 cols
        //  System.out.println(letters);  // [[Ljava.lang.String;@e961ea

        char[][] TTT = new char[3][3];  // 3 rows 3 Cols
        /*
         * 
        Data Type           Default Value (for fields)
        byte                        0
        short                       0
        int                         0
        long                        0L
        float                       0.0f
        double                      0.0d
        char                        '\u0000'
        String(or any object)       null
        boolean                     false

        - arrayName.length = number of rows in a 2D array
        - the number of columns may vary row to row, so when calling the length of a column,
        we pinpoint the row before using .length 
        (i.e. arrayName[0].length  = # columns in first row)
         */

        int[][] matrix1 = new int[5][8];  // 5rows by 8cols
        int[][] matrix2 = { {1,2,3},
                {4,5,6},
                {7,8,9} };

        int[][] temp = matrix1; // note temp is a reference of matrix1 
        ///NOT A COPY!!
        print2DArr(matrix1);
        print2DArr(matrix2);
        temp[1][2] = 99;
        print2DArr(temp);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // fill string array
        //letters 3rows 2cols
        
        
        // filling an 2D array

    }
    
    public static int getMax2D(int[][] arr2D){
        int max = -999;
        for(int i=0; i<arr2D.length; i++){
            for(int j=0; j<arr2D[i].length; j++){
                if(arr2D[i][j] > max){max = arr2D[i][j];}
            }   
        }
        return max;
    }
    
    // method that prints a 2D array in Rows and Cols (ints and strings)
    public static void print2DArr(int[][] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                System.out.printf("%-2s ", arr[i][j]);
            }   
            System.out.println();
        }
    }
}