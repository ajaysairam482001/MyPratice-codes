package Leetcode;
import java.util.*;
//https://leetcode.com/problems/3sum/
public class Three_Sum15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        Set<List<Integer>> map = new HashSet(); // to avoid duplicates elements
        Arrays.sort(nums);

        for(int i = 0;i<nums.length-2;i++){ // at last it will be i,ptr1,ptr2 so gud to stop at length-2;
            int ptr1 = i+1; // element of i as ptr
            int ptr2 = nums.length-1; // and last element
            while(ptr1<ptr2){
                int sum = nums[i] + nums[ptr1] + nums[ptr2];
                if(sum == 0){
                    map.add(Arrays.asList(nums[i] , nums[ptr1] , nums[ptr2])); // add them and dont forget to shift
                    ptr1++;
                    ptr2--;
                }
                else if(sum>0)
                    --ptr2;
                else
                    ++ptr1;
            }
        }
        list.addAll(map); //add the contents of map to list and return the list
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> result = threeSum(nums); // remember how to store and print the list
        System.out.println(result);
    }
}
