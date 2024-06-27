package Stacks_and_Queues;
//921. Minimum Add to Make Parentheses Valid (Leetcode)
//https://www.youtube.com/watch?v=S9LUYztYLu4&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=55 (2.12.30)
import java.util.Stack;

public class MinValidParenthesesII {
    public static int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == ')'){
                if(!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }
                else {
                    stack.push(c);
                }
            }
            else {
                stack.push(c);
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        String s = "(()))";
        System.out.println(minAddToMakeValid(s));
    }
}
