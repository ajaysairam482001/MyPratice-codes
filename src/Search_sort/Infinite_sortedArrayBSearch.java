package Search_sort;
//https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
//this below code is kunal's version not the geeksforgeeks's one!
public class Infinite_sortedArrayBSearch {

    public int findingRange(int[] arr,int target){
        int start = 0;
        int end = 1;
        while(arr[end]<target){
            int new_start = end+1; //OR temp;
            //end = (last end value) + (box_size or range_size and doubling it);
            end = end + (end - start + 1)*2;
            start = new_start;
        }
        return binarySearch(arr,target,start,end);
    }

    int binarySearch(int[] arr, int target,int start,int end){

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
        int[] arr = {3, 5, 7, 9, 10, 90,
                100, 130, 140, 160, 170,171,178,184,187,190};
        Infinite_sortedArrayBSearch obj = new Infinite_sortedArrayBSearch();
        System.out.println(obj.findingRange(arr,130));
    }
}
