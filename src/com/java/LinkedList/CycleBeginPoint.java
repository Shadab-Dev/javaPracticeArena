package com.java.LinkedList;

public class CycleBeginPoint {
    public static void main(String[] args) {
        LinkedList list = new LinkedList(1);
        list.add(2);
        list.add(3);
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(5);
        n1.next = n2;
        n2.next = n1;
        list.addNode(n1);
        ListNode result = detectCycle(list.head);
        System.out.println(result.val);
    }

    public static ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        boolean hasCycle = false;
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) {
                hasCycle = true;
                break;
            }
        }
        if(!hasCycle) return null;
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
