package Search_sort;

import java.util.Arrays;

public class Insertion_Sort {
    public void sort(int[] arr){
        for(int i=0;i < arr.length-1;i++){
            for(int j = i+1;j>0;j--){
                if(arr[j]<arr[j-1]){
                    swap(arr,j,j-1);
                }else {
                    break;
                }
            }
        }
    }

    static void swap(int[] arr,int index,int lastIndex){
        int temp = arr[lastIndex];
        arr[lastIndex] = arr[index];
        arr[index] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        Insertion_Sort obj = new Insertion_Sort();
        obj.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
