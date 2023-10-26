package Ajayjava;

import java.util.ArrayList;
import java.util.List;

public class Find_premutations {
//    public static List<String> findPermutations(String str) {
//        List<String> permutations = new ArrayList<>();
//
//        if (str.length() == 1) {
//            permutations.add(str);
//        } else {
//            for (int i = 0; i < str.length(); i++) {
//                char firstChar = str.charAt(i);
//                String remainingChars = str.substring(0, i) + str.substring(i + 1);
//                List<String> innerPermutations = findPermutations(remainingChars);
//
//                for (String permutation : innerPermutations) {
//                    permutations.add(firstChar + permutation);
//                }
//            }
//        }
//
//        return permutations;
//    }
    static final List<String> permutations = new ArrayList<>();
    public static List<String> findPermutations(String str,String asf){ //asf => Answer so far

        if(str.length() == 0)
            permutations.add(asf);
        for(int i=0;i<str.length();i++){
            char firstChar = str.charAt(i);
            String strLp = str.substring(0,i);  // strLp => str Left part
            String strRp = str.substring(i+1); // strRp => str Right part
            String remChar = strLp+strRp;
            findPermutations(remChar,asf+firstChar);
        }
        return permutations;
    }
    static List<Integer> convert(List<String> s){
        List<Integer> formatted = new ArrayList<>();
        for(String str : s){
            formatted.add(Integer.parseInt(str));
        }
        return formatted;
    }

    public static void main(String[] args) {
        System.out.println(convert(findPermutations("1234","")));

    }
}
