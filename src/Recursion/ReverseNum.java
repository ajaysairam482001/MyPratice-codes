package Recursion;

public class ReverseNum {
    static int sum = 0;
    static void rev1(int num){//this function is using external variable for help to store data
        if(num == 0)
            return;
        sum = sum*10 + (num%10);
        rev1(num/10);
    }
    static int rev2(int n){// using helper functions and pure recursion
        int count = (int)(Math.log10(n));
        return helper(n,count);
    }
    static int helper(int n,int count){
        if(n%10==n)
            return n;
        return (n%10)*(int)(Math.pow(10,count)) + helper((n/10),count-1);
    }
    static boolean palindrome(int n){
        if(n == rev2(n))
            return true;
        return false;
    }
    public static void main(String[] args) {
        rev1(4218);
        System.out.println(sum);
        System.out.println(rev2(4218));
        System.out.println(palindrome(112211));
    }
}
