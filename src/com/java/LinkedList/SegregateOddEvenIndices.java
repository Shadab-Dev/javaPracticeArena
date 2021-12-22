package com.java.LinkedList;

public class SegregateOddEvenIndices {
    public static void main(String[] args) {
        LinkedList list = new LinkedList(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.head = oddEvenList(list.head);
        list.print();
    }

    public static ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode curr = head, oddHead = null, odd = null, evenHead = null, even = null;
        int count = 1;
        while (curr != null) {
            if(count % 2 == 0) {
                if(evenHead == null) {
                    evenHead = curr;
                    even = curr;
                } else {
                    even.next = curr;
                    even = even.next;
                }
            } else {
                if(oddHead == null) {
                    oddHead = curr;
                    odd = curr;
                } else {
                    odd.next = curr;
                    odd = odd.next;
                }
            }
            curr = curr.next;
            count++;
        }

        if(evenHead == null) return oddHead;
        even.next = null;
        odd.next = evenHead;
        return oddHead;
    }
}
