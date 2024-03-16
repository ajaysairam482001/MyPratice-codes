package Recursion;

import javax.swing.*;

//same as nQueens problem but its with a knight
//not a leetcode problem just solving //antha 'L' shape pora chess piece tha knight,not minister
public class nKnight {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        knight_I(board,0,0,4);
    }
    static void knight_I(boolean[][] board,int row,int col,int target) {
        if (target == 0) {
            //one variant is found
            display(board);
            System.out.println();
            return;
        }
        if(row == board.length-1 && col == board.length){
            //when you reached the final position
            return;
        }
        if(col == board.length){
            //when the pointer go out of the columns(end) but there is another row
            knight_I(board,row+1,0,target);
            return;
        }
        if (isSafe(board, row, col)) {//backtracking
            board[row][col] = true; //safe to place there
            knight_I(board, row, col + 1, target - 1);//checking other possiblities
            board[row][col] = false; // backtrack
        }

        knight_I(board, row, col + 1, target); //if nothing is found, move on
        return;

    }
    static boolean isSafe(boolean[][] board,int row,int col){
        //first check the postions it can go (upper half of the board from its position)
        //and then checking if there is already a knight present
        if(isValid(board,row-2,col-1)){
            if(board[row-2][col-1]){
                return false;
            }
        }
        if(isValid(board,row-1,col-2)){
            if(board[row-1][col-2]){
                return false;
            }
        }
        if(isValid(board,row-2,col+1)){
            if(board[row-2][col+1]){
                return false;
            }
        }
        if(isValid(board,row-1,col+2)){
            if(board[row-1][col+2]){
                return false;
            }
        }
        return true;
    }

    static boolean isValid(boolean[][]board,int row, int col){
        //if the position is within bounds inside the board and not outside
        if (row < board.length && row>=0 && col < board[0].length && col>=0){
            return true;
        }
        return false;
    }

    private static void display(boolean[][] board) {
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j< board[i].length;j++){
                if(board[i][j]){
                    System.out.print("K ");
                }
                else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
