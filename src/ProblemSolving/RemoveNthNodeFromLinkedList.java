package ProblemSolving;

import ProblemSolving.ReverseLinkedList.ListNode;

public class RemoveNthNodeFromLinkedList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int count = 1;
        // if(head.next==null){
        //     return null;
        // }
        while (temp.next != null) {
            temp = temp.next;
            count++;
        }
        int target = count - n;
        count = 1;
        temp = head;
        if (target == 0) {
            head = head.next;
            return head;
        }
        while (count != target && temp.next != null) {
            temp = temp.next;
            count++;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
        return head;
    }

    //Using Fast And Slow Pointer Method
    public ListNode removeNthFromEndFS(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        int count = 0;
        while (count != n) {
            count++;
            fast = fast.next;
        }
        if (fast == null) {
            if (head.next == null) {
                return null;
            }
            return slow.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return head;
    }
}
