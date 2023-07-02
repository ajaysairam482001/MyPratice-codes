package flowcontrol;

import java.util.Scanner;

public class prblm_4 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        char f1 = in.next().charAt(0);
        char f2 = in.next().charAt(0);
        if(f1>f2){
            System.out.println(f2+","+f1);
        }
        else
            System.out.println(f1+","+f2);
    }
}
