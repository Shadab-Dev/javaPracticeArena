package com.java.LinkedList;

public class IntersectionOfList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList(6);
        list.add(7);
        list.add(8);
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = list.head;
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n4.next = n5;
        n5.next = list.head;
        ListNode result = getIntersectionNode(n1, n4);
        System.out.println(result.val);
     }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int countA = 1, countB = 1, diff;
        ListNode pA = headA, pB = headB;
        // Count the nodes in List A
        while (pA.next != null) {
            pA = pA.next; countA++;
        }
        // Count the nodes in List B
        while (pB.next != null) {
            pB = pB.next; countB++;
        }
        // calculate the diff and move pointers back to haed
        diff = Math.abs(countA - countB);
        pA = headA; pB = headB;
        // Iterate the larger list by the diff amount
        if(countA > countB) {
            for (int i = 0; i < diff; i++) pA = pA.next;
        } else {
            for (int i = 0; i < diff; i++) pB = pB.next;
        }

        while (pA != null && pB != null) {
            if(pA == pB) return pA;
            pA = pA.next;
            pB = pB.next;
        }
        return null;
    }
}
