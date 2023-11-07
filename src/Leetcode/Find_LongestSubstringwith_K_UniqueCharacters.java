package Leetcode;

import java.util.HashMap;

//its a coderByte question
//function to return the size of the longest substring with K unique characters
//https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1?utm_source=geeksforgeeks&utm_medium=article_practice_tab&utm_campaign=article_practice_tab
//Sliding window problem
// Do watch the video for explaination: https://www.youtube.com/watch?v=FsIyn_oe3eo&t=31s
public class Find_LongestSubstringwith_K_UniqueCharacters {
    public int K_UniqCharacter(String s,Integer k){ //this return the max size
        int i = 0;
        int j = 0;
        int max = -1;
        HashMap<Character,Integer> map = new HashMap<>();
        while(j<s.length()){
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
            //     (Object Key,Value)  Value = (function to set it as zero if its new or add one(inc) if the key already exists)
            while(k<map.size()){
                map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)-1); // decrements the value
                if(map.get(s.charAt(i)) == 0){//if the value is zero remove it from map
                    map.remove(s.charAt(i));
                }
                i++;
            }
            if(map.size() == k){
                max = Math.max(max,j-i+1);
            }
            j++;
        }
        return max;
    }

    public static void main(String[] args) {
        Find_LongestSubstringwith_K_UniqueCharacters obj = new Find_LongestSubstringwith_K_UniqueCharacters();
        String s = "aabbbbb";
        int k = 3;
        System.out.println(obj.K_UniqCharacter(s,k));
        System.out.println(obj.K_UniqCharacterSubstring(s,k));
        //for testcases refer:https://www.geeksforgeeks.org/find-the-longest-substring-with-k-unique-characters-in-a-given-string/
    }

    public String K_UniqCharacterSubstring(String s,Integer k){ //this method returns the longest String
        int i = 0;
        int j = 0;
        int max = -1;
        String ans = "Not found";
        HashMap<Character,Integer> map = new HashMap<>();
        while(j<s.length()){
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
            //     (Object Key,Value)  Value = (function to set it as zero if its new or add one(inc) if the key already exists)
            while(k<map.size()){
                map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)-1); // decrements the value
                if(map.get(s.charAt(i)) == 0){//if the value is zero remove it from map
                    map.remove(s.charAt(i));
                }
                i++;
            }
            if(map.size() == k){
               // max = Math.max(max,j-i+1);
                if(max<j-i+1){
                    ans = s.substring(i,j+1);
                    max = j-i+1;
                }
            }
            j++;
        }
        return ans;
    }
}
