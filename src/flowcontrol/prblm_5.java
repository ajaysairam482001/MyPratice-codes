package flowcontrol;

import java.util.Scanner;

public class prblm_5 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        char new1 = in.next().charAt(0);
        if(new1>='a'&&new1<='z'||new1>='A' && new1<='Z')
            System.out.print("Alphabet");
        else if(new1>='0'&&new1<='9')
            System.out.print("Digit");
        else
            System.out.print("Special Character");
    }
}
