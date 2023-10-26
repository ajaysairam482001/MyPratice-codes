package Leetcode;
//https://leetcode.com/problems/word-search/  Q.79
//referred solution => https://leetcode.com/problems/word-search/solutions/27811/my-java-solution/
//referred solution video => https://youtu.be/m9TrOL1ETxI?si=TofTqnYKqlEJC7B
public class Word_Search {
    boolean[][] visited;
    public boolean exist(char[][] board, String word){
        int row = board.length;
        int col = board[0].length;
        visited = new boolean[row][col];
        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++){
                if(word.charAt(0)==board[i][j] && search(board,word,0,i,j))
                    return true;
            }
        return false;
    }
    public boolean search(char[][] board,String word,int index,int i,int j){
        if(index == word.length()){ //if it reached the last element to end it (base method)
            return true;
        }
        if(i>= board.length || i < 0 || j < 0 || j >= board[i].length || visited[i][j] || word.charAt(index) != board[i][j]){
            return false; // checking arrays out of bounds and if the char element is equals to ele inthe board
        }
        visited[i][j] = true; //making it visited to follow on
        if(search(board,word,index+1,i-1,j)||
                search(board,word,index+1,i+1,j)||
                search(board,word,index+1,i,j-1)||
                search(board,word,index+1,i,j+1)){
                    return true; // if the surrounding adjcent elements matches it go on it base method or fails
                }
        visited[i][j] = false; // if it comes to this line then the search failed so erasing the traces thats why marking the visited element false to avoid future confusions
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String s = "ABCCED";
        Word_Search obj = new Word_Search();
        System.out.println(obj.exist(board,s));
    }
}
