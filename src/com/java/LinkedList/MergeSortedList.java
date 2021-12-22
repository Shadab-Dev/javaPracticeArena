package com.java.LinkedList;

public class MergeSortedList {
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList(1);
        list1.add(2);
        list1.add(4);
        LinkedList list2 = new LinkedList(1);
        list2.add(3);
        list2.add(4);
        list1.head = mergeTwoLists(list1.head, list2.head);
        list1.print();
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode p1 = list1, p2 = list2;
        ListNode start = new ListNode(99999);
        ListNode curr = start;
        while (p1 != null && p2 != null) {
            if(p1.val <= p2.val) {
                curr.next = p1;
                p1 = p1.next;
            } else {
                curr.next = p2;
                p2 = p2.next;
            }
            curr = curr.next;
        }

        if(p1 != null) {
            while (p1!=null) {
                curr.next = p1;
                p1 = p1.next;
                curr = curr.next;
            }
        } else if(p2 != null) {
            while (p2!=null) {
                curr.next = p2;
                p2 = p2.next;
                curr = curr.next;
            }
        }
        return start.next;
    }
}
