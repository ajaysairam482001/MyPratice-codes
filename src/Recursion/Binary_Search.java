package Recursion;
//Recurrence Relation : Divide and Conquer
//                     Dividing the array by a factor after comparing
public class Binary_Search {
    static int search(int[] arr,int target,int start,int end){
        if(start>end)
            return -1;
        int mid = start + (end - start)/2;
        if(arr[mid] == target)
            return mid;
        else if (arr[mid] > target) {
            return search(arr,target,start,mid-1);
        }
        else {
            return search(arr,target,mid+1,end);
        }


    }

    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,7,8};
        int target = 7;
        System.out.println(search(arr,target,0,arr.length-1));
    }
}
