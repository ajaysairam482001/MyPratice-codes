package Leetcode;

import java.util.Arrays;

//Qn:832
//https://leetcode.com/problems/flipping-an-image/submissions/1103684402/
//refer kunal -> https://www.youtube.com/watch?v=fzip9Aml6og&t=2374s TimeSkip:2.10.12 (Question17)
public class FlipandInvertImage {
    public static void main(String[] args) {
        int[][] image = {{1,1,0},{1,0,1},{0,0,0}};
        System.out.println(Arrays.toString(flipAndInvertImage(image)));
    }
    public static int[][] flipAndInvertImage(int[][] image) {
        for(int[] row : image){
            for(int i = 0;i<(row.length+1)/2;i++){
                int temp = row[i]^1;
                row[i] = (row[row.length-1-i])^1;
                row[row.length-1-i] = temp;
            }
        }
        return image;
    }
}
