package Leetcode;
//test cases failing please check
//https://leetcode.com/problems/n-queens-ii/description/ (Qn:52)
public class nQueens_II {
    public static void main(String[] args) {
        int n = 5;
        boolean[][] board = new boolean[n][n];
        System.out.println(queens(board,0));
    }
    static int queens(boolean[][] board,int row){
        if(row == board.length){
            //display(board);
            return 1;
        }
        int count = 0;
        for(int col = 0;col<board.length;col++){
            if(isSafe(board,row,col)){
                board[row][col] = true;
                count += queens(board,row+1);
                board[row][col] = false;
            }
        }
        return count;
    }

    static boolean isSafe(boolean[][] board,int row,int col){
        //please focus on this method (isSafe) more // mistakes prone to happen

        //for vertical
        for(int i = 0;i<row;i++){
            if(board[i][col])
                return false;
        }
        //for diagonal left (northwest)
        int maxLeft = Math.min(row,col);
        for(int i = 1;i<=maxLeft;i++) {
            if (board[row - i][col - i]) {
                return false;
            }
        }
        //for diagonal right (northeast)
        int maxRight = Math.min(row,board.length-col-1); //confuse check video exactly @(15.04) for explaination
        for(int i = 1;i<=maxRight;i++){
            if(board[row-i][col+i]) {
                return false;
            }
        }
        return true;
    }

    private static void display(boolean[][] board) {
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j< board[i].length;j++){
                if(board[i][j]){
                    System.out.print("Q ");
                }
                else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
