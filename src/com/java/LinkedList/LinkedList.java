package com.java.LinkedList;

public class LinkedList {
    ListNode head;
    public LinkedList(int x) {
        head = new ListNode(x);
    }

    public void add(int x) {
        if(head == null) {
            head = new ListNode(x);
        }else{
            ListNode pointer = head;
            while (pointer.next != null) pointer = pointer.next;
            ListNode n = new ListNode(x);
            pointer.next = n;
        }
    }

    public void addNode(ListNode node) {
        if(head == null) {
            head = node;
        }else{
            ListNode pointer = head;
            while (pointer.next != null) pointer = pointer.next;
            pointer.next = node;
        }
    }

    public void print() {
        ListNode pointer = head;
        while (pointer!=null) {
            System.out.print(pointer.val + " ");
            pointer = pointer.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    public ListNode(int val) {this.val = val;}
}
