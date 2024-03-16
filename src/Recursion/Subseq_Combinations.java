package Recursion;

import java.util.ArrayList;

//in an given string derive the possible subsets
//Eg: input:"abc"
//    output:['a','b','c','ab','ac','bc','abc'] are the possible subsets
// ba,ca,cb are not allowed in these type of subset subsequence
public class Subseq_Combinations {
    public static void main(String[] args) {
        String str = "abc";
//        subseq("",str);
        System.out.println(subseqRet("",str));
//        subseqASCII("",str);
    }
    // up - "UnProcessed"
    static void subseq(String asf, String up){
        if(up.isEmpty()){
            System.out.println(asf);
            return;
        }
        char ch = up.charAt(0);
        subseq(asf + ch,up.substring(1)); //one call to add the char
        subseq(asf,up.substring(1));//one call to ignore it
    }

    static ArrayList<String> subseqRet(String asf, String up){
        //this function has same functionality but return in Arraylist
        if(up.isEmpty()){
            //when hitting the last node create a new list append asf and set it upward
            ArrayList<String> list = new ArrayList<>();
            list.add(asf);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> left = subseqRet(asf + ch,up.substring(1)); //one call to add the char
        ArrayList<String> right = subseqRet(asf,up.substring(1));//one call to ignore it
        //collect lists coming up from right and left combine it and send it upward
        left.addAll(right);
        return left;
    }

    static void subseqASCII(String asf, String up){ //just to print the ASCII value with them
        if(up.isEmpty()){
            if(!asf.isEmpty()) {
                System.out.println(asf);
            }
            return;
        }
        char ch = up.charAt(0);
        subseq(asf + ch,up.substring(1)); //one call to add the char
        subseq(asf + (ch+0),up.substring(1));
        subseq(asf,up.substring(1));//one call to ignore it

    }
}
