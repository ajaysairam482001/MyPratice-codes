package Trees;

import com.sun.source.tree.Tree;

import java.util.Stack;
//https://replit.com/@KunalsReplit/TreeQuestions#DFS.java
public class DFS_via_stack {

    public void dfsstack(TreeNode node){
        if(node == null){
            return;
        }
        Stack<TreeNode>stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()){
            TreeNode removed = stack.pop();
            System.out.println(removed.val+" ");
            if(removed.right!=null){
                stack.push(node.right);
            }
            if(removed.left!=null){
                stack.push(node.left);
            }
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
