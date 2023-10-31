package Search_sort;
// kunal video in rotated sorted array please understand the code on the duplicate function on how it works
public class Find_Pivot_in_Rotated_SortedArray {
    public static int pivot(int[] arr){ // works for non-duplicate elements
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int mid = start + (end - start)/2;
            if(mid>start && arr[mid]<arr[mid-1])
                return mid-1;
            if(mid<end && arr[mid]>arr[mid+1])
                return mid;
            if(arr[start]>arr[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }

    public static int duplicates_involved_pivots(int[] arr){
        int start = 0;
        int end = arr.length-1;
        while(start<=end) {
            int mid = start + (end - start) / 2;
            if (mid > start && arr[mid] < arr[mid - 1])
                return mid - 1;
            if (mid < end && arr[mid] > arr[mid + 1])
                return mid;
            //check if start,mid,end are equal and eliminate them
            if (arr[start] == arr[mid] && arr[end] == arr[mid]) {
                //what if start is pivot
                if (start < end && arr[start] > arr[start + 1])
                    return start;
                start++;
                //what end has pivot
                if (end > start && arr[end] < arr[end - 1])
                    return end - 1;
                end--;
            } else if (arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) { // if left side is sorted so pivot should be in right
                    start = mid +1;
            }
            else{
                end = mid - 1;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(duplicates_involved_pivots(arr));
    }
}
