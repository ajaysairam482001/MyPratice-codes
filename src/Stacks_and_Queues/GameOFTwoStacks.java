package Stacks_and_Queues;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//in hacker rank (6/14) getting pass (taking a lot of time)
//hacker rank problem :
//Alexa has two stacks of non-negative integers, stack  and stack  where index  denotes the top of the stack. Alexa challenges Nick to play the following game:
//
//        In each move, Nick can remove one integer from the top of either stack  or stack .
//        Nick keeps a running sum of the integers he removes from the two stacks.
//        Nick is disqualified from the game if, at any point, his running sum becomes greater than some integer  given at the beginning of the game.
//        Nick's final score is the total number of integers he has removed from the two stacks.
//        Given , , and  for  games, find the maximum possible score Nick can achieve.
//
//        Example
//        a = [1,2,3,4,5]
//        b = [6,7,8,9]
//        The maximum number of values Nick can remove is 4. There are two sets of choices with this result.
//
//        Remove  from  with a sum of .
//        Remove  from  and  from  with a sum of .
public class GameOFTwoStacks {
    public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) { //since we are working with lists we can use the remove() function for stack.pop purposes
        // Write your code here
        return helper(a,b,0,maxSum,0);
    }
    public static int helper(List<Integer> a , List<Integer> b, int asf,int maxSum,int count){ //recursion
        if(asf>maxSum){
            return count-1;
        }
        if(a.isEmpty() || b.isEmpty()){ //if any stack is empty stop it right there
            return count;
        }
        int left = helper(a.subList(1,a.size()),b,asf+a.get(0),maxSum,count+1);
        //whereas in Array we have an another funtion as (Arrays.copyOfRange(a,1,a.length()), can use this when dealing with Arrays
        int right = helper(a,b.subList(1,b.size()),asf+b.get(0),maxSum,count+1);

        return Math.max(left, right);
    }

    public static void main(String[] args) {
        System.out.println("array one size,array two size, max Sum");
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        int sa;
        int sb;
        int maxSum;
        Scanner in = new Scanner(System.in);
        sa = in.nextInt();
        sb = in.nextInt();
        maxSum = in.nextInt();
        for(int i =0;i<sa;i++){
            a.add(in.nextInt());
        }
        for(int i =0;i<sb;i++){
            b.add(in.nextInt());
        }
        System.out.println();
        System.out.println(twoStacks(maxSum,a,b));
    }
}
//testcase
//5  4  10
//[4 2 4 6 1]
//[2 1 8 5]
//output:4
