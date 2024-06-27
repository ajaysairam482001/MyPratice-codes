package Trees;

import java.util.LinkedList;
import java.util.Queue;
//BFS
//https://leetcode.com/problems/symmetric-tree/ (Qn:101)
//https://www.youtube.com/watch?v=9D-vP-jcc-Y&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=58 (Time:1:28:06)

//In leetcode this soluton beats only 15% so try even more optimized solution
public class Symentric_Tree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while(!queue.isEmpty()){
            TreeNode x = queue.poll();
            TreeNode y = queue.poll();

            if(x == null && y == null){
                continue;
            }

            if(x == null || y == null ){
                return false;
            }

            if(x.val != y.val){
                return false;
            }

            queue.offer(x.left);
            queue.offer(y.right);
            queue.offer(x.right);
            queue.offer(y.left);
        }
        return true;
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
