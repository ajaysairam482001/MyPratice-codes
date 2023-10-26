package zoho;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Input : {1,5,3,7}
//Output: {1,5,7} or {1,3,7} //for this case need to work on further
//so far sequential it works!
//Input : {10,22,9,33,21,50,41}
//Output: {10,22,33,50}

public class Longest_IncreasingSubSequenceOfAnArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of values: "); //not neccessary to take input
        int count = in.nextInt();
        int[] arr = new int[count];
       for(int i=0;i<count;i++){
           arr[i] = in.nextInt();
       }
       in.close();
        List<Integer> list = new ArrayList<>();
        int currentMax = Integer.MIN_VALUE;
        for (int j : arr) {
            if (currentMax < j) {
                currentMax = j;
                list.add(currentMax);
            }
        }
        System.out.println(list);
    }
}
