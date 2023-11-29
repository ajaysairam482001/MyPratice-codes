package Leetcode;
import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/palindrome-partitioning/
//Qn:131
//recursion & backtracking
public class Palindromic_Partition_OfAString {
    public static boolean isPalindrome(String str){
        int s = 0;
        int e = str.length()-1;
        while(s<e){
            if(str.charAt(s)!=str.charAt(e))
                return false;
            s++;
            e--;
        }
        return true;
    }
    public static List<List<String>>result = new ArrayList<>();
    public static List<String> ans = new ArrayList<>();
    public static void partition(String s){
        if(s.length() == 0){
            result.add(new ArrayList<>(ans)); // List are of reference type
            //be careful when you assign ans just like that without creating a new ArrayList
            //in other steps of ans when it changes also affect the result so create a separate list (copy of ans)
            //and assign it to result as the last step of the branch
            return;
        }
        for(int i=0;i<s.length();i++){
            String prefix = s.substring(0,i+1);
            String rem = s.substring(i+1);
            if(isPalindrome(prefix)){
                ans.add(prefix);
                partition(rem);
                ans.remove(ans.size()-1);
                // the remove() expects an index not a value (NOT)(ans.remove(prefix))
                //while backtracking remove the last added value using the size()-1 to keep the ans updated for other branches
            }

        }
    }

    public static void main(String[] args) {
        String str = "aab";
        partition(str);
        System.out.println(result);
    }
}
