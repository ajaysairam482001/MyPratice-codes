package Trees;

import java.util.*;
//(BFS)
//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/submissions/1279609718/ (Qn:103)
//https://www.youtube.com/watch?v=9D-vP-jcc-Y&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=56 (Time:42:10)
public class ZigZagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean reverse = true;
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);
            for(int i = 0;i<levelSize;i++){
                if(!reverse){
                    TreeNode node = queue.pollLast();
                    currentLevel.add(node.val);
                    if(node.right!=null){
                        queue.addFirst(node.right); //or offer
                    }
                    if(node.left!=null){
                        queue.addFirst(node.left);
                    }
                }
                else{
                    TreeNode node = queue.pollFirst();
                    currentLevel.add(node.val);
                    if(node.left!=null){
                        queue.addLast(node.left); //or offer
                    }
                    if(node.right!=null){
                        queue.addLast(node.right);
                    }
                }
            }
            reverse = !reverse;
            result.add(currentLevel);
        }
        return result;
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

