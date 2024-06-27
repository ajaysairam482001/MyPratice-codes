package LinkedList;

public class BubbleSortList {
    private int size = 0;
    Node head = null;
    Node tail = null;

    void sortList(Node head){
        if(head == null){
            return;
        }
        bubblesort(size-1,0);
    }

    private void bubblesort(int r,int c){
        if(r == 0){
            return;
        }
        if(c<r){
            Node first = getNode(c);
            Node second = getNode(c+1);
            if(first.value>second.value){ //edge case 1 (top)
                if(first == head){
                    head = second;
                    first.next = second.next;
                    second.next = first;
                } else if (second == tail) { //edge case 2 (last)
                    tail = first;
                    Node prev = getNode(c-1);
                    prev.next = second;
                    first.next = null;
                    second.next = first;
                }else {                     //case 3 (middle)
                    Node prev = getNode(c - 1);
                    prev.next = second;
                    first.next = second.next;
                    second.next = first;
                }
            }
            bubblesort(r,c+1);
        }
        else {
            bubblesort(r-1,0);
        }
    }
    private class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    void display(){
        Node node = head;
        if(node == null){
            System.out.print("Empty list");
            return;
        }
        while(node!=null){
            System.out.print(node.value+" -> ");
            node = node.next;
        }
        System.out.println("End");
    }
    Node getNode(int index){
        Node temp = head;
        for(int i = 0;i<size;i++){
            if(i == index){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    void insertFirst(int value){
        Node node = new Node(value);
        if(head == null){
            head = node;
            tail = node;
            size++;
            return;
        }
        node.next = head;
        head = node;
        size++;
    }

    void insertLast(int value){
        if(head == null){
            insertFirst(value);
            return;
        }
        Node node = new Node(value);
        tail.next = node;
        tail = node;
        size++;
    }
    //can also be applied to solve leetcode: (Qn:148)
    //but nama neraya inbuilt functions eluthura mari irukum
    public static void main(String[] args) {
        BubbleSortList list = new BubbleSortList();
        list.insertLast(5);
        list.insertLast(4);
        list.insertLast(3);
        list.insertLast(2);
        list.insertLast(1);
        list.display();
        list.sortList(list.head);
        list.display();
    }
}
