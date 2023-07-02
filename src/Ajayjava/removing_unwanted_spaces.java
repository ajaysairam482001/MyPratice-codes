package Ajayjava;

import java.util.Scanner;

public class removing_unwanted_spaces {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        char[] ch = str.toCharArray();
        int len = str.length();
        int j;
        for (int i = 0; i < (len - 1); i++) {
            if (ch[0] == ' ') {
                for (j = 0; j < (len - 1); j++)
                    ch[j] = ch[j + 1];
                len--;
                i = -1;
                continue;

            }
            if (ch[i] == ' ' && ch[i + 1] == ' ') {
                for (j = i; j < (len - 1); j++)
                    ch[j] = ch[j + 1];
                ch[j] = '\0';
                len--;
                i--;
            }

        }
        for (int i = 0; i < len; i++) {
            System.out.print(String.valueOf(ch[i]));
        }
    }
}

