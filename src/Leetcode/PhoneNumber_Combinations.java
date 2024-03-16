package Leetcode;
//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
//i did this on my own youtube may have an optimized solution
// Qn:17
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumber_Combinations {
    static Map<String,int[]> pad = new HashMap<>();
    static {
        pad.put("1", new int[]{});
        pad.put("2", new int[]{1, 2, 3});
        pad.put("3", new int[]{4, 5, 6});
        pad.put("4", new int[]{7, 8, 9});
        pad.put("5", new int[]{10, 11, 12});
        pad.put("6", new int[]{13, 14, 15});
        pad.put("7", new int[]{16, 17, 18, 19});
        pad.put("8", new int[]{20, 21, 22});
        pad.put("9", new int[]{23, 24, 25, 26});
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("","231"));
    }


    static List<String> letterCombinations(String asf,String digits) { //own method
        if(digits.isEmpty()){
            List<String> list = new ArrayList<>();
            list.add(asf);
            return list;
        }
        List<String> list = new ArrayList<>();
        char ch = digits.charAt(0);
        if(ch == '1'){ //exception solved
            list.addAll(letterCombinations(asf, digits.substring(1)));
        }
        else {
            int[] arr = pad.get(ch + "");
            for (int i = 0; i < arr.length; i++) {
                char cc = (char) ('a' + arr[i] - 1);
                list.addAll(letterCombinations(asf + cc, digits.substring(1)));
            }
        }
        return list;
    }
}
