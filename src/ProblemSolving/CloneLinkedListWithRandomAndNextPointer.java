package ProblemSolving;

import java.util.HashMap;

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

//Bruteforce using hashmaps to store indexes of new and old LL and random nodes of them.
public class CloneLinkedListWithRandomAndNextPointer {
    public Node copyRandomListBrute1(Node head) {
        Node thead = head;
        Node res = new Node(-1);
        Node temp = null;
        HashMap<Node, Integer> hmo = new HashMap<>();
        HashMap<Node, Node> hms = new HashMap<>();
        HashMap<Integer, Node> hmn = new HashMap<>();
        int ind = 0;
        while (thead != null) {
            if (temp == null) {
                temp = new Node(thead.val);
                res.next = temp;
            } else {
                temp.next = new Node(thead.val);
                temp = temp.next;
            }
            ind++;
            hmo.put(thead, ind);
            hmn.put(ind, temp);
            thead = thead.next;
        }
        thead = head;
        while (thead != null) {
            hms.put(thead, thead.random);
            thead = thead.next;
        }
        Node n = res.next;
        Node o = head;
        while (n != null) {
            n.random = hmn.get(hmo.get(hms.get(o)));
            n = n.next;
            o = o.next;
        }
        return res.next;
    }

    //Another Bruteforce method of finding the random for new LL using the random for old LL
    public Node copyRandomListBrute2(Node head) {
        Node thead = head;
        Node res = new Node(-1);
        Node temp = null;
        int ind = 0;
        while (thead != null) {
            if (temp == null) {
                temp = new Node(thead.val);
                res.next = temp;
            } else {
                temp.next = new Node(thead.val);
                temp = temp.next;
            }
            ind++;
            thead = thead.next;
        }
        thead = head;
        Node nh = res.next;
        while (thead != null) {
            Node t = head;
            Node k = res.next;
            while (t != thead.random) {
                t = t.next;
                k = k.next;
            }
            nh.random = k;
            nh = nh.next;
            thead = thead.next;
        }

        return res.next;
    }

    //Another BruteForce method using 2 hashmaps, one to store the mappings and another to store the new ll and its indexing
    public Node copyRandomListBrute3(Node head) {
        Node thead = head;
        Node res = new Node(-1);
        Node temp = null;
        HashMap<Integer, Node> hmn = new HashMap<>();
        HashMap<Node, Integer> hmo = new HashMap<>();
        int ind = 0;
        while (thead != null) {
            if (temp == null) {
                temp = new Node(thead.val);
                res.next = temp;
            } else {
                temp.next = new Node(thead.val);
                temp = temp.next;
            }
            ind++;
            hmo.put(thead, ind);
            hmn.put(ind, temp);
            thead = thead.next;
        }
        thead = head;
        Node nh = res.next;
        while (thead != null) {
            nh.random = hmn.get(hmo.get(thead.random));
            thead = thead.next;
            nh = nh.next;
        }
        return res.next;
    }

    // Using the same list and interweaving principle to save memory
    // Not creating hashmaps for getting random pointers...
    public Node copyRandomListBest(Node head) {
        Node thead = head;
        // Interweaving duplicates in the original
        while (thead != null) {
            Node t = thead.next;
            Node copy = new Node(thead.val);
            thead.next = copy;
            copy.next = t;
            thead = t;
        }
        thead = head;
        //Assigning random pointers to these duplicates
        //Using their position relative to the original linked list
        while (thead != null) {
            if (thead.random != null) {
                thead.next.random = thead.random.next;
            }
            thead = thead.next.next;
        }
        thead = head;
        //Creating a new pointer to point to the duplicated array
        Node res = new Node(0);
        Node chead = res;
        Node copy;
        //Assigning the ll back to the original
        //ll and restoring the original ll
        while (thead != null) {
            Node temp = thead.next.next;
            copy = thead.next;
            chead.next = copy;
            chead = copy;
            thead.next = temp;
            thead = temp;
        }
        return res.next;
    }
}
