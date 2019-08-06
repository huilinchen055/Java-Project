import java.util.*;

public class TicTacToeTester {
    //ask player 1 to make a move
    //ask player 2 to make a move
    //use scanner
    //it will automatically restart the game

    public static char[][] initialBroad() {
        char[][] board= {{'-','-','-'},{'-','-','-'},{'-','-','-'}};
        return board;
    }

    public static void newGame() {
        Scanner scanner = new Scanner(System.in);
        TicTacToe object = new TicTacToe(initialBroad());
        object.displayBoard();
        System.out.println("Player one, please make a move. Which row?");
        int firstRow = scanner.nextInt();
        while (firstRow <0||firstRow>2){firstRow=scanner.nextInt();}
        System.out.println("Which column?");
        int firstColumn = scanner.nextInt();
        while (firstColumn <0||firstColumn>2){firstColumn=scanner.nextInt();}
        while (object.checkAMove(firstRow, firstColumn)!= true)
        {
            System.out.println("That spot is already taken");
            System.out.println("Player one, please make a move. Which row?");
            firstRow = scanner.nextInt();
            while (firstRow <0||firstRow>2){firstRow=scanner.nextInt();}
            System.out.println("Which column?");
            firstColumn = scanner.nextInt();
            while (firstColumn <0||firstColumn>2){firstColumn=scanner.nextInt();}}
        object.addAMove(firstRow,firstColumn);
        object.displayBoard();

        while (object.isBoardFull() !=true){

        if (object.whoseTurn())
        {System.out.println("Player one, please make a move. Which row?");
            int x = scanner.nextInt();
            while (x <0||x>2){x=scanner.nextInt();}
            System.out.println("Which column?");
            int y = scanner.nextInt();
            while (y <0||y>2){y=scanner.nextInt();}
            while (object.checkAMove(x, y)!= true)
            {
                System.out.println("That spot is already taken");
                System.out.println("Player one, please make a move. Which row?");
                x = scanner.nextInt();
                while (x <0||x>2){x=scanner.nextInt();}
                System.out.println("Which column?");
                y = scanner.nextInt();
                while (y <0||y>2){y=scanner.nextInt();}}
            object.addAMove(x,y);
            object.displayBoard();
        if (object.checkForWin())
        { break;
        }
        }

        else {
            System.out.println("Player two, please make a move. Which row?");
            int x = scanner.nextInt();
            while (x <0||x>2){x=scanner.nextInt();}
            System.out.println("Which column?");
            int y = scanner.nextInt();
            while (y <0||y>2){y=scanner.nextInt();}
            while (object.checkAMove(x, y)!= true)
            {
                System.out.println("That spot is already taken");
                System.out.println("Player two, please make a move. Which row?");
                x = scanner.nextInt();
                while (x <0||x>2){x=scanner.nextInt();}
                System.out.println("Which column?");
                y = scanner.nextInt();
                while (y <0||y>2){y=scanner.nextInt();}}
            object.addAMove(x,y);
            object.displayBoard();}
            if (object.checkForWin())
            { break; }
        }
        if (object.checkForWin())

        { if (!object.whoseTurn())
        {
            System.out.println("Player one win!!");
        }
        else
        { System.out.println("Player two win!!");
    }}}


    public static void main(String[] args) {
        newGame();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to restart the new game? Yes or No");
        String input =" ";
        while (!input.equals("No") && !input.equals("Yes"))
        {input=scanner.nextLine();}
        while (input.equals("Yes"))
        { System.out.println("Restart new game");
        newGame();
        System.out.println("Do you want to restart the new game? Yes or No");
        input =" ";
        while (!input.equals("No") && !input.equals("Yes"))
        {input=scanner.nextLine();}}
    }}



