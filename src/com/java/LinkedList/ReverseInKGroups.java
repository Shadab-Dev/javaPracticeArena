package com.java.LinkedList;

public class ReverseInKGroups {
    public static void main(String[] args) {
        LinkedList list = new LinkedList(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.head = reverseKGroupRecursive(list.head, 2);
        list.print();
    }

    public static ListNode reverseKGroupRecursive(ListNode head, int k) {
        if(head == null || head.next == null || k <= 1) return head;
        // The first step is to calculate the size
        // We use the size to check the remaining nodes in the current recursive stack, if the size is smaller than k, we don't reverse
        int size = 0;
        ListNode pointer  = head;
        while (pointer!=null) {
            pointer = pointer.next;
            size++;
        }
        if(size < k) return head;

        // If there are sufficient nodes, we reverse using the recursive reverse logic
        int count = k;
        ListNode curr = head, prev = null;
        while (count > 0 && curr!=null) {
            ListNode temp = curr;
            curr = curr.next;
            temp.next = prev;
            prev = temp;
            count--;
        }
        head.next = reverseKGroupRecursive(curr, k);
        return prev;
    }

//    public static ListNode reverseKGroup(ListNode head, int k) {
//        // Calculate the total size of the linked list
//        int size = 0;
//        ListNode pointer = head;
//        while (pointer!=null) {
//            pointer = pointer.next;
//            size++;
//        }
//
//        ListNode start = new ListNode(0);
//        start.next = head;
//        ListNode prev = start, curr = head;
//        while (size >= k) {
//            ListNode currentHead = curr;
//            System.out.println(currentHead.toString());
//            int count = k;
//            while (count > 0 && curr!=null) {
//                ListNode temp = curr;
//                curr = curr.next;
//                temp.next = prev;
//                prev = temp;
//            }
//            if(curr!=null) currentHead.next = curr;
//            size = size - k;
//        }
//        return start.next;
//    }
}
