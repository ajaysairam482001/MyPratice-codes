package Trees;

import FITA.serialization.PaymentInputImplementation;

//https://leetcode.com/problems/binary-tree-maximum-path-sum/description/ (Qn:124) //hard
public class BT_MaxSumPath {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }
    int helper(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = helper(node.left);
        int right = helper(node.right);

        left = Math.max(0, left); // to ignore the left and right values if its negative
        right = Math.max(0, right);

        int nodesum = node.val + left + right;
        max = Math.max(max, (nodesum));
        return node.val+ Math.max(left,right);
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
