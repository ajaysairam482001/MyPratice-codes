package Leetcode;
//https://leetcode.com/problems/sudoku-solver/submissions/1204301208/
import java.util.Objects;
//kunal version
//https://www.youtube.com/watch?v=nC1rbW2YSz0&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=37 Time(1.06.51)
//find a more optimized solution this takes 17ms time complexity: O(9^n^2)
public class Sudoku_Solver {
    public static void main(String[] args) {
        char[][] board = new char[][]   {{'5','3','.','.','7','.','.','.','.'},
                                        {'.','.','.','1','9','5','.','.','.'},
                                        {'.','9','8','.','.','.','.','6','.'},
                                        {'8','.','.','.','6','.','.','.','3'},
                                        {'4','.','.','8','.','3','.','.','1'},
                                        {'7','.','.','.','2','.','.','.','6'},
                                        {'.','6','.','.','.','.','2','8','.'},
                                        {'.','.','.','4','1','9','.','.','5'},
                                        {'.','.','.','.','8','.','.','7','9'}
        };
        if(solve(board)){
            display(board);
        }else {
            System.out.println("cannot be solved");
        }
    }

    static boolean solve(char[][] board) {
        int n = board.length;
        int row = -1;
        int col = -1;

        boolean notEmpty = true; //consider there are no empty places

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    row = i;
                    col = j;
                    notEmpty = false;
                    break;
                }
            }
            //if you found an empty element note the position and break out of the loop
            if (notEmpty == false)
                break;
        }
        if (notEmpty) { //if(notEmpty==true)
            //display(board);
            return true;
            //sudoko is solved
        }

        //so far the condition & checking are over now jumping in the backtracking part
        for (Integer number = 1; number <= 9; number++) {
            if (isSafe(board, row, col, number)) {
                board[row][col] = (char)(number+'0');
                if (solve(board)) {
                    //found the answer
                    return true;
                } else {//backtrack
                    board[row][col] = '.';
                }
            }
        }
        return false;
    }

    static boolean isSafe(char[][] board, int row, int col, int num) {
        //to check if i can place the ele at that place
        //check the row
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == (char)(num+'0')) {
                return false;
            }
        }

        //check the col
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == (char)(num+'0')) {
                return false;
            }
        }

        //check its 3X3 box
        int sqrt = (int) Math.sqrt(board.length);
        int rowStart = row - (row % sqrt); //to find the start position of the box
        int colStart = col - (col % sqrt);  //        ''
        for (int r = rowStart; r < rowStart + sqrt; r++) {
            for (int c = colStart; c < colStart + sqrt; c++) {
                if (board[r][c] == (char)(num+'0')) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void display(char[][] board) {
        for (char[] row : board) {
            for (char number : row) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }
}
