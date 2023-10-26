package Search_sort;

import java.util.Arrays;

public class Bubble_Sort {
    void sort(int[] arr){
        boolean swapped; // to check if the elements are swapped or not
        for(int i = 0;i<arr.length;i++){
            swapped = false;
            for(int j=1;j<arr.length-i;j++){
                if(arr[j]<arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    swapped = true;
                }
            }
            if(!swapped) // if swapping doesn't occur in one iteration it means the array is sorted no need to waste time and break the loop
                break;
        }
    }

    public static void main(String[] args) {
//        int[] arr = {1,2,3,4,5}; // in an already sorted array the loop j runs once and no elements will be swapped so the loop breaks
        int[] arr = {2,1,3,5,4};
        Bubble_Sort obj = new Bubble_Sort();
        obj.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
