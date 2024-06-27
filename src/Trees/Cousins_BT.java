package Trees;
//BFS
//https://leetcode.com/problems/cousins-in-binary-tree/description/ (Qn:993)
//https://www.youtube.com/watch?v=9D-vP-jcc-Y&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=58 (time:1.14.52)
public class Cousins_BT {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null){
            return false;
        }
        TreeNode xx = findNode(root,x);
        TreeNode yy = findNode(root,y);

        return (level(root,xx,0)==(level(root,yy,0)) && (!isSibling(root,xx,yy)));
    }
    public static TreeNode findNode(TreeNode node, int val){
        if(node == null){
            return node;
        }
        if(node.val == val){
            return node;
        }
        TreeNode temp = findNode(node.left,val);
        if(temp != null){
            return temp;
        }
        return findNode(node.right,val);
    }
    public int level(TreeNode node, TreeNode x, int lev){
        if(node == null){
            return 0;
        }
        if(node == x){
            return lev;
        }
        int temp = level(node.left,x,lev+1);
        if(temp != 0){
            return temp;
        }
        return level(node.right,x,lev+1);
    }
    public boolean isSibling(TreeNode node, TreeNode x, TreeNode y){
        if(node == null){
            return false;
        }
        return((node.left == x && node.right == y) || (node.left == y && node.right == x)
        || isSibling(node.left,x,y) || isSibling(node.right,x,y));
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
