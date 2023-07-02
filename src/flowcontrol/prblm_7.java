package flowcontrol;

import java.util.Scanner;

public class prblm_7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a character: ");
        char c1 = in.next().charAt(0);
        if(c1>=97&&c1<=122) {//uppercase-ing
            c1 -= 32;
            System.out.println(c1);
        }
        else if(c1>=65&&c1<=91) {//lowercase-ing
            c1 += 32;
            System.out.println(c1);
        }
    }
}
