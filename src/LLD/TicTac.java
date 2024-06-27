package LLD;
//https://www.youtube.com/watch?v=jlLNXmi4Nmw&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=48
import java.util.Scanner;

public class TicTac {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for(int i = 0;i< board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                board[i][j] = ' ';
            }
        }
        Scanner in = new Scanner(System.in);
        int row,col;
        char player = 'X';
        while(true){
            displayBoard(board);
            System.out.println("Enter the "+player+" index: ");
            row = in.nextInt();
            col = in.nextInt();
            if(row >= board.length || col>= board[0].length){
                System.out.println("Invalid index, Please enter a valid index");
                continue;
            }
            board[row][col] = player;

            if(gameCheck(board,player)){
                displayBoard(board);
                System.out.println("The player "+player+" has WON! ");
                break;
            }else {
//                if(player == 'X'){
//                    player = 'O';
//                }
//                else {
//                    player = 'X';
//                }
                player = (player == 'X')?'O':'X'; //(alternate)
            }

        }
    }
    public static boolean gameCheck(char[][] board, char player){
        //check the rows
        for(int i = 0;i< board.length;i++){
            if(board[i][1]==player && board[i][2]==player && board[i][3]==player){
                return true;
            }
        }
        //check the columns
        for(int j = 0;j< board[0].length;j++){
            if(board[1][j]==player && board[2][j]==player && board[3][j]==player){
                return true;
            }
        }
        //check the diagonals
        if(board[1][1]==player && board[2][2]==player && board[0][0]==player){
            return true;
        }
        if(board[0][2]==player && board[1][1]==player && board[2][0]==player){
            return true;
        }
        return false;
    }

    public static void displayBoard(char[][] board){
        for(int i = 0;i< board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(j==2){
                    System.out.println(board[i][j]);
                }
                else{
                    System.out.print(board[i][j]+" | ");
                }
            }
        }
    }
}
