package Search_sort;
//https://www.geeksforgeeks.org/find-rotation-count-rotated-sorted-array/
public class FindTheCountInRotatedArray {
    // really simple find the pivot element and return (pivot's index)+1 that's it
    //ctrl+c&V
    public static int duplicates_involved_pivots(int[] arr){
        // copying this function just in case you can also opt to non-duplicate
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
        int[] arr = {4,5,6,7,1,2,3};
        //int[] arr = {4,5,6,7,8,9,10};
        System.out.print("The Rotated Count of the given Array is: ");
        int res = duplicates_involved_pivots(arr);
        if(res!=-1)
            System.out.println(res+1);
        else
            System.out.println("No Rotating found");
    }
}
