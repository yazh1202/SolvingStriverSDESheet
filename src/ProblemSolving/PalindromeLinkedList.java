package ProblemSolving;

import ProblemSolving.ReverseLinkedList.ListNode;
/**Not Fully Understood**/
public class PalindromeLinkedList {
    static boolean isPalindrome(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        if (count == 1) {
            return true;
        }
        ListNode mid = head;
        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = mid.val;
            mid = mid.next;
        }
        mid = head;
        for (int j = count - 1; j >= 0; j--) {
            if (arr[j] != mid.val) {
                return false;
            }
            mid = mid.next;
        }
        return true;
    }

    static boolean isPalindromeOp(ListNode head) {
        //Finding the middle element
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = reverseLL(slow.next);
        ListNode rev = slow.next;
        ListNode temp = head;
        while (rev != null) {
            if (rev.val != temp.val) {
                return false;
            }
            rev = rev.next;
            temp = temp.next;
        }
        return true;
    }

    static ListNode reverseLL(ListNode rev) {
        if (rev == null || rev.next == null) {
            return rev;
        }
        ListNode back = null;
        ListNode next = null;
        while (rev != null) {
            next = rev.next;
            rev.next = back;
            back = rev;
            rev = next;
        }
        return back;
    }
}
