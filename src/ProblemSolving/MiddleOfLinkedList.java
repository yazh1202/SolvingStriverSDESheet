package ProblemSolving;

import ProblemSolving.ReverseLinkedList.ListNode;

public class MiddleOfLinkedList {
    public static void main(String[] args) {

    }

    //Simple Intuitive solution of first finding size and then going to the middle node
    static ReverseLinkedList.ListNode middleOf(ReverseLinkedList.ListNode head) {
        int count = 1;
        int run;
        ListNode ls = head;
        while (ls.next != null) {
            ls = ls.next;
            ++count;
        }
        run = (count / 2) + 1;
        ls = head;
        count = 1;
        while (count != run) {
            ls = ls.next;
            count++;
        }
        return ls;
    }

    //Using fast and Slow Pointer method
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
