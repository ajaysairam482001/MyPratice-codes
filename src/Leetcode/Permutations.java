package Leetcode;

import java.util.*;
//https://leetcode.com/problems/permutations/  qno 46
public class Permutations {
    static final List<List<Integer>> permutations = new ArrayList<>();
    public List<List<Integer>> permuteaa(int[] nums){
        permutations.clear();
        List<Integer> numsList = new ArrayList<>();
        for(int num : nums)
            numsList.add(num);
        List<Integer>asf = new ArrayList<>();
        permutate1(numsList,asf);
        return permutations;
        }

    public void permutate1(List<Integer>list,List<Integer> asf) {
    if(list.size()==0)
        permutations.add(new ArrayList<>(asf));
    for(int i=0;i< list.size();i++) {
        int firstEle = list.remove(i);
        asf.add(firstEle); // Add 'firstEle' to 'asf'
        permutate1(list, asf);
        asf.remove(asf.size() - 1); // Remove the last element to backtrack
        list.add(i, firstEle); // Restore 'firstEle' to its original position
    }
    }



    public static void main(String[] args) {
        Permutations obj = new Permutations();
        List<List<Integer>> lists1 = obj.permuteaa(new int[]{1, -2, 3});
        for(List list : lists1)
            System.out.print(list+" ");

//        List<List<Integer>> lists2 = obj.permuteaa(new int[]{6, -2, 4});
//        for(List list : lists2)
//            System.out.print(list+" ");
    }
}
