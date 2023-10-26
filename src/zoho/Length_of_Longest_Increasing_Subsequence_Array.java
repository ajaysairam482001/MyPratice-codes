package zoho;

import java.util.Arrays;
// refer this video : https://www.youtube.com/watch?v=cjWnW0hdF1Y
public class Length_of_Longest_Increasing_Subsequence_Array {

    public static int lengthOfLIS(int[] num) {

        int[] dp = new int[num.length];
        Arrays.fill(dp, 1);

        for (int i = num.length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (num[i] > num[j]) {       // if the last term is greater just increment the dp@ that index
                    dp[j] = Math.max(dp[j], 1 + dp[i]);
                }
            }
        }
        int MaxLIS = 0;  //LIS -> 'Longest increasing subsequence.
        for (int i = 0; i < num.length; i++) {
            MaxLIS = Math.max(MaxLIS, dp[i]);

        }
        return MaxLIS;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 10, 2, 1, 20};
        System.out.println(lengthOfLIS(arr));
    }

}
//Input: arr[] = {3, 10, 2, 1, 20}
//Output: 3
//Explanation: The longest increasing subsequence is 3, 10, 20
