package Search_sort;
// searching assuming the arr[] is sorted in ascending order
public class Binary_Search {

    int binarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;

        while(start<=end) {
            int mid = (start + end) / 2; //{OR} start + (end - start)/2 // In case when start+end is a larger value exceeding the capacity of int

            if (target == arr[mid]) // if mid element is already equal with target we are in luck
                return mid;
            else {
                if (target < arr[mid]) // make sense to check the left side from middle to find the value
                    end = mid - 1;
                else
                    start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {-10,-6,-2,0,1,2,3,5,9,15,22,34,99};
        int target = 22;
        Binary_Search obj = new Binary_Search();
        System.out.println(obj.binarySearch(arr,target)); // returns the index of the target
    }
}
