package Search_sort;

import java.util.Arrays;
//the concept that iterating through the arr and finding the max element(arr) and placing the element @ the last index
//and decreasing the array space and finding the second max element and placing at lastIndex-1 index and iterating further
// you will end up with sorted array
public class Selection_Sort {
    void sort(int[] arr){
        for(int i=0;i<arr.length;i++){
            int lastIndex = arr.length-1-i;
            int index = maxSort(arr,lastIndex);
            swap(arr,index,lastIndex);
        }
    }
    static int maxSort(int[] arr,int lastIndex){ // to find the max element within the bounds of the given array
        int max = Integer.MIN_VALUE;
        int index = 0;
        for(int i=0;i<=lastIndex;i++){
            if(max<arr[i]) {
                max = arr[i];
                index = i;
            }
        }
        return index;
    }

    static void swap(int[] arr,int index,int lastIndex){
        int temp = arr[lastIndex];
        arr[lastIndex] = arr[index];
        arr[index] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        Selection_Sort obj = new Selection_Sort();
        obj.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
