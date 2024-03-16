package Recursion;

import java.util.ArrayList;


//Kunal version
//https://www.youtube.com/watch?v=gDGw0cvFXPQ&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=33  (11.35) time
public class Permutations {  // for a string
    public static void main(String[] args) {
        permutate("","abc");
        System.out.println(permutateList("","abc"));
        System.out.println("Number of permutations: "+permutateCount("","abc"));
    }
     static void permutate(String p, String up){
        if(up.isEmpty()) {
            System.out.println(p);
         return;
        }
        char ch = up.charAt(0);
        for(int i = 0;i<=p.length();i++){
            String first = p.substring(0,i);
            String second = p.substring(i,p.length());
            permutate(first+ch+second,up.substring(1));
        }
     }

    static ArrayList<String> permutateList(String p, String up){ //same functionality but returning in list
        if(up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        char ch = up.charAt(0);
        for(int i = 0;i<=p.length();i++){
            String first = p.substring(0,i);
            String second = p.substring(i,p.length());
            list.addAll(permutateList(first+ch+second,up.substring(1))); //to learn about .addAll refer Recursion\Subseq_Combinations.java
        }
        return list;
    }

    static int permutateCount(String p, String up){ //same func just returning count
        if(up.isEmpty()) {
            return 1;
        }
        int count = 0;
        char ch = up.charAt(0);
        for(int i = 0;i<=p.length();i++){
            String first = p.substring(0,i);
            String second = p.substring(i,p.length());
            count = count + permutateCount(first+ch+second,up.substring(1));
        }
        return count;
    }
}
