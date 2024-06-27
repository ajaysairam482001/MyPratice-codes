package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

//https://replit.com/@KunalsReplit/TreeQuestions#PathSum.java (line: 99)
//https://www.youtube.com/watch?v=9D-vP-jcc-Y&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ (Qn:24 2nd half) timeline
public class CountPaths {
    int countPaths(TreeNode root, int sum){
        List<Integer> list = new ArrayList<>();
        return helper(root,sum,list);
    }
    int helper(TreeNode node, int sum, List<Integer> path){
        if(node == null){
            return 0;
        }
        int count = 0;
        int s = 0;
        path.add(node.val);
        ListIterator<Integer> itr = path.listIterator(path.size()); //study docs
        while(itr.hasPrevious()){
            s += itr.previous();
            if(s == sum){
                count++;
            }
        }
        count += helper(node.left,sum,path) + helper(node.right,sum,path);

        //backtrack
        path.remove(path.size()-1);
        return count;
    }

    //put it in a list
    List<List<Integer>> countPathslist(TreeNode root, int sum){
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper2(root,sum,paths,path);
        return paths;
    }
    void helper2(TreeNode node, int sum, List<List<Integer>>paths, List<Integer> path){
        if(node == null){
            return;
        }

        path.add(node.val);

        if(node.val == sum && node.left == null && node.right == null) {
            paths.add(new ArrayList<>(path));
        } else {
            helper2(node.left,sum-node.val,paths,path);
            helper2(node.right,sum-node.val,paths,path);
        }

        //backtrack
        path.remove(path.size()-1);

    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
