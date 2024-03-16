package Recursion;



import java.util.ArrayList;

//(Google question)
//https://www.youtube.com/watch?v=9ByWqPzfXDU&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=35 (1.44)
public class PhonePad {
    public static void main(String[] args) {
        pad("","12");
      //  System.out.println(padRet("","123"));
        System.out.println(padCount("","1245"));
    }
    static void pad(String asf,String up){
        if(up.isEmpty()){
            System.out.print(asf+" ");
            return;
        }
        int digit = up.charAt(0)-'0'; //returns the converted int number(string) to digit(int)

        for(int i = (digit-1)*3;i<digit*3;i++){ //from sets like 0-3 (excluding 3)
            char ch = (char) ('a'+i);
            pad(asf+ch,up.substring(1));
        }
    }

    //same function returning as a arrayList
    static ArrayList<String> padRet(String asf, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(asf);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        int digit = up.charAt(0)-'0'; //returns the converted int number(string) to digit(int)

        for(int i = (digit-1)*3;i<digit*3;i++){ //from sets like 0-3 (excluding 3)
            char ch = (char) ('a'+i);
            list.addAll(padRet(asf+ch,up.substring(1)));
        }
        return list;
    }
//same function returning count
    static int padCount(String asf, String up){
        if(up.isEmpty()){
            return 1;
        }
        int count = 0;
        int digit = up.charAt(0)-'0'; //returns the converted int number(string) to digit(int)

        for(int i = (digit-1)*3;i<digit*3;i++){ //from sets like 0-3 (excluding 3)
            char ch = (char) ('a'+i);
            count += (padCount(asf+ch,up.substring(1)));
        }
        return count;
    }
}
