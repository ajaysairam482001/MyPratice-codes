package flowcontrol;
 /*Write a program to print the sum of all the digits of a given number.
         Example1)
         I/P:1234
         O/P:10*/

import java.util.Scanner;

public class prblm_14 {
    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        System.out.print("I/P: ");
        int num = in.nextInt();
        int sum=0;
        int temp = num;
        for(int i=1;i<=num;i++){
            int dig = temp%10;
            sum+=dig;
            temp/=10;
        }
        System.out.print("O/P:"+sum);
    }
}
