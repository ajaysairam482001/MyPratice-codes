package Leetcode;

import java.util.Objects;

// word search
public class Pratice1 {
    static boolean[][] visited;

    static boolean search(String[][] arr,int index,int r,int c,String str){

        if(index == str.length())
            return true;

        if(r<0 || r>= arr.length || c<0 || c>=arr[r].length || !Objects.equals(arr[r][c], Character.toString(str.charAt(index)))){
            return false;
        }
        visited[r][c] = true;
        if(search(arr,index++,r+1,c,str)||
                search(arr,index++,r-1,c,str)||
                search(arr,index++,r,c+1,str)||
                search(arr,index++,r,c-1,str)){
            return true;
        }
        else{
            visited[r][c] = false;
            return false;
        }
    }

    public static void main(String[] args) {
        String[][] arr = {{"A","B","C","E"},{"S","F","C","S"},{"A","D","E","E"}};
        String word = "ABCCED";
        for(int i = 0;i< arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(Objects.equals(arr[i][j], Character.toString(word.charAt(0)))){
                    System.out.println(search(arr,1,i,j,word));
                }
            }
        }
        System.out.println("done");
    }
}
