package Trees;
//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/submissions/1279624426/ (Qn:116)
//Amazon london question 2022
//https://www.youtube.com/watch?v=9D-vP-jcc-Y&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=56
//(BFS)
public class PopulatingNextRightPointers {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) { //joke question
        if(root == null){
            return root;
        }
        Node leftMost = root;
        while(leftMost.left!=null){
            Node current = leftMost;
            while(current!=null){
                current.left.next = current.right;
                if(current.next!=null){
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }
}
