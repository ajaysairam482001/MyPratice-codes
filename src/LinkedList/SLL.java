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

     void insertRec(int value,int index){
         head = insertRec(value,index,head); //start from head
     }
     private Node insertRec(int value,int index,Node node){
         if(index == 0){ //when you hit the required node index to add it to
             Node temp = new Node(value,node); //create a new node and point it to the current one in the index(3)
             size++;
             return temp; //just return it so the previous call the node.next (in index 2) will point to the new node created making it(the new node) as index 3
         }
         node.next = insertRec(value,index-1,node.next);
         return node;
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

    //Questions Leetcode: (QN:83)
    void sortedDuplicateRemoval(){
        if(head == null){
            return;
        }
        Node node = head;
        while(node.next != null){
            if(node.value == node.next.value){
                node.next = node.next.next;
            }
            else {
                node = node.next;
            }
        }
        tail = node;
        tail.next = null;
    }

    //Question //merge Leetcode: (Qn:21) //https://leetcode.com/problems/merge-two-sorted-lists/submissions/1206240968/
    //check out this solution is different than the other!
    SLL mergeTwoSortedLists(Node list1,Node list2){
         SLL ans = new SLL();
         Node f = list1;
         Node s = list2;
         while(f !=null && s!=null){
             if(f.value<s.value){
                 ans.insertLast(f.value);
                 f = f.next;
             }else {
                 ans.insertLast(s.value);
                 s = s.next;
             }
         }
         while(f!=null){
             ans.insertLast(f.value);
             f = f.next;
         }
        while(s!=null){
            ans.insertLast(s.value);
            s = s.next;
        }
        return ans;
    }

    //Question // if the linkedlist has a cycle ? https://leetcode.com/problems/linked-list-cycle/
    //Leetcode: (QN:141)
    public boolean hasCycle(Node head) {
        Node fast = head;
        Node slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }

    public int cycleLength(Node head) {
        Node fast = head;
        Node slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){ //to count the length of the cycle
                int length = 0;
                Node temp = slow;
                do{
                    temp = temp.next;
                    length++;
                }while(temp != slow);
                return length;
            }
        }
        return 0;
    }

    //Leetcode: (Qn:206) (recursive) (not submitted because of tail not available issues)
    public void reverse(Node node){
         if(node == tail){
             head = node;
             return;
         }
         reverse(node.next);
         tail.next = node;
         tail = node;
         node.next = null;
    }

   // Leetcode: (Qn:206) (iterative)
    public void reverse(){
        if(size<2){
            return;
        }
        Node prev = null;
        Node present = head;
        Node next = present.next;

        while (present!=null){
            present.next = prev;
            prev = present;
            present = next;
            if(next!=null){
                next = next.next;
            }
            head = prev;
        }
    }


}
