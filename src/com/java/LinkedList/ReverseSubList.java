// Given the head of a singly linked list and two integers left and right where left <= right,
// reverse the nodes of the list from position left to position right, and return the reversed list.
// Input: head = [1,2,3,4,5], left = 2, right = 4
// Output: [1,4,3,2,5]
package com.java.LinkedList;

public class ReverseSubList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList(3); // tail prev   1 4 3 2 5
        list.add(2); // curr
//        list.add(3);
//        list.add(4);
//        list.add(5);
        list.head = reverseBetween(list.head, 1, 1);
        list.print();
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
        dummy.next = head;
        ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing
        for(int i = 0; i<left-1; i++) pre = pre.next;

        ListNode start = pre.next; // a pointer to the beginning of a sub-list that will be reversed
        ListNode then = start.next; // a pointer to a node that will be reversed

        // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
        // dummy-> 1 -> 2 -> 3 -> 4 -> 5

        for(int i=0; i<right-left; i++)
        {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }

        // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
        // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)

        return dummy.next;
    }

    public static ListNode reverseRecursively(ListNode head, ListNode tail) {
        if(tail == null) return head;
        ListNode nextTail = tail.next;
        tail.next = head;
        return reverseRecursively(tail, nextTail);
    }
}
