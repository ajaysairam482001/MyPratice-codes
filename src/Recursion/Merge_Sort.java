package Recursion;

import java.util.Arrays;

public class Merge_Sort {
    public static void main(String[] args) {
        int[] arr = {6,5,4,1,2,6,4};
        System.out.println(Arrays.toString(sort(arr)));
        sortinplace(arr,0,arr.length);//its arr.length and not arr.length-1 for a reason debug and figure out
        System.out.println(Arrays.toString(arr));
    }
    static int[] sort(int[] arr){
        if(arr.length == 1){
            return arr;
        }
        int s = 0;
        int e = arr.length;
        int m = (s + (e - s))/2;
        int[] left = sort(Arrays.copyOfRange(arr,0,m));
        int[] right = sort(Arrays.copyOfRange(arr,m,e));
        return merge(left,right);
    }
    static int[] merge(int[] left,int[] right){
        int lptr = 0;
        int rptr = 0;
        int mixptr = 0;
        int[] mix = new int[left.length+right.length];

        while(lptr<=left.length-1 && rptr<=right.length-1){
            if(left[lptr]<right[rptr]){
                mix[mixptr] = left[lptr];
                mixptr++;
                lptr++;
            }
            else{
                mix[mixptr] = right[rptr];
                mixptr++;
                rptr++;
            }
        }
        while(lptr!=left.length){ //appending the remaining elements to the mix
            mix[mixptr] = left[lptr];
            mixptr++;
            lptr++;
        }
        while(rptr!=right.length){
            mix[mixptr] = right[rptr];
            mixptr++;
            rptr++;
        }
        return mix;
    }

    static void sortinplace(int[] arr,int s,int e){
        // please debug it and understand
        if(e-s == 1){
            return;
        }
        int m = s + (e - s)/2;

        sortinplace(arr,s,m);
        sortinplace(arr,m,e);

        mergeinplace(arr,s,m,e);
    }
    static void mergeinplace(int[] arr,int s,int m,int e){
        int lptr = s;
        int rptr = m;
        int mixptr = 0;
        int[] mix = new int[(e-s)];

        while(lptr<m && rptr<e){
            if(arr[lptr]<arr[rptr]){
                mix[mixptr] = arr[lptr];
                lptr++;
            }
            else{
                mix[mixptr] = arr[rptr];
                rptr++;
            }
            mixptr++;
        }
        while(lptr!=m){ //appending the remaining elements to the mix
            mix[mixptr] = arr[lptr];
            mixptr++;
            lptr++;
        }
        while(rptr!=e){
            mix[mixptr] = arr[rptr];
            mixptr++;
            rptr++;
        }
        for(int l = 0;l<mix.length;l++){
            arr[s+l] = mix[l];
        }
    }
}
