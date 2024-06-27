package Stacks_and_Queues;

import java.util.Arrays;
import java.util.Stack;

//Leetcode: (Qn:84)
//video: https://www.youtube.com/watch?v=vcv3REtIvEo
public class LargestRectagleInHistogram {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[]{2,1,5,6,2,3,1};
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];

        //to find the leftmost limit of each element
        for(int i=0;i< arr.length;i++){
            if(stack.isEmpty()){ //base case
                left[i] = 0;
                stack.push(i);
            }
            else{ //for travesal explaination video (11:40)
                while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                    stack.pop();
                }
                left[i] = stack.isEmpty() ? 0 : stack.peek()+1;
                stack.push(i);
            }
        }

        stack.clear(); //always clear the stack for reuse purposes

        //to find the rightmost limit of each element
        for(int i = arr.length-1;i>=0;i--){
            if(stack.isEmpty()){ //base case
                right[i] = arr.length-1;
                stack.push(i);
            }
            else{ //for travesal explaination video (11:40)
                while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                    stack.pop();
                }
                right[i] = stack.isEmpty() ? arr.length-1 : stack.peek()-1;
                stack.push(i);
            }
        }

        int max = 0;
        for(int i = 0;i< arr.length;i++){
            int result = arr[i]*(right[i]-left[i]+1);
            if(max<result){
                max = result;
            }
        }
        System.out.println("The Max Area : "+max);
    }

    static void display(int[] arr){
        System.out.println(Arrays.toString(arr));
    }
}
