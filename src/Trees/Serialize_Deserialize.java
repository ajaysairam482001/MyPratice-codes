package Trees;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/ (Qn:297)
//done using dfs  leetcode hard
//amazon
public class Serialize_Deserialize {
    int pointer = 0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) { //store in list
        List<String> list = new ArrayList<>();
        helper(root,list); //traverse pre orderly (recursively)
        return list.toString(); //do to string
    }
    public void helper(TreeNode node, List<String> list){ //pre order
        if(node == null){
            list.add("N");
            return;
        }
        list.add(String.valueOf(node.val));
        helper(node.left,list);
        helper(node.right,list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) { //remove all unwanted shit and split
        String[] arr = data.replace("[","").replace("]","").replaceAll("\\s+","").split(",");
        //Alternate
        // String str1 = str.replace("]","");
//        String str3 = str1.replaceAll("\\s+","");
        //String[] arr = str3.split(",");
        return helper2(arr);
    }
    public TreeNode helper2(String[] arr){ //build it
        if(arr[pointer].equals("N")){ //use pointer globally
            pointer++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(arr[pointer]));
        pointer++;
        node.left = helper2(arr);
        node.right = helper2(arr);
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
