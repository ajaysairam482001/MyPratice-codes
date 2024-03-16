package Recursion;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {1,21,41,21,47,62,25,41,81,62,42};
        sort(arr, arr.length,0,0 );
        System.out.println(Arrays.toString(arr));
    }
    static void sort(int[] arr,int r,int c,int maxsf){
        if(r==0)
            return;
        if(c<r){
            if(arr[maxsf]<arr[c]){
                sort(arr,r,c+1,c); // or maxsf = c;
            }else{
                sort(arr,r,c+1,maxsf);
            }
        }
        else{
            int temp = arr[maxsf];
            arr[maxsf] = arr[r-1];
            arr[r-1] = temp;
            sort(arr,r-1,0,0);
        }
    }
}
