package Search_sort;
// if the given array is sorted ,but we have no idea if its Ascending or descending
//first we have to find its sorted way!
public class Order_AgnosticBinarySearch {

    public static void main(String[] args) {
        int[] arr = {10,9,8,7,6,5,4,3,2,1,0,-1,-2,-3}; // descending
 //       int[] arr = {-10,-6,-2,0,1,2,3,5,9,15,22,34,99}; // ascending
 //       int[] arr = {3,3,3,3,3,3,3}; // if they are all
        int target = 5;
        System.out.println(binarySearch(arr,target));
    }

    static int binarySearch(int[] arr,int target){
        int start = 0;
        int end = arr.length-1;
        boolean isAscending = arr[start]<arr[end];
        boolean isequal =  arr[start] == arr[end];

        if(isAscending){
            while(start<=end) {
                int mid = start + (end - start)/2; // alternate for (s+e)/2;

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
        else if(isequal){
            if(arr[start]==target)
                return start;
            else
                return -1;
        }

        else{//descending
            while(start<=end) {
                int mid = start + (end - start)/2; // alternate for (s+e)/2;

                if (target == arr[mid])
                    return mid;
                else {
                    if (target > arr[mid])
                        end = mid - 1;
                    else
                        start = mid + 1;
                }
            }
            return -1;
        }
    }
}
