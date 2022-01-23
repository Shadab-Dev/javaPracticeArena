package com.java.Heap;

import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next = new ListNode(5);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next = new ListNode(4);
        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);
        MergeKSortedLists c= new MergeKSortedLists();
        ListNode result = c.mergeKLists(new ListNode[]{l1, l2, l3});
        while(result!=null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        PriorityQueue<ListNode> heap = new PriorityQueue<>();

        // Add 1st index element of each array to heap
        for(int i = 0; i<lists.length; i++) {
            ListNode curr = lists[i];
            if(curr!=null) heap.offer(curr);
        }

        // create a result ListNode
        ListNode root = new ListNode();
        ListNode curr = root;
        // start popping from the heap
        while(!heap.isEmpty()) {
            ListNode temp = heap.poll();
            curr = insert(temp.val, curr);
            if(temp.next!=null) heap.offer(temp.next);
        }

        return root.next;
    }

    public ListNode insert(int val, ListNode root) {
        ListNode temp = new ListNode(val);
        root.next = temp;
        root = root.next;
        return root;
    }

    public class HeapNode implements Comparable<HeapNode>{
        int value;
        int index;
        ListNode ref;

        public HeapNode(int value, int index, ListNode ref) {
            this.value = value;
            this.index = index;
            this.ref = ref;
        }

        @Override
        public int compareTo(HeapNode node) {
            return Integer.compare(this.value, node.value);
        }
    }

    public static class ListNode implements Comparable<ListNode> {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      @Override
      public int compareTo(ListNode l) {
          return Integer.compare(this.val, l.val);
      }
  }
}
