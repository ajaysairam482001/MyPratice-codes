package flowcontrol;

import java.util.Scanner;

public class prblm_2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        if(num%2==0)
            System.out.print("Even");
        else
            System.out.print("Odd");
    }
}
