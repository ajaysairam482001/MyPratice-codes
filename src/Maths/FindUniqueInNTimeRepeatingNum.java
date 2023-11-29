package Maths;
//https://www.youtube.com/watch?v=fzip9Aml6og&t=2374s TimeSkip:1.17.25 (Question8)
// given an array of number repeating N times lets say #3 times here
// find the unique non-repeating number

public class FindUniqueInNTimeRepeatingNum {
    public static void main(String[] args) {
        int[] arr = {1,2,3,1,2,5,3,1,2,3};
        int total = 0;
        for(int num : arr){
            total ^= num;   // refer the video this is not exactly correct
    }
        System.out.println(total);

    }
}

