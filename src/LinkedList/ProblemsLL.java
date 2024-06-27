package LinkedList;

import java.util.List;
//https://www.youtube.com/watch?v=70tx7KcMROc&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=52
public class ProblemsLL {

    //checks if has cycle or not //leetcode (Qn:141)
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }

    //obviously finds the length
    public int cycleLength(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){ //to count the length of the cycle
                int length = 0;
                ListNode temp = slow;
                do{
                    temp = temp.next;
                    length++;
                }while(temp != slow);
                return length;
            }
        }
        return 0;
    }

    //to find the first index of the cycle //leetcode (Qn:142)
    public ListNode hasCycleIndex(ListNode head) {
        int length = 0;
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                length = cycleLength(slow);
                break;
            }
        }
        if(length == 0){
            return null;
        }
        //find the start node//
        ListNode first = head;
        ListNode second = head;
        while(length>0){
            first = first.next;
            length--;
        }
        // they will meet at the start node
        while(first!=second){
            first = first.next;
            second = second.next;
        }
        return second;
    }

    //happy number // leetcode (Qn:202)
    public boolean isHappy(int n) {

        int fast = n;
        int slow = n;
        do{
            fast = sumSq(sumSq(fast));
            slow = sumSq(slow);
        }while(fast!=slow);

        if(slow == 1){
            return true;
        }
        return false;
    }

    //helper method
    int sumSq(int num){
        int ans = 0;
        while(num>0){
            int rem = num%10;
            ans += rem*rem;
            num = num/10;
        }
        return ans;
    }

    //Find the middle element in the list // Leetcode:(Qn:876)
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        if(head == null)
            return null;
        if(head.next == null){
            return head;
        }
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    //Merge two sorted LinkedList // Leetcode (Qn:21)
    public ListNode mergeTwoLists(ListNode list1,ListNode list2) {
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

    //Leetcode: (Qn:234)
    public boolean isPalindromeLL(ListNode head){
        if(head == null){
            return false;
        }
        ListNode mid = middleNode(head);
        ListNode firsthead = head;
        ListNode secondhead = reverse(mid);
        while(firsthead!=null && secondhead!=null){
            if(firsthead.val != secondhead.val){
                break;
            }
            firsthead = firsthead.next;
            secondhead = secondhead.next;
        }
        if(firsthead == null || secondhead == null){
            return true;
        }
        return false;
    }

    //Leetcode : (Qn:206)
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

    //Leetcode: (Qn:143)
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        ListNode mid = middleNode(head);
        ListNode fh = head;
        ListNode sh = reverse(mid);
        while(fh!=null && sh!=null){ //learn this logic
            ListNode temp = fh.next; //(video:2.32.33) linkedlist problem
            fh.next = sh;
            fh = temp;
            temp = sh.next;
            sh.next = fh;
            sh = temp;
        }
        //put the tail as null if fh is last
        if(fh !=null){
            fh.next = null;
        }
    }

    //reverses from one node to another
    public ListNode reverse(ListNode head, int left, int right){
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

    // Leetcode:(Qn:25) (hard question)
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k < 1 || head == null) {
            return head;
        }
        int rem = 0; //to find the length
        ListNode temp = head;
        while(temp!=null){
            rem++;
            temp = temp.next;
        }
        ListNode prev = null;
        ListNode current = head;

        while (true) {
            //Mostly uses the code from reverse()method
            ListNode last = prev;
            ListNode newEnd = current;
            ListNode next = current.next;

            for (int i = 0; i < k && current != null; i++) {
                current.next = prev;
                prev = current;
                current = next;
                if (next != null) {
                    next = next.next;
                }
            }
            rem = rem-k; //remaining update

            if (last != null) {
                last.next = prev;
                } else {
                    head = prev;
                }
            newEnd.next = current;
            if(current ==null){
                break;
            }
            if(rem<k){ //if remaining elements is less that k break the loop or remaining also will be reversed
                break;
            }
            prev = newEnd;
        }
        return head;
    }

    //https://www.geeksforgeeks.org/reverse-alternate-k-nodes-in-a-singly-linked-list/
    public ListNode reverseKAlternateGroup(ListNode head, int k) {
        if (k < 1 || head == null) {
            return head;
        }
        int rem = 0; //to find the length
        ListNode temp = head;
        while(temp!=null){
            rem++;
            temp = temp.next;
        }
        ListNode prev = null;
        ListNode current = head;

        while (current!=null) {
            //Mostly uses the code from reverse()method
            ListNode last = prev;
            ListNode newEnd = current;
            ListNode next = current.next;

            for (int i = 0; i < k && current != null; i++) {
                current.next = prev;
                prev = current;
                current = next;
                if (next != null) {
                    next = next.next;
                }
            }
            rem = rem-k; //remaining update

            if (last != null) {
                last.next = prev;
            } else {
                head = prev;
            }
            newEnd.next = current;

            if(rem<k){ //if remaining elements is less that k break the loop or remaining also will be reversed
                break;
            }
            //skip the k nodes
            for(int i = 0;i<k&&current!=null;i++){
                prev = current;
                current = current.next;
            }
        }
        return head;
    }

    //Leetcode: (QN:61)
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k<1){
            return head;
        }
        int length = 1;
        ListNode temp = head;
        while(temp.next!=null){ //find the length and form a circle
            temp = temp.next;
            length++;
        }
        temp.next = head; //forming a circle LL

        int rotations = k % length;  //find the rotations
        int skip = length - rotations; //to skip the elements

        ListNode newLast = head;
        for(int i = 0;i<skip-1;i++){
            newLast = newLast.next;
        }
        head = newLast.next;
        newLast.next = null; //breaking the list
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
}
