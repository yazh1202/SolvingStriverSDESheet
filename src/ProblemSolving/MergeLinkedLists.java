package ProblemSolving;

import ProblemSolving.ReverseLinkedList.ListNode;

public class MergeLinkedLists {
    //Using extra space for creating a new linked list tc->O(n1+n2) sc->O(n1+n2)
    public ListNode mergeTwoListsExtraSpace(ListNode h1, ListNode h2) {
        ListNode temp = new ListNode(0,null);
        ListNode res = temp;
        while(h1!=null&&h2!=null){
            if(h1.val<h2.val){
                temp.next = new ListNode(h1.val,null);
                temp = temp.next;
                h1 = h1.next;
            }else{
                temp.next = new ListNode(h2.val,null);
                temp = temp.next;
                h2 = h2.next;
            }
        }
        while(h1!=null){
            temp.next = new ListNode(h1.val,null);
            temp = temp.next;
            h1 = h1.next;
        }
        while(h2!=null){
            temp.next = new ListNode(h2.val,null);
            temp = temp.next;
            h2 = h2.next;
        }
        return res.next;
    }
    //Not using extra space and just joining the linked list according to their values
    public ListNode mergeTwoLists(ListNode h1, ListNode h2) {
        if(h1==null){
            return h2;
        }
        if(h2==null){
            return h1;
        }
        if(h1.val>h2.val){
            ListNode temp = h1;
            h1 = h2;
            h2 = temp;
        }
        ListNode res = h1;
        while(h1!=null&&h2!=null){
            ListNode temp = null;
            while(h1!=null&&h1.val<=h2.val){
                temp= h1;
                h1 = h1.next;
            }
            temp.next = h2;

            ListNode tmp = h1;
            h1 = h2;
            h2 = tmp;
        }

        return res;
    }
}
