package com.java.LinkedList;

public class CycleInList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList(1);
        list.add(2);
        list.add(3);
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(5);
        n1.next = n2;
        n2.next = n1;
        list.addNode(n1);
        System.out.println(hasCycle(list.head));
    }

    public static boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) return true;
        }
        return false;
    }
}
