package ProblemSolving;

import java.util.ArrayList;
import java.util.Collections;

public class FlattenLinkedList {
    static class Node {
        Node next = null;
        Node bottom = null;
        int data;

        Node(Node next, Node bottom, int value) {
            this.next = next;
            this.bottom = bottom;
            this.data = value;
        }

        Node(int value) {
            this.data = value;
        }
    }

    //Bruteforce using storage of all values and then sorting
    static Node flattenLL(Node node) {
        ArrayList<Integer> arr = new ArrayList<>();
        while (node.next != null) {
            while (node.bottom.next != null) {
                arr.add(node.bottom.data);
                node.bottom = node.bottom.next;
            }
            node = node.next;
        }
        Collections.sort(arr);
        Node n = new Node(-1);
        Node res = n.next;
        for (Integer integer : arr) {
            n.next = new Node(integer);
        }
        return node;
    }

    Node flatten(Node root)
    {
        return getFlat(root);
    }
    //Recursive calls to keep on sorting and adding
    static Node getFlat(Node node) {
        if (node==null||node.next == null) {
            return node;
        }
        node.next =  getFlat(node.next);
        return merge(node, node.next);
    }

    //Merge logic for the Nodes
    private static Node merge(Node n1, Node n2) {
        //To temporarily store the LinkedList
        Node temp = new Node(-1);
        //To return the temporary list after it is merged
        Node res = temp;
        while(n1!=null&&n2!=null){
            if (n1.data > n2.data) {
                temp.bottom = n2;
                n2 = n2.bottom;
            } else {
                temp.bottom = n1;
                n1 = n1.bottom;
            }
            temp = temp.bottom;
        }
        //If any of the LL is missed
        if (n1 != null) {
            temp.bottom = n1;
        } else {
            temp.bottom = n2;
        }
        return res.bottom;

    }

}
