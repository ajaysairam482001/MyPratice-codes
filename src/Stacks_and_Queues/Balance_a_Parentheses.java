package Stacks_and_Queues;
//https://www.youtube.com/watch?v=LScsC-C5gvg
//Leetcode: (Qn:1541)
public class Balance_a_Parentheses {
    public static int minInsertions(String s) {
        String str = s.replace("))", "]"); //alternate option below main function
        int stack = 0;
        int invalidCount = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                stack++;
            } else {
                if (c == ')') {
                    invalidCount++;
                }
                if (stack == 0) {
                    invalidCount++;
                } else {
                    stack--;
                }
            }
        }
        return invalidCount + stack*2;
    }
    public static void main(String[] args) {
        String s = "(()";
        System.out.println(minInsertions(s));
    }

    //  this below for loop is the alternate loop when you dont wanna use s.replace() function
    //for (int i = 0; i < str.length(); i++) {
    //            char c = str.charAt(i);
    //            if (c == '(') {
    //                stack++;
    //            } else {
    //                if (i+1==str.length() || s.charAt(i+1) != ')') { //this condition is changed according to edge cases
    //                    invalidCount++;
    //                }
    //                if (stack == 0) {
    //                    invalidCount++;
    //                } else {
    //                    stack--;
    //                }
    //            }
    //        }
}
