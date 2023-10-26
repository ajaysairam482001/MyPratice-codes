package Search_sort;

import java.util.Arrays;

public class Array2D_Search {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3,4},
                {5,6,4},
                {10,5,47,6,8,65},
                {1,2,5,78}
        };
        int target = 65;
        Array2D_Search obj = new Array2D_Search();
        System.out.println("Found At"+Arrays.toString(obj.search(arr,target)));
        System.out.println("The Maximum Element: "+obj.maxElement(arr)+" At index "+Arrays.toString(obj.search(arr, obj.maxElement(arr))));
        System.out.println("The Minimum Element: "+obj.minElement(arr)+" At index "+Arrays.toString(obj.search(arr, obj.minElement(arr))));
    }

    int[] search(int arr[][],int target){ // to return the row and col the element is present
        if(arr.length == 0)
                return new int[]{-1};
        for(int row = 0;row<arr.length;row++){
            for(int col = 0;col<arr[row].length;col++){ //note the condition on how to iterate
                if(arr[row][col]==target)
                    return new int[]{++row,++col}; // to makeit easy for us to spot the element in the array
            }
        }
        return new int[]{-1};
    }

    int maxElement(int arr[][]){ // to find the Maximum Element
        if(arr.length == 0)
            return -1;
        int max = Integer.MIN_VALUE;
        for(int[] row : arr){
            for(int ele : row){
                if(ele>max)
                    max = ele;
            }
        }
        return max;
    }

    int minElement(int arr[][]){ // to find the Minimum Element
        if(arr.length == 0)
            return -1;
        int min = Integer.MAX_VALUE;
        for(int[] row : arr){
            for(int ele : row){
                if(ele<min)
                    min = ele;
            }
        }
        return min;
    }
}
