package com.java.LinkedList;

public class CycleRemove {
    public static void main(String[] args) {
        LinkedList list = new LinkedList(1);
        list.add(2);
        list.add(3);
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(5);
        n1.next = n2;
        n2.next = n1;
        list.addNode(n1);
        removeLoop(list.head);
        list.print();
    }


    public static void removeLoop(ListNode head){
        if(head == null || head.next == null) return;
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
        if(!hasCycle) return;
        fast = head;
        while (fast.next != slow.next) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = null;
    }
}
