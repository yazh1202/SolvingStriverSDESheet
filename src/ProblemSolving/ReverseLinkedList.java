package ProblemSolving;

public class ReverseLinkedList {
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
    static class ListNode {
        ListNode() {
        }

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode ref) {
            this.val = val;
            this.next = ref;
        }
    }

    //Simple Solution
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next;
        ListNode back = null;
        while (head.next != null) {
            next = head.next;
            head.next = back;
            back = head;
            head = next;
        }
        head.next = back;
        return head;
    }
}
