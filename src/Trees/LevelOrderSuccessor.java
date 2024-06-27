package Trees;

import java.util.LinkedList;
import java.util.Queue;

//Google question
//https://www.youtube.com/watch?v=9D-vP-jcc-Y&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=56
//(Time:34:08)
//(BFS)
public class LevelOrderSuccessor {
    public TreeNode findSuccessor(TreeNode root, int key){
        if(root == null){
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.left);
            }
            if(node.val == key){
                break;
            }
        }
        return queue.peek();
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
