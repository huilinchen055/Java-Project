import java.util.Arrays;

public class Sudoku {


    public static void printBoard(int[][]board){
        for (int row = 0; row < board.length; row++)
        {
            System.out.println("");
            System.out.println("---------------------------------");

            for (int column = 0; column < board.length; column++)
            {
                System.out.print("| " + board[row][column]);
            }
            System.out.print("|");
        }
        System.out.println("");
        System.out.println("---------------------------------");}

    public static boolean valid(int[][]board, int row, int col,int num){
        for (int j = 0; j < board.length; j++) {
            if (board[row][j]==num){
                return false;
            }
        }

        for (int i = 0; i < board.length; i++) {
            if (board[i][col]==num){
                return false;
            }
        }
        int CornerRow =row-row%3;
        int CornerCol =col-col%3;
        for (int ii = CornerRow; ii < CornerRow+3; ii++) {
            for (int jj = CornerCol; jj < CornerCol+3; jj++) {
                    if(board[ii][jj]==num){
                    return false;
            }
        }}
        return true;
    }

    private static boolean solve(int[][] board, int row, int col){
        if (col >=board.length){
            row++;
            col =0;
            if(row>=board.length){
                return true;
            }
        }
        if(board[row][col]!=0) {
            return solve(board, row, col + 1);
        }

        for (int num = 1; num <=board.length; num++) {
            if (valid(board, row,col,num)) {
                board[row][col] = num;
                if (solve(board, row, col+1)) {
                    return true;
                }else{board[row][col] = 0;}
            }
        }
        return false;
    }



    public static void main(String[] args) {
        int[][] table=
                {{3, 0, 6, 5, 0, 8, 4, 0, 0},
        {5, 2, 0, 0, 0, 0, 0, 0, 0},
        {0, 8, 7, 0, 0, 0, 0, 3, 1},
        {0, 0, 3, 0, 1, 0, 0, 8, 0},
        {9, 0, 0, 8, 6, 3, 0, 0, 5},
        {0, 5, 0, 0, 9, 0, 6, 0, 0},
        {1, 3, 0, 0, 0, 0, 2, 5, 0},
        {0, 0, 0, 0, 0, 0, 0, 7, 4},
        {0, 0, 5, 2, 0, 6, 3, 0, 0}};
        System.out.println(solve(table,0,0));
        //System.out.println(Arrays.deepToString(table).replaceAll("],", "]," + System.getProperty("line.separator")));
   printBoard(table);
    }
}
