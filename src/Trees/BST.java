package Trees;
//https://www.youtube.com/watch?v=4s1Tcvm00pA&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=51
public class BST {
    private class Node{
        private int value;
        private Node left;
        private Node right;
        private int height;

        public Node(int value){
            this.value = value;
        }

        public int getValue() {
            return value;
        }

    }

    private Node root;

    public BST(){} //constructor

    public int height(Node node) { //helper function
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty(Node node){
        return node == null;
    }

    public void prettyDisplay(){
        prettyDisplay(root,0);
        System.out.println("Height "+height(root));
    }
    private void prettyDisplay(Node node,int level){
        if(node == null){
            return;
        }
        prettyDisplay(node.right,level+1);
        if(level!=0){
            for(int i=0;i<level;i++){
                System.out.print("|\t\t");
            }
            System.out.println("|--->" + node.value);
        }
        else {
            System.out.println("|--->" + node.value);
        }

        prettyDisplay(node.left,level+1);
    }

    public void insert(int value){
        root = insert(root,value);
    }
    private Node insert(Node node, int value){
        if(node==null){
            node = new Node(value);
            node.height = 1;
            return node;
        }
        if(value < node.value){
            node.left = insert(node.left,value);
        }
        if(value > node.value){
            node.right = insert(node.right,value);
        }
        node.height = Math.max(height(node.left),height(node.right))+1;
        return node;
    }

    //for arrays as input
    public void populate(int[] nums){
        for(int i : nums){
            insert(i);
        }
    }


    public void populateSorted(int[] nums){ //incase if input array is sorted
        populateSorted(nums,0, nums.length);
    }
    private void populateSorted(int[] nums,int start,int end){
        if(start>=end){
            return;
        }
        int mid = start + (end - start)/2;
        insert(nums[mid]);
        populateSorted(nums,0,mid);
        populateSorted(nums,mid+1,end);
    }

    public boolean balanced(){
        return balanced(this.root);
    }
    private boolean balanced(Node node){
        if(node == null){
            return true;
        }
        // condition for balance is both child node's height difference should be less than or equal to 1
        return Math.abs(height(node.left) - height(node.right)) <=1 && balanced(node.left) && balanced(node.right);
    }

    public void display(){
        display(root,"The root Node is ");
    }
    private void display(Node node , String details){ //just a way of representing
        if(node == null){
            return;
        }
        System.out.println(details + node.value);
        display(node.left,"The left node of "+node.value+" is: ");
        display(node.right,"The right node of "+node.value+" is: ");
    }

}
