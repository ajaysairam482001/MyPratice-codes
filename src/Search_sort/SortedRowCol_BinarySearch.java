package Search_sort;

import java.util.Arrays;

//consider the 2D Array when both rows and columns are sorted accordingly
// we can use it to our advantage
public class SortedRowCol_BinarySearch {

    public static void main(String[] args) {
        int[][] a = {
                {10,20,30,40},
                {15,25,35,45},
                {28,29,37,49},
                {33,34,38,50},
        };

        System.out.println(Arrays.toString(search(a,33)));
    }
//    https://www.youtube.com/watch?v=enI_KyGLYPo At->(17.33)min
//    refer the above link (code for Q1)to get an idea of what's happening
    static int[] search(int[][] arr,int target){
        int r = 0;
        int c = arr.length-1;
        while(r < arr.length && c >=0){
            if(target == arr[r][c]){
                return new int[] {r,c};
            }
            else if(target<arr[r][c]){
                c--;
            }
            else
                r++;
        }
        return new int[] {-1};
    }
}
//complexity(time) N = O(2n);
