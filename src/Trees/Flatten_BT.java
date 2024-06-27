package Trees;
//https://www.youtube.com/watch?v=9D-vP-jcc-Y&t=14119s Time: (2:28:30)
//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/ (Qn:114)
//dfs
//facebook
public class Flatten_BT {
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        TreeNode current = root;
        while (current != null){
            if(current.left!=null){
                TreeNode temp = current.left;
                while (temp.right!=null){
                    temp = temp.right;
                }
                temp.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
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
