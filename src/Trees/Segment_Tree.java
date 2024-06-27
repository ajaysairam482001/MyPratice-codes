package Trees;

public class Segment_Tree {

    private static class Node{
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;

        public Node (int startInterval,int endInterval){
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }

    public Segment_Tree(int[] arr){
        this.root = construct(arr,0,arr.length-1);
    }
    Node root;

    private Node construct(int[] arr,int start,int end){
        if(start == end){
            //leaf node
            Node leaf = new Node(start,end);
            leaf.data = arr[start];
            return leaf;
        }
        //if not base case create a new node
        Node node = new Node(start, end);

        int mid = (start + end) / 2;
        node.left = construct(arr,start,mid);
        node.right = construct(arr,mid+1,end);

        //update data while callback and send node upward
        node.data = node.left.data + node.right.data;
        return node;
    }

    public int query(int sqe,int eqe){
        return query(this.root,sqe,eqe);
    }
    private int query(Node node,int start,int end){
        if(node.startInterval>=start && end>=node.endInterval){
            //node is completely inside this query
            return node.data;
        } else if (node.startInterval>end || node.endInterval<start) {
            //completely outside
            return 0;
        }else {
            return this.query(node.left,start,end) + this.query(node.right,start,end);
        }
    }

    public void update(int value,int index){
        this.root.data = update(this.root,value,index);
    }
    private int update(Node node,int value,int index){
        if(index>=node.startInterval && index<=node.endInterval){
            if(index == node.startInterval && index == node.endInterval){
                node.data = value;
                return node.data;
            }
            else {
                //        int leftAns = update(node.left, index, value);
                //        int rightAns = update(node.right, index, value);
                //        node.data = leftAns + rightAns;
                //(alternate)
                node.data = update(node.left,value,index) + update(node.right,value,index);
                return node.data;
            }
        }
        return node.data;
    }

    public void display(){
        //simple display function to display left - center - right node like every node
        display(this.root);
    }
    private void display(Node node){
        String str = "";
        //left node
        if(node.left!=null){
            str += "Interval ("+node.left.startInterval+","+node.left.endInterval+")-value is: "+node.left.data+" => ";
        }else{
            str += "No left child => ";
        }

        //current node
        str = str + "Interval ("+node.startInterval+","+node.endInterval+")-value is: "+node.data;

        //right node
        if(node.right!=null){
            str += " <= Interval ("+node.right.startInterval+","+node.right.endInterval+")-value is: "+node.right.data;
        }else{
            str += " <= No right child";
        }
        System.out.println(str + '\n'); //new line and content

        if(node.left!=null){
            display(node.left);
        }
        if(node.left!=null){
            display(node.right);
        }
    }
}
