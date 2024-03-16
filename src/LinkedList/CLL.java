package LinkedList;

public class CLL { //single direction
    private int size = 0;
    private Node head = null;
    private Node last = null;

    int getSize(){
        return size;
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

    void display(){
        Node node = head;
        if(node == null){
            System.out.print("Empty list");
            return;
        }
        do{
            System.out.print(node.value+" -> ");
            node = node.next;
        }while(node!=head);
        System.out.println("End "+ size);
    }

    void insertFirst(int value){
        Node node = new Node(value);
        if(head == null){
            head = node;
            head.next = last;
            last = node;
            last.next = head;
            size++;
            return;
        }
        node.next = head;
        head = node;
        last.next = head;
        size++;
    }

    void insertLast(int value){
        if(head == null){
            insertFirst(value);
            return;
        }
        Node node = new Node(value);
        last.next = node;
        node.next = head;
        last = node;
        size++;
    }

    void insert(int value,int index){
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
        prev.next = node;
        size++;
    }

    void deleteFirst(){
        if(head == null){
            System.out.println("List does not exist");
            return;
        }
        if(head == last){
            head = null;
            size--;
            return;
        }
        if(head.next == last){
            head = last;
            last.next = null;
            size--;
            return;
        }
        head = head.next;
        last.next = head;
        size--;
        return;
    }

    void deleteLast(){
        if(head == null){
            System.out.print("List does not exist");
            return;
        }
        if(last == head){
            deleteFirst();
            return;
        }

        Node prev = getNode(size-2);
        prev.next = head;
        last = prev;
        size--;
    }

    void delete(int index){
        if(head == null || index == 0){
            deleteFirst();
            return;
        }
        if(index>=size){
            System.out.println("Index out of bounds");
            return;
        }
        if(size-1 == index){
            deleteLast();
            return;
        }
        Node prev = getNode(index-1);
        prev.next = prev.next.next;
        size--;
    }

    //reverse method poda thembu ila
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
}
