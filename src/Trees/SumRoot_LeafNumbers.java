package Trees;
//Leetcode: (qn:129)
//dfs
public class SumRoot_LeafNumbers {
    public int sumNumbers(TreeNode root) {
        return helper(root,0);
    }
    int helper(TreeNode node, int sum){
        if(node == null){
            return 0;
        }
        sum = sum*10 + node.val;
        int left = helper(node.left,sum);
        int right = helper(node.right,sum);

        if(left == 0 && right == 0){
            return sum;
        }
        return left+right;
    }
    //kunal solution
    int helperAlt(TreeNode node, int sum){
        if(node == null){
            return 0;
        }
        sum = sum*10 + node.val;
        if(node.left == null && node.right == null){
            return sum;
        }
        return helper(node.left,sum)+helper(node.right,sum);
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
