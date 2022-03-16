package ProblemSolving;

import ProblemSolving.ReverseLinkedList.ListNode;

public class LLAddTwoNumbers {


    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    //
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0, null);
        ListNode res = temp;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            temp.next = new ListNode(sum, null);
            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = l1.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            temp.next = new ListNode(sum, null);
            temp = temp.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            temp.next = new ListNode(sum, null);
            temp = temp.next;
            l2 = l2.next;
        }
        if (carry != 0) {
            temp.next = new ListNode(carry, null);
        }
        return res.next;
    }

    public ListNode addTwoNumbersTwo(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0, null);
        ListNode res = temp;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;
            temp.next = new ListNode(sum % 10, null);
            temp = temp.next;
        }
        if (carry != 0) {
            temp.next = new ListNode(carry, null);
        }
        return res.next;
    }
}
