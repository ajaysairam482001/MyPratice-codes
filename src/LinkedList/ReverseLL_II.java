package LinkedList;

import java.util.List;

public class ReverseLL_II {

    ListNode head = null;
    ListNode tail = null;
    //all cases working except for left = 0
    //try for other methods
    public ListNode reverse(ListNode head,int left,int right){
        if(left==right){
            return head;
        }
        ListNode prev = null;
        ListNode current = head;

        //itertate until left-1;
        for(int i=0;i<left-1 && current!=null;i++){
            prev = current;
            current = current.next;
        }

        ListNode last = prev;
        ListNode newEnd = current;
        ListNode next = current.next;

        for(int i = 0;i<right-left+1 && current!=null;i++){
            current.next = prev;
            prev = current;
            current = next;
            if(next!=null){
                next = next.next;
            }
        }

        if(last!=null){
            last.next = prev;

        }else {
            head = prev;
        }
        newEnd.next = current;
        return head;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {

        }

        ListNode(int x) {
            val = x;
            next = null;
        }


    }

    void insertFirst(int value){
        ListNode node = new ListNode(value);
        if(head == null){
            head = node;
            tail = node;

            return;
        }
        node.next = head;
        head = node;

    }

    void insertLast(int value){
        if(head == null){
            insertFirst(value);
            return;
        }
        ListNode node = new ListNode(value);
        tail.next = node;
        tail = node;

    }

    void display(){
        ListNode node = head;
        if(node == null){
            System.out.print("Empty list");
            return;
        }
        while(node!=null){
            System.out.print(node.val+" -> ");
            node = node.next;
        }
        System.out.println("End");
    }

    public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode prev = null;
        ListNode present = head;
        ListNode next = present.next;

        while (present!=null){
            present.next = prev;
            prev = present;
            present = next;
            if(next!=null){
                next = next.next;
            }
        }
        head = prev;
        return head;
    }

    public static void main(String[] args) {
        ReverseLL_II list = new ReverseLL_II();
//        list.insertLast(5);
        list.insertLast(4);
        list.insertLast(3);
        list.insertLast(2);
        list.insertLast(1);
        list.display();
//        list.reverse(list.head, 1,2);
        list.reverse(list.head);
        list.display();
    }
}
