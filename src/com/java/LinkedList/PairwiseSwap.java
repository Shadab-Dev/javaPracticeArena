package com.java.LinkedList;

public class PairwiseSwap {
    public static void main(String[] args) {
        LinkedList list = new LinkedList(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.head = swapPairs(list.head);
        list.print();
    }

    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode start = new ListNode(0);
        ListNode curr = head;
        ListNode prev = start;
        while (curr != null && curr.next != null) {
            ListNode temp = curr.next.next;
            prev.next = curr.next;
            curr.next.next = curr;
            curr.next = temp;
            prev = curr;
            curr = temp;
        }
        return start.next;
    }
}
