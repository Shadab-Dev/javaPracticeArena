package com.java.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    public static void main(String[] args) {
        Node n1 = new Node(7);
        Node n2 = new Node(13);
        Node n3 = new Node(11);
        Node n4 = new Node(10);
        Node n5 = new Node(1);
        n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5;
        n1.random = null;
        n2.random = n1;
        n3.random = n5;
        n4.random = n3;
        n5.random = n1;
        Node result =copyRandomList(n1);
        while (result!=null) {
            System.out.println(result.val);
            System.out.println(result.random);
            System.out.println("");
            result = result.next;
        }
    }

    // We first try to explain this 2 pass extra space solution
    public static Node copyRandomListWithHashing(Node head) {
        if(head == null) return null;
        Map<Node, Node> map = new HashMap<>();
        // Add nodes to the set
        Node p1 = head;
        while(p1!=null) {
            map.put(p1, new Node(p1.val));
            p1 = p1.next;
        }

        // start creating the new list
        // we first create the head
        p1 = head;
        Node head1 = map.get(p1);
        head1.next = map.get(p1.next);
        head1.random = map.get(p1.random);
        Node temp = head1;
        temp = temp.next;
        p1 = p1.next;
        while(p1!=null) {
            temp.next = map.get(p1.next);
            temp.random = map.get(p1.random);
            temp = temp.next;
            p1 = p1.next;
        }
        return head1;
    }

    // The efficient solution has 3 passes but with constant space
    public static Node copyRandomList(Node head) {
        if(head == null) return null;
        Node newHead = new Node(head.val);
        Node p1 = head, p2 = newHead, temp;

        // In the first pass we change the wiring and include the nodes of the second list in the first
        temp = p1.next;
        p2.next = temp;
        p1.next = p2;
        p1 = temp;
        while(p1!=null) {
            p2 = new Node(p1.val);
            temp = p1.next;
            p2.next = temp;
            p1.next = p2;
            p1 = temp;
        }

        // In the second pass we copy the random pointer references from original list to the next list
        p1 = head; p2 = newHead;
        while(p1!=null && p1.next!=null) {
            p2.random = (p1.random == null) ? null : p1.random.next;
            p1 = p1.next.next;
            p2 = (p2.next == null) ? null : p2.next.next;
        }

        // In the third pass, we fix the original list
        p1 = head; p2 = newHead;
        while(p2!=null) {
            temp = p2.next;
            p1.next = temp;
            p2.next = (temp == null) ? null : temp.next;
            p1 = temp;
            p2 = (temp == null) ? null : temp.next;
        }
        return newHead;
    }

    static class Node {
        int val;
        Node next;
        Node random;
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
