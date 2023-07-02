package Ajayjava;

import java.util.Scanner;

public class reversestring {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        String s = in.nextLine();
        int start,end;
        int len = s.length();
        start = 0;
        end = len-1;
        char[] ch = s.toCharArray();
        for(int i = 0;start<end;i++){
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start++;
            end--;
        }
        System.out.print(String.valueOf(ch));

    }
}
