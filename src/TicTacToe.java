import java.util.Scanner;
public class TicTacToe
{
    private static final int ROW=3;
    private static final int COL=3;
    private static String board[][]= new String[ROW][COL];

    public static void main(String[] args)
    {
        Scanner in= new Scanner(System.in);
        int game=0;
        int row;
        int col;
        String P_1="Player 1";
        String P_2="Player 2";
        String Player_1=" X ";
        String Player_2=" O ";
        String currentPlayer=Player_1;
        String stringCurrentPlayer;
        int noOfPlays;

        System.out.println("Welcome to this TicTacToe game!!\nYou need 2 players for this game.\nHave a friend play along with you! :)");
        do
        {
            game++;
            noOfPlays=0;
            clearBoard();
            display();
            for(int i=0; i<9; i++)
            {
                if (i%2==0)
                {
                    currentPlayer=Player_1;
                    stringCurrentPlayer=P_1;
                }
                else
                {
                    currentPlayer=Player_2;
                    stringCurrentPlayer=P_2;
                }
                System.out.printf("It's your turn!", stringCurrentPlayer);
                do
                {
                    row = SafeInput.getRangedInt(in, "Enter your row coordinate (Vertical)", 1, 3)-1;
                    col = SafeInput.getRangedInt(in, "Enter your column coordinate (Horizontal)", 1, 3)-1;
                    if (!isValidMove(row,col)){System.out.println("This place is already taken!");}

                }
                while(!isValidMove(row,col));
                noOfPlays+=1;
                board[row][col]=currentPlayer;
                display();

                if (noOfPlays>=5)
                {
                    if (isWin(currentPlayer))
                    {
                        System.out.printf(currentPlayer+" wins the game! Congrats!");
                        break;
                    }
                    else if (noOfPlays>=7)
                    {
                        if (isTie())
                        {
                            System.out.println("TIE GAME!");
                            break;
                        }
                    }
                }

            }
            if (Player_1.equals(" X "))
            {
                Player_1=" O ";
                Player_2=" X ";
            }
            else
            {
                Player_1=" X ";
                Player_2=" O ";
            }


        }
        while (SafeInput.getYNConfirm(in, " Type 'y' if you want to play again or 'n' in order to end the game"));
        System.out.printf("You played "+ noOfPlays+ "no of games.");
    }



    private static void clearBoard()
    {
        for (int row = 0; row < ROW; row++)
        {
            for (int col = 0; col < COL; col++)
            {
                board[row][col] = "   ";
            }
        }
    }

    private static void display()
    {
        String displayBoard = "";
        for (int row = 0; row < ROW; row++)
        {
            for (int col = 0; col < COL; col++)
            {
                if (col == COL - 1)
                {
                    displayBoard += board[row][col];
                } else {
                    displayBoard += board[row][col] + "|";
                }
            }
            if (row != ROW - 1) {
                displayBoard += "\n---+---+---\n";
            }
        }
        System.out.println(displayBoard);
    }

    private static boolean isValidMove(int row, int col)
    {
        return (board[row][col].equals("   "));
    }

    private static boolean isColumnWin(String player)
    {
        for (int col = 0; col < COL; col++)
        {
            if (board[0][col].equals(player) && board[1][col].equals(player) && board[2][col].equals(player))
            {
                return true;
            }
        }
        return false;
    }

    private static boolean isRowWin(String player)
    {
        for (int row = 0; row < ROW; row++)
        {
            if (board[row][0].equals(player) && board[row][1].equals(player) && board[row][2].equals(player))
            {
                return true;
            }
        }
        return false;
    }

    private static boolean isDiagonalWin(String player)
    {
        if ((board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) ||
                (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player)))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private static boolean isWin(String player)
    {
        if (isColumnWin(player) || isRowWin(player) || isDiagonalWin(player))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private static boolean isTie()
    {
        int count = 0;
        if (isRowTie())
        {
            count++;
        }
        if (isColumnTie())
        {
            count++;
        }
        if (isDiagonalTieDown())
        {
            count++;
        }
        if (isDiagonalTieUp())
        {
            count++;
        }

        if (count >= 3) {
            return true;
        }
        return false;
    }

    private static boolean isRowTie()
    {
        int count_X = 0;
        int count_O = 0;
        int numDeadWinVectors = 0;
        for (int i = 0; i < ROW; i++)
        {
            count_X = 0;
            count_O = 0;
            for (int c = 0; c < COL; c++)
            {
                if (board[i][c].equals(" X "))
                {
                    count_X++;
                } else if (board[i][c].equals(" O "))
                {
                    count_O++;
                }
                if (count_X >= 1 && count_O >= 1)
                {
                    numDeadWinVectors++;
                }
            }
        }
        if (numDeadWinVectors >= 3)
        {
            return true;
        } else
        {
            return false;
        }
    }

    private static boolean isColumnTie()
    {
        int count_X = 0;
        int count_O = 0;
        int numDeadWinVectors = 0;
        for (int i = 0; i < ROW; i++)
        {
            count_X = 0;
            count_O = 0;
            for (int q = 0; q < COL; q++)
            {
                if (board[q][i].equals(" X "))
                {
                    count_X++;
                } else if (board[q][i].equals(" O "))
                {
                    count_O++;
                }
                if (count_X >= 1 && count_O >= 1)
                {
                    numDeadWinVectors++;
                }
            }
        }
        if (numDeadWinVectors >= 3)
        {
            return true;
        } else
        {
            return false;
        }
    }
    private static boolean isDiagonalTieUp() {
        int count_X = 0;
        int count_O = 0;
        if (board[0][2].equals(" X ")) {
            count_X++;
        } else if (board[0][2].equals(" O ")) {
            count_O++;
        }
        if (board[1][1].equals(" X ")) {
            count_X++;
        } else if (board[1][1].equals(" O ")) {
            count_O++;
        }
        if (board[2][0].equals(" X ")) {
            count_X++;
        } else if (board[2][0].equals(" O ")) {
            count_O++;
        }
        if (count_X >= 1 && count_O >= 1) {
            return true;
        } else {
            return false;
        }
    }
    private static boolean isDiagonalTieDown()
    {
        int count_X = 0;
        int count_O = 0;
        for (int w = 0; w < ROW; w++)
        {
            if (board[w][w].equals(" X "))
            {
                count_X++;
            } else if (board[w][w].equals(" O "))
            {
                count_O++;
            }
        }
        if (count_X >= 1 && count_O >= 1)
        {
            return true;
        } else
        {
            return false;
        }
    }
}