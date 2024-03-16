package Leetcode;
//https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/description/
//Qn: 1155
//Dynamic programming
//dei u waste one day on this refer this video //https://youtu.be/5fN2qHTGy_8?si=jGDubq6oNQbmFHv2 (explaination on dp array)
public class Dice_rollsWith_TargetSum {
    public static void main(String[] args) {
        System.out.println(numRollsToTarget(30,30,500));
    }

    // Memoization is a technique used in dynamic programming to improve the efficiency of recursive algorithms
    // by storing the results of expensive function calls and returning the cached result when the same inputs occur again.

    static int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n+1][target+1];
        dp[0][0] = 1;
        int mod = 1_000_000_007;
        for(int i = 1;i<=n;i++){ //dices row
            for(int j = 0;j<=target;j++){ // target column
                for(int faces = 1;faces<=k;faces++){ // adding up from the previous diagonal(north-west row), so it can't exceed the no.of.faces
                    if(j<faces){
                        continue;
                    }
                    dp[i][j] = (dp[i][j] + dp[i-1][j-faces]) % mod;
                }
            }
        }
        return dp[n][target];
    }


}
