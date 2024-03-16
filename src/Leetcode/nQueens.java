package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/n-queens/description/
//Qn (51) hard
//few testcases failed checm with other videos in youtube
public class nQueens {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        System.out.println(Arrays.asList(queens(board,0)));
    }
    static List<List<String>> queens(boolean[][] board,int row){
        if(row == board.length){
            List<List<String>> olist = new ArrayList<>();
            olist.add(display(board));
            return olist;
        }
        List<List<String>> olist = new ArrayList<>();
        for(int col = 0;col<board[0].length;col++){
            if(isSafe(board,row,col)){
                board[row][col] = true;
                olist.addAll(queens(board,row+1));
                board[row][col] = false;
            }
        }
        return olist;
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

    private static List<String> display(boolean[][] board) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j< board[i].length;j++){
                if(board[i][j]){
                    sb.append('Q');
                }
                else {
                    sb.append('.');
                }
            }
            list.add(sb.toString());
            sb.setLength(0);
        }
        return list;
    }
}
