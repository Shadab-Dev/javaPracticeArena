package com.java.LinkedList;

public class Reverse {
    public static void main(String[] args) {
        LinkedList list = new LinkedList(1);
        list.add(2);
//        list.head = reverseList(list.head);
        list.head = reverseRecursively(null, list.head);
        list.print();
    }

    public static ListNode reverseList(ListNode head) {
        ListNode slow, mid = null;
        ListNode fast = head;
        while (fast != null) {
            slow = mid;
            mid = fast;
            fast = fast.next;
            mid.next = slow;
        }
        return mid;
    }

    public static ListNode reverseRecursively(ListNode head, ListNode tail) {
        if(tail == null) return head;
        ListNode nextTail = tail.next;
        tail.next = head;
        return reverseRecursively(tail, nextTail);
    }
}
