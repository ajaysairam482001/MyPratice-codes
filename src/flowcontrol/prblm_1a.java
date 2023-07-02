package flowcontrol;

import java.util.Scanner;

public class prblm_1a {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        if(num>0)
            System.out.print("Positive");
        else if(num<0)
            System.out.print("Negative");
        else
            System.out.print("Zero");
    }
}
