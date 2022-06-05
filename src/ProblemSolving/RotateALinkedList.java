package ProblemSolving;

import ProblemSolving.ReverseLinkedList.ListNode;

import java.util.HashMap;

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
/*BruteForce Approach :- Make all the rotations and then return head of the Linked List
* */


/*Using the two pointer method and swapping to get the linked list and
 * also trying to make it less iterative by reducing the number of iterations
 * by counting the number of iterations to actually take(1)*/
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode i = head;
        ListNode j = head;
        //FailSafe

        if (j == null || j.next == null) {
            return j;
        }
        int len = 0;
        ListNode temp1 = head;
        //Calculating the length of the LL
        while (temp1 != null) {
            len++;
            temp1 = temp1.next;
        }
        /*After number of iterations reach length the original linked list is obtained
         * so we only do the number of iterations that are required*/
        if (k > len) {
            k = k % len;
        }
        for (int m = 0; m < k; m++) {
            while (j.next != null && j.next.next != null) {
                j = j.next;
            }
            ListNode temp = j.next;
            j.next = null;
            temp.next = i;
            i = temp;
            j = i;
        }
        HashMap<Integer,Integer> hm = new HashMap<>();
        return i;
    }
}
