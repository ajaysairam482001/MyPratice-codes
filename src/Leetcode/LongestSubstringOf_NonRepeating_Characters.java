package Leetcode;
//https://leetcode.com/problems/longest-substring-without-repeating-characters/
import java.util.HashSet;
//Qn:3
public class LongestSubstringOf_NonRepeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int max = 0;
        HashSet<Character> set = new HashSet<>();
        while(j<s.length()){
            if(!set.contains(s.charAt(j))){ //if doesn't contain add it and update the max if its size is greater
                set.add(s.charAt(j));
                if(set.size()>max)
                    max = set.size();
                j++;
            }
            else{ // so the char contains so remove an move the i pointer forward (the while will run until the if statement continues to be true)
                set.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }
}
