package LinkedList;
//Leetcode:Qn(148)
public class MergeSortList {
//please be careful with the conditions or else it causes TLE and SOF errors
    ListNode sortList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode mid = middleNode(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return mergeTwoLists(left,right);
    }
    //helper
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode headDummy = new ListNode(); //a dummy head
        ListNode tail = headDummy; //mark the tail as itself
        while(list1 != null && list2 != null){
            if(list1.val<list2.val){
                tail.next = list1; //incoprate the node to the tail
                list1 = list1.next; //increment the list1 for futher comparison
                tail = tail.next; //move the tail also to the recently added element (list1(node))
            }else{
                tail.next = list2; //incoprate the node to the tail
                list2 = list2.next; //increment the list2 for futher comparison
                tail = tail.next; //move the tail also to the recently added element (list2(node))
            }
        }
        tail.next = (list1 != null)?list1:list2; //and to fill the remainig elements
        return headDummy.next; //consider dummyHead. next as head and return it
    }
    //helper //modified chatGPT one
    public ListNode middleNode(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            ListNode prev = null;

            while (fast != null && fast.next != null) {
                prev = slow;
                slow = slow.next;
                fast = fast.next.next;
            }

            if (prev != null) {
                prev.next = null;  // Break the list into two halves
            }

            return slow;
        }



    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


}
