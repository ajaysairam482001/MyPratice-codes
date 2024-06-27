package LinkedList;
//https://leetcode.com/problems/reverse-linked-list-ii/submissions/1208405390/ (QN:92)
public class ReverseLinkedList_II {
 //nanai potathu
    ListNode head = null;
    ListNode tail = null;

    ListNode reverseBetween(ListNode head,int left,int right){
        if(left==right){
            return head;
        }

        //skip the first left-1
        ListNode current = head;
        ListNode prev = null;
        for(int i = 0;i<left-1 && current!=null;i++){
            prev = current;
            current = current.next;
        }

        ListNode last = prev;
        ListNode newEnd = current;

        //reverse the inbetween
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
        }
        else{
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

    public static void main(String[] args) {
        ReverseLinkedList_II list = new ReverseLinkedList_II();
        list.insertLast(5);
        list.insertLast(4);
        list.insertLast(3);
        list.insertLast(2);
        list.insertLast(1);
        list.display();
        list.reverseBetween(list.head, 2,4);
        list.display();
    }
}
