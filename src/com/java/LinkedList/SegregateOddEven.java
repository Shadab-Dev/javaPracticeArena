package com.java.LinkedList;

public class SegregateOddEven {
    public static void main(String[] args) {
        LinkedList list = new LinkedList(17);
        list.add(15);
        list.add(8);
        list.add(9);
        list.add(2);
        list.add(4);
        list.add(6);
        list.head = oddEvenlist(list.head);
        list.print();
    }

    public static ListNode oddEvenlist(ListNode head) {
        ListNode curr = head, oddHead = null, odd = null, evenHead = null, even = null;
        while (curr != null) {
            if(curr.val % 2 == 0) {
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
        }
        if(oddHead == null || evenHead == null) return head;
        odd.next = null;
        even.next = oddHead;
        return evenHead;
    }
}
