package Trees;

import java.util.Arrays;
//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/ (Qn:105)
//preorder
////https://www.youtube.com/watch?v=9D-vP-jcc-Y&t=14119s (3:18:38)
public class Construct_BT {
    //faster solution is done using heaps
    //which will be done later
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0){
            return null;
        }

        int r = preorder[0];
        int index = 0;
        for(int i=0;i<inorder.length;i++){
            if(r == inorder[i]){
                index = i;
                break;
            }
        }

        TreeNode node = new TreeNode(r);
        node.left = buildTree(Arrays.copyOfRange(preorder,1,index+1),Arrays.copyOfRange(inorder,0,index));
        node.right = buildTree(Arrays.copyOfRange(preorder,index+1,preorder.length),Arrays.copyOfRange(inorder,index+1,inorder.length));
        return node;
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
