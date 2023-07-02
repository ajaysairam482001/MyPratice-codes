package virtusa;



import java.io.*;
import java.util.*;
interface mu{
    void m(String s);
}
class Main implements mu{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        mu m = new Main();
        m.m(s);
    }
    public void m(String s){
        String up = "";
        String lo = "";
        for(int i=0;i<s.length();i++){
            if(Character.isUpperCase(s.charAt(i)))
                up += s.charAt(i);
            else
                lo += s.charAt(i);
        }
        System.out.println(lo+up);
    }

}