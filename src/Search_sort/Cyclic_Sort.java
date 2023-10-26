package Search_sort;

import java.util.Arrays;

public class Cyclic_Sort {
    //the concept is to use this sort only when elements range from (1toN) only
    //with the elements value matching its indexes ,so we iterate and swap until the swapped value is equal to its index
    // and move on
    public void sort(int[] arr){
        int i=0;
        while(i < arr.length){
            if(arr[i]!=arr[arr[i]-1]){
                swap(arr,i,arr[i]-1);
            }else
                i++;
        }
    }
    static void swap(int[] arr,int index,int lastIndex){
        int temp = arr[lastIndex];
        arr[lastIndex] = arr[index];
        arr[index] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {5,3,1,2,5};
        Cyclic_Sort obj = new Cyclic_Sort();
        obj.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
