import java.util.Arrays;

public class Chess {
    public static void printBoard(int[][] board){
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

    public static boolean valid (int[][]board, int pos, int row){
        for (int i = 0; i < pos; i++) {
            if( board[row][i] == 1){
                return false;
            }
        }
        int i =1;
        while (row-i>=0 && pos-i >=0){
            if (board[row-i][pos-i] == 1){
                return false;
            }
            i++;
        }
        int j=1;
        while (row + j<8 && pos-j >=0){
            if(board[row+j][pos-j]==1){
                return false;
            }
            j++;
        }
        return true;
    }

    public static boolean solve(int[][] board, int pos){
        if(pos>=8){
            return true;
        }
        for (int i = 0; i < 8; i++) {
            if (valid(board, pos,i)){
                board[i][pos]=1;
                if(solve(board, pos+1)){
                    return true;
                }
                board[i][pos]=0;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[][] table= new int[8][8];
        System.out.println(solve(table, 0));
        //System.out.println(Arrays.deepToString(table).replaceAll("],", "]," + System.getProperty("line.separator")));
    printBoard(table);
    }
}
