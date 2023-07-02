package virtusa;

import java.util.Scanner;

public class reverse {

        public static String reverseString(String str){
            StringBuilder sb=new StringBuilder(str);
            sb.reverse();
            return sb.toString();
        }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(reverseString(str));

    }
    }


