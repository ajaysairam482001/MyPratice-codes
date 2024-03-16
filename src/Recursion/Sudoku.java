package Recursion;
//kunal version
//https://www.youtube.com/watch?v=nC1rbW2YSz0&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=37 Time(1.06.51)
public class Sudoku {
    public static void main(String[] args) {
        int[][] board = new int[][]{{5,3,0,0,7,0,0,0,0},
                                    {6,0,0,1,9,5,0,0,0},
                                    {0,9,8,0,0,0,0,6,0},
                                    {8,0,0,0,6,0,0,0,3},
                                    {4,0,0,8,0,3,0,0,1},
                                    {7,0,0,0,2,0,0,0,6},
                                    {0,6,0,0,0,0,2,8,0},
                                    {0,0,0,4,1,9,0,0,5},
                                    {0,0,0,0,8,0,0,7,9}};
        if(solve(board)){
            display(board);
        }else {
            System.out.println("cannot be solved");
        }
    }

    static boolean solve(int[][] board) {
        int n = board.length;
        int row = -1;
        int col = -1;

        boolean notEmpty = true; //consider there are no empty places

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
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
        for (int number = 1; number <= 9; number++) {
            if (isSafe(board, row, col, number)) {
                board[row][col] = number;
                if (solve(board)) {
                    //found the answer
                    return true;
                } else {//backtrack
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    static boolean isSafe(int[][] board, int row, int col, int num) {
        //check the row
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        //check the col
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }

        //check its 3X3 box
        int sqrt = (int) Math.sqrt(board.length);
        int rowStart = row - (row % sqrt); //to find the start position of the box
        int colStart = col - (col % sqrt);  //        ''
        for (int r = rowStart; r < rowStart + sqrt; r++) {
            for (int c = colStart; c < colStart + sqrt; c++) {
                if (board[r][c] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void display(int[][] board) {
        for (int[] row : board) {
            for (int number : row) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }
}
//int[][] board = new int[][]{{"5","3",".",".","7",".",".",".","."},
//                                    {"6",".",".","1","9","5",".",".","."},
//                                    {".","9","8",".",".",".",".","6","."},
//                                    {"8",".",".",".","6",".",".",".","3"},
//                                    {"4",".",".","8",".","3",".",".","1"},
//                                    {"7",".",".",".","2",".",".",".","6"},
//                                    {".","6",".",".",".",".","2","8","."},
//                                    {".",".",".","4","1","9",".",".","5"},
//                                    {".",".",".",".","8",".",".","7","9"}};
