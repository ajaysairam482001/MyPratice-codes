package Maths;
//https://www.youtube.com/watch?v=fzip9Aml6og&t=2374s TimeSkip:42.42 (Question2)&(question 3) covered with -ve values testcases
//Given an array of int there are values repeating 2(times) for example
//And one element is not repeating and its unique, we need to find that element
//Eg: [2,3,4,1,2,1,3,6,4]
//output: 6
public class FindThatNon_RepeatingNumber {
    public static void main(String[] args) {
       int[] arr = {2,3,4,1,2,1,3,6,4};
        // int[] arr = {-1,-2,-3,1,2,-6,3};
        System.out.println(ans(arr));
    }
    private static int ans(int[] arr){
        int unique = 0;
        for(int n : arr){
            unique ^= n;
        }
        return unique;
    }
}
//explanation: any number XOR with that number gives zero(check the XOR table)
//             so we XOR the array and duplicates XOR themselves and become zero
//             the unique element remains.
