package Leetcode;
//https://leetcode.com/problems/peak-index-in-a-mountain-array/
//Qn : 852
// retaled questions 165,1095.
public class PeakIndexInMoutainArray {
    public static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length-1;
        while(start!=end){ //looop breaks when start and end land on the max number in the array and we can return any start or end
            int mid = start + (end - start)/2;
            if(arr[mid] > arr[mid+1]) // dec part  so not increasing end = mid-1 because wdontk the previous mid-1 part if greater or lesser!
                end = mid;
            else if(arr[mid] < arr[mid+1]) //inc part so setting start to mid coz wk that mid is less that mid+1;
                start = mid + 1;
        }
        return start; //return the index
    }

    public static void main(String[] args) {
        // constrain : size should be mre than 2 (atleast)
        int[] arr = {1,2,3,5,6,4,2,0};
        System.out.println(peakIndexInMountainArray(arr));
    }
}
