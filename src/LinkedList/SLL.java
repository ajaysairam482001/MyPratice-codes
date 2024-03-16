package LinkedList;

public class SLL {
    private int size = 0;
     Node head = null;
     Node tail = null;

     int getSize(){
         return size;
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
         if(node == tail){
             System.out.print("END -> ");
             System.out.print(node.value+" -> ");
             return;
         }
         reversetrasverse(node.next); //recursion
         System.out.print(node.value+" -> ");
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
         if(head.next == null){
             head = null;
             size--;
             return;
         }
         head = head.next;
         size--;
         return;
     }

     void deleteLast(){
         if(head == null){
             System.out.print("List does not exist");
             return;
         }
         if(tail == head){
             deleteFirst();
             return;
         }

         Node prev = getNode(size-2);
         prev.next = null;
         tail = prev;
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
         if(size == index){
             deleteLast();
             return;
         }
         Node prev = getNode(index-1);
         prev.next = prev.next.next;
         size--;
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
