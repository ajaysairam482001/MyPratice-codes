package Trees;
//https://replit.com/@KunalsReplit/Trees-2-AVL#AVL.java
//https://www.youtube.com/watch?v=CVA85JuJEn0&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=52
public class AVL_Trees {
    //this is a correct code, learn and uderstand the concept, some minor bugs found and corrected
    /// stack overflow is fire!
    //https://stackoverflow.com/questions/78537739/having-an-issue-with-my-avl-tree-code-implementation/78539630#78539630
    //please refer the above link
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

    public AVL_Trees(){} //constructor

    public int height() {
        return height(root);
    }
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
            return new Node(value);
        }
        if(value < node.value){
            node.left = insert(node.left,value);
        }
        if(value > node.value){
            node.right = insert(node.right,value);
        }
        node.height = Math.max(height(node.left),height(node.right)) + 1;
        return rotate(node);
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

    private Node rotate(Node node){
        if(height(node.left) - height(node.right) > 1){
            //left heavy
            if(height(node.left.left) - height(node.left.right) > 0 ){ //put 0, not 1 or -1 think about it!
                //left-left case
                return rightRotate(node);
            }
            if(height(node.left.left) - height(node.left.right) < 0){
                //left-right case
                node.left =  leftRotate(node.left);
                return rightRotate(node);
            }
        }

        if(height(node.left) - height(node.right) < -1){
            //right heavy
            if(height(node.right.left) - height(node.right.right) < 0){
                //right-right case
                return leftRotate(node);
            }
            if(height(node.right.left) - height(node.right.right) > 0){
                //right-left case
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }

    private Node rightRotate(Node p){
        Node c = p.left;
        Node t = c.right;

        c.right = p;
        p.left = t;
        //updating heights
        //Remember to Always update the deepest node first and come upward
        p.height = Math.max(height(p.left),height(p.right))+1;
        c.height = Math.max(height(c.left),height(c.right))+1;
        return c;
    }

    private Node leftRotate(Node c){
        Node p = c.right;
        Node t = p.left;

        p.left = c;
        c.right = t;
        //updating heights
        //Remember to Always update the deepest node first and come upward
        c.height = Math.max(height(c.left),height(c.right))+1;
        p.height = Math.max(height(p.left),height(p.right))+1;
        return p;
    }
}
