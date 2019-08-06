public class TicTacToe {

    private char[][] board;
    private boolean isXTurn;

    public TicTacToe(char[][] board){
        this.board = board;
        this.isXTurn = true;
    }

    public boolean checkAMove (int row, int column){
        if (this.board[row][column] == '-')
        {return true;}
        else {return false;}
    }

    public void addAMove(int row, int column) {
        if (this.isXTurn)
            {this.board[row][column]='x';}
        else {this.board[row][column]='o';}
    }

    // this.board[2][0] = 'X';
    // X first then O second
    // there are 8 chances to detect a winner.
    //this.board[0][0]==this.board[0][1] and this.board[0][1]==this.board[0][2]
    //then there is a winner
    public boolean whoseTurn() {
        if(this.isXTurn) {this.isXTurn=false;
        }
        else {this.isXTurn = true; }
        return isXTurn;
    }

    public boolean checkForWin(){
        if (this.board[0][0]==this.board[0][1] && this.board[0][1]==this.board[0][2]&&this.board[0][2]!='-')
        {return true;}
        else if (this.board[1][0]==this.board[1][1] && this.board[1][1]==this.board[1][2]&&this.board[1][2]!='-')
        {return true;}
        else if (this.board[2][0]==this.board[2][1] && this.board[2][1]==this.board[2][2]&&this.board[2][2]!='-')
        {return true;}
        else if (this.board[0][0]==this.board[1][0] && this.board[1][0]==this.board[2][0]&&this.board[2][0]!='-')
        {return true;}
        else if (this.board[0][1]==this.board[1][1] && this.board[1][1]==this.board[2][1]&&this.board[2][1]!='-')
        {return true;}
        else if (this.board[0][2]==this.board[1][2] && this.board[1][2]==this.board[2][2]&&this.board[2][2]!='-')
        {return true;}
        else if (this.board[0][0]==this.board[1][1] && this.board[1][1]==this.board[2][2]&&this.board[2][2]!='-')
        {return true;}
        else if (this.board[0][2]==this.board[1][1] && this.board[1][1]==this.board[2][0]&&this.board[2][0]!='-')
        {return true;}
        else {
            return false;
        }
    }

    public boolean isBoardFull() {
        boolean isFull = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-')
                    isFull = false;
            }
        }
        return isFull;
    }

    /*
    Z|Z|Z
    -+-+-
    Z|Z|Z
    -+-+-
    Z| |
     */
    public void displayBoard() {
        char[] firstRow = this.board[0];
        for (int i = 0; i < firstRow.length -1; i++) {
            // print number
            System.out.print(firstRow[i]+"|");
            // print bar
        }
        System.out.println(this.board[0][2]);
        System.out.println("-+-+-");
        char[] secondRow = this.board[1];
        for (int i = 0; i < secondRow.length -1; i++) {
            // print number
            System.out.print(secondRow[i]+"|");
            // print bar
        }
        System.out.println(this.board[1][2]);
        System.out.println("-+-+-");
        char[] thirdRow = this.board[2];
        for (int i = 0; i < thirdRow.length -1; i++) {
            // print number
            System.out.print(thirdRow[i]+"|");
            // print bar
        }
        System.out.println(this.board[2][2]);
    }
    }
