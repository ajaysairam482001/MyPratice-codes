package Trees;
// for alternate code reference
//https://replit.com/@KunalsReplit/TreeQuestions#PathSum.java (line: 49) find path
//https://www.youtube.com/watch?v=9D-vP-jcc-Y&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ (Qn:23 in timeline)
public class PathExists_Root_Leaf {
    public boolean pathExist(TreeNode root, int[] arr){
        if(root == null){
            return arr.length == 0;
        }
        return helper(root,arr,0);
    }
    public boolean helper(TreeNode node, int[] arr, int pointer){
        if(node == null){
            return false;
        }
        if(pointer > arr.length-1){
            return false;
        }
        //leaf node
        if(pointer == arr.length-1 && node.left ==null && node.right ==null){
            if(arr[pointer] == node.val){
                return true;
            }
        }
        if(arr[pointer] == node.val){
            return helper(node.left,arr,pointer+1) || helper(node.right,arr,pointer+1);
        }
        return false;
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
