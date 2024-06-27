package Stacks_and_Queues;

import java.util.Stack;

//Leetcode:20  (https://leetcode.com/problems/valid-parentheses/)
//https://www.youtube.com/watch?v=S9LUYztYLu4&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=55
public class Valid_Parentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '[' ){
                stack.push(c);
            }
            else{
                if(c == ')'){
                    if(stack.isEmpty() || stack.pop()!='(')
                        return false;
                }
                if(c == '}'){
                    if(stack.isEmpty() || stack.pop()!='{')
                        return false;
                }
                if(c == ']'){
                    if(stack.isEmpty() || stack.pop()!='[')
                        return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "{{}()}[";
        System.out.println(isValid(s));
    }
}
