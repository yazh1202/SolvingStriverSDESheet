package ProblemSolving;

import ProblemSolving.ReverseLinkedList.ListNode;

public class LinkedListReverseInK {
    //Not really Understood
    public ListNode reverseKGroup (ListNode head,int k){
        //To find the length of the list
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode nex;
        ListNode cur;
        while (count >= k) {
            cur = pre.next;
            nex = cur.next;
            for (int i = 1; i < k; i++) {
                cur.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
                nex = cur.next;
            }
            pre = cur;
            count -= k;
        }
        return dummy.next;
    }
}
