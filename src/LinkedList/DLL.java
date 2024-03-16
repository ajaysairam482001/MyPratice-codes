package LinkedList;

public class DLL {

    private int size = 0;
    Node head = null;

    int getSize(){
        return size;
    }
    void display(){
        if(head == null){
            System.out.println("Empty List");
            return;
        }
        Node node = head;
        while(node!=null){
            System.out.print(node.value+" <-> ");
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
        Node last = getNode(size-1);
        last.next = node;
        node.prev = last;
        size++;
    }

    void insert(int value, int index){
        if(head == null || index == 0){
            insertFirst(value);
            return;
        }
        if(index>size){
            System.out.println("Index out of bounds");
            return;
        }
        if(size == index){
            insertLast(value);
            return;
        }
        Node node = new Node(value);
        Node prev = getNode(index-1);
        node.next = prev.next;
        prev.next.prev = node;
        node.prev = prev;
        prev.next = node;
        size++;
    }

    void deleteFirst(){
        if(head == null){
            System.out.println("List does not exist");
            return;
        }
        if(head.next == null){
            head = null;
            size--;
            return;
        }
        head = head.next;
        head.prev = null;
        size--;
        return;
    }

    void deleteLast(){
        if(head == null){
            System.out.print("List does not exist");
            return;
        }
        if(size == 1){
            deleteFirst();
            return;
        }
        Node prev = getNode(size-2);
        prev.next = null;
        size--;
    }

    void delete(int index){
        if(head == null || index == 0){
            deleteFirst();
            return;
        }
        if(index>size){
            System.out.println("Index out of bounds");
            return;
        }
        if(size-1 == index){
            deleteLast();
            return;
        }
        Node prev = getNode(index-1);
        prev.next = prev.next.next;
        prev.next.prev = prev;
        size--;
    }

    void displayReverse(){
        Node node = head;
        if(node == null){
            System.out.print("Empty list");
            return;
        }
        reversetrasverse(node);
        System.out.println("Start");
    }

    void reversetrasverse(Node node){
        if(node == null){
            System.out.print("END <-> ");
            return;
        }
        reversetrasverse(node.next); //recursion
        System.out.print(node.value+" <-> ");
    }

    private class Node{
        private int value;
        private Node prev;
        private Node next;


        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next,Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}
