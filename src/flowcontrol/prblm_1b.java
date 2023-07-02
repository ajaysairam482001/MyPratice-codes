package flowcontrol;

import java.util.Scanner;

public class prblm_1b  {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int num1 = in.nextInt();
        int num2 = in.nextInt();
        if(num1%10==num2%10){
            System.out.println("true");
        }
        else
            System.out.println("false");
    }
}
