package Trees;
//DFS
//https://leetcode.com/problems/maximum-depth-of-binary-tree/submissions/1280805499/ (Qn:104)
//https://www.youtube.com/watch?v=9D-vP-jcc-Y&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=59

public class MaxDepth { //maxHeight
    public int maxDepth(TreeNode root) {
        return height(root);
    }
    int height(TreeNode node){
        if(node == null){
            return 0;
        }
        int left =height(node.left);
        int right =height(node.right);
        return Math.max(left,right)+1;
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
