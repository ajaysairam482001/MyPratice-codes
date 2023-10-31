package Leetcode;
//https://leetcode.com/problems/split-array-largest-sum/
// Qn 410  (hard)(Google question)
public class Split_Array_Largest_Sum {

//    note to find the case 1 and case 2
//    case 1 -> the max element in the array
//    case 2 -> the sum of the entire array
//    do binary search between the (case1,case2) as start and end
//    find the mid as usual and form the subarrays whose sum doesn't exceed mid and increment the piece variable to denote the no.of subarrays
//    And when you get the count of pieces do the binary update bit like
//    check if (pieces<=target (k)) put end = mid;
//    or if (pieces>target) put start = mid+1;
//    the while loop ends at when start and end and also mid arrive at the potential answer which is our output return it
    public static int splitArray(int[] nums, int k) {
        int start = 0;
        int end = 0;
        for (int j : nums) {
            start = Math.max(start, j); //case 1;
            end += j;                   //case 2;
        }
        while(start!=end){
            int piece = 1;
            int mid = start + (end - start)/2;
            int sum = 0;
            for(int num : nums){
                if(sum + num > mid){
                    piece++;
                    sum=num;
                }
                else{
                    sum += num;
                }
            }
            if(piece <= k)
                end = mid;
            else
                start = mid + 1;
        }
        return start;
    }

    public static void main(String[] args) {
        int[] arr = {7,2,5,10,8};
        System.out.println(splitArray(arr,2));
    }
}
