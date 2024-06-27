package Trees;
//https://leetcode.com/problems/kth-smallest-element-in-a-bst/ (Qn:230)
//dfs
//facebook,amazon,google
//https://www.youtube.com/watch?v=9D-vP-jcc-Y&t=14119s (3:09:04)
public class Kth_SmallestElement_BST {
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        return helper(root,k).val;
    }
    public TreeNode helper(TreeNode node,int k){ //inorder for BST gives sorted array
        if(node == null){
            return null;
        }
        TreeNode left = helper(node.left,k);

        if(left != null){
            return left;
        }
        count++;
        if(count == k){
            return node;
        }

        return helper(node.right,k);
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
