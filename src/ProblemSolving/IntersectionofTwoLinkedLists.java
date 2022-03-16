package ProblemSolving;

import ProblemSolving.ReverseLinkedList.ListNode;

import java.util.HashMap;

public class IntersectionofTwoLinkedLists {
    public static void main(String[] args) {

    }

    //Bruteforce Solution Using O(N*N) time complexity
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp = headA;
        ListNode temp2;
        while (temp != null) {
            temp2 = headB;
            while (temp2 != null) {
                if (temp2 == temp) {
                    return temp;
                }
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        return null;
    }

    //Using Maps to store the listnodes as key and the numbers as values, then checking if the map already has the key
    //or not
    public ListNode getIntersectionNodeBetter(ListNode headA, ListNode headB) {
        HashMap<ListNode, Integer> hmap = new HashMap<>();
        while (headA != null) {
            hmap.put(headA, headA.val);
            headA = headA.next;
        }
        while (headB != null) {
            if (hmap.containsKey(headB)) {
                return headB;
            } else {
                hmap.put(headB, headB.val);
                headB = headB.next;
            }
        }
        return null;
    }
    //Using the property of difference between the two nodes'(if intersecting) length to find the
    //intersection point

    public ListNode getIntersectionNodeBest(ListNode headA, ListNode headB) {
        ListNode h1 = headA;
        ListNode h2 = headB;
        while(h1!=h2){
            if(h1==null){
                h1 = headB;
            }else{
                h1 = h1.next;
            }
            if(h2==null){
                h2 = headA;
            }else{
                h2 = h2.next;
            }
        }
        return h1;
    }
}

