package Trees;

import java.util.Scanner;
//https://www.youtube.com/watch?v=4s1Tcvm00pA&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=51
public class Imp_BinaryTree {
    //Main can be ran in the main funtion
    private class Node{
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    //inserting
    public void populate(Scanner in){
        System.out.println("Enter the value of the root Node: ");
        int value = in.nextInt();
        root = new Node(value);
        populate(in,root);
    }

    private void populate(Scanner in, Node node){
        System.out.println("Do you want to enter in the left side of the node "+node.value);
        boolean left = in.nextBoolean();
        if(left){
            System.out.println("Enter the value: ");
            int value = in.nextInt();
            node.left = new Node(value);
            populate(in,node.left);
        }

        System.out.println("Do you want to enter in the right side of the node "+node.value);
        boolean right = in.nextBoolean();
        if(right){
            System.out.println("Enter the value: ");
            int value = in.nextInt();
            node.right = new Node(value);
            populate(in,node.right);
        }
    }

    public void display(){
        display(this.root,"");
    }
    private void display(Node node,String indent){
        if(node == null){
            return;
        }
        System.out.println(indent + node.value);
        display(node.left,indent + "\t");
        display(node.right,indent + "\t");
    }

    public void prettyDisplay(){
        prettyDisplay(root,0);
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
            System.out.println("|---->"+node.value);
        }else {
            System.out.println("|---->"+node.value);
        }
        prettyDisplay(node.left,level+1);
    }

    //types of traversals in a binary tree

    //1.Pre-Order traversal   // N->L->R
    //Used for evaluating math expression or making a copy
    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.value+" ");
        preOrder(node.left);
        preOrder(node.right);
    }

    //2.InOrder traversal   // L->N->R
    //uses: in BST, can visit nodes in sorted manner (2.37.05)
    //in BST you want elements in sorted order use inorder traversal
    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.value+" ");
        inOrder(node.right);
    }

    //3.Post-Order traversal   // L->R->N
    //uses: To delete a binary tree , or performing bottom-up calculations(finding the height)
    public void postOrder(){
        postOrder(root);
    }
    private void postOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value+" ");
    }
}
