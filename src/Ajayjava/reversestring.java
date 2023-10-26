package Ajayjava;

import java.util.InputMismatchException;
import java.util.Scanner;

public class reversestring {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            String s = in.nextLine();
            if(s.isEmpty()){
                throw new InputMismatchException("User did not enter value");
            }
            else if((s.equals("null")) || (s.equals("NULL"))){
                throw new InputMismatchException("Invalid String");
            }
            int start, end;
            start = 0;
            end = s.length() - 1;
            char[] ch = s.toCharArray();
            for (int i = 0; start < end; i++) {
                char temp = ch[start];
                ch[start] = ch[end];
                ch[end] = temp;
                start++;
                end--;
            }
            System.out.print(String.valueOf(ch));
            in.close();
        }
        catch (InputMismatchException e){
            System.out.println("Error: "+e.getMessage());
        }

    }
}
