
package com.practice;

public class Test {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {
        Test t = new Test();
        Node list = new Node(7);
        list.next = new Node(13);
        list.next.next = new Node(11);
        list.next.next.next = new Node(10);
        list.next.next.next.next = new Node(1);
        t.print(t.copyRandomList(list));
    }

    public Node copyRandomList(Node head) {
        if(head == null) return null;
        // first add duplicate nodes in between
        Node ptr = head;
        while (ptr != null) {
            Node temp = new Node(ptr.val);
            Node next = ptr.next;
            ptr.next = temp;
            temp.next = next;
            ptr = next;
        }
        // Now copy the random pointers
        Node lead = head.next;
        Node trail = head;
        while (lead != null && lead.next != null) {
            lead.random = trail.random;
            lead = lead.next.next;
            trail = trail.next.next;
        }
        // Remove the duplicate nodes into a separate list
        Node newHead = head.next;
        lead = head.next;
        trail = head;
        while (lead != null){
            trail.next = lead.next;
            trail = trail.next;
            if(lead.next != null) lead.next = lead.next.next;
            lead = lead.next;
        }
        return newHead;
    }


    private void print(ListNode ptr) {
        while (ptr!=null) {
            System.out.print(ptr.val + " -> ");
            ptr = ptr.next;
        }
        System.out.println("");
    }

    private void print(Node ptr) {
        while (ptr!=null) {
            System.out.print(ptr.val + " -> ");
            ptr = ptr.next;
        }
        System.out.println("");
    }



}