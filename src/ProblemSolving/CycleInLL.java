package ProblemSolving;

import ProblemSolving.ReverseLinkedList.ListNode;

import java.util.HashMap;

public class CycleInLL {

    //Using fast and slow pointer method having O()
    public boolean hasCycleFSMethod(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    //Hash Table to check if it already contains the listnode
    public boolean hasCycleHashMethod(ListNode head) {
        HashMap<ListNode, Integer> hm = new HashMap<>();
        while (head != null) {
            if (hm.containsKey(head)) {
                return true;
            }
            hm.put(head, head.val);
            head = head.next;
        }
        return false;
    }
}


