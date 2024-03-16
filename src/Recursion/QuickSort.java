package Recursion;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {36,2,54,21,57,44,25,15,32,31,-6,-1};
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    static void sort(int[] arr,int low,int high){
        if(low>=high){
            return;
        }
        int s = low;
        int e = high;
        int m = s + (e-s) / 2;
        int pivot = arr[m];
        while(s<=e){
            //until both while conditions violates and swap at the end
            while(arr[s]<pivot){
                s++;
            }
            while (arr[e]>pivot){
                e--;
            }
            // make sure when the last pass executes unnecessary swap should not happen
            //think about it
            if(s<=e){
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
        }
        //after the while loop the pivot is in it rightful place!
        //divide left and right side of pivot and send them out to recursion pass!
        sort(arr,low,e);
        sort(arr,s,high);
    }
}
