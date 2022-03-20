package ProblemSolving;

import ProblemSolving.ReverseLinkedList.ListNode;

import java.util.HashMap;
import java.util.Map;

public class CycleEntryPointInLL {


    /**Using Hash Table to store the ListNodes and if a cycle exists we return the already
     * existing entry which is bound to be the head**/
     class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode temp = head;
            Map<ListNode,ListNode> mp = new HashMap<>();
            while(temp!=null){
                if(mp.containsKey(temp)){
                    return mp.get(temp);
                }
                mp.put(temp,temp);
                temp = temp.next;
            }
            return null;
        }
    }
    /**
     * Using slow and fast pointer method to find if the cycle exits
     * using another pointer to check if the slow pointer is entry point or not
     **/
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode en = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                while (slow != en) {
                    en = en.next;
                    slow = slow.next;
                }
                return en;
            }
        }
        return null;
    }
}
