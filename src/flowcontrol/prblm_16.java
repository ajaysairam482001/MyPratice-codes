package flowcontrol;

import java.util.Scanner;

public class prblm_16 {
    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int num = in.nextInt();
        int res = 0;
        while(num!=0){//1234
            int dig = num%10;
            res = dig+10*res;
            num/=10;
        }
        System.out.println(res);
    }
}
