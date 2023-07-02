package virtusa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class string8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String ans=str.charAt(0)+"";
        ArrayList<Character> list=new ArrayList<>();
        for(int i=0;i<str.length()-1;i++){
            char ch=str.charAt(i);

            if(list.contains(str.charAt(i))){
                continue;
            }

            list.add(ch);

            for(int j=1;j<str.length();j++){
                if(ch==str.charAt(j)){
                    ans+=ch;
                }
            }
        }
        System.out.println(ans);
    }
}
