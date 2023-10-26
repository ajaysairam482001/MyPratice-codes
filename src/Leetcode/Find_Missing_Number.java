package Leetcode;

import java.util.Arrays;

//https://leetcode.com/problems/missing-number/
// Qn 268
public class Find_Missing_Number {
    public int missingNumber(int[] nums) {
        sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i)
                return i;
        }
        return nums.length;
    }

    public void sort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            if (arr[i] == arr.length) {
                i++;
            } else if (arr[i] != i)
                swap(arr, i, arr[i]);
            else
                i++;
        }
    }

    public void swap(int[] arr, int start, int last) {
        int temp = arr[start];
        arr[start] = arr[last];
        arr[last] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {0, 3, 1, 2};
        Find_Missing_Number obj = new Find_Missing_Number();
        System.out.println(obj.missingNumber(arr));

        // refered in submissions really work check the link
        //https://leetcode.com/problems/missing-number/solutions/69791/4-line-simple-java-bit-manipulate-solution-with-explaination/
//        int[] nums = {1, 0, 3, 2};
//        int res = nums.length;
//        for (int i = 0; i < nums.length; i++) {
//            res = res ^ i ^ nums[i]; // a^b^b = a
//        }

    }
}

