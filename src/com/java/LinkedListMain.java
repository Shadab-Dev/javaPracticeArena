// http://www.ardendertat.com/2011/09/29/programming-interview-questions-5-linkedlist-remove-nodes/
package com.java;

public class LinkedListMain {
    public static void main(String[] args) {
        Linkedlist list = new Linkedlist(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
//        list.add(6);
//        list.add(7);
//        list.add(8);
//        list.add(9);
//        list.add(10);
        list.print();
        ListNode reversedHead = list.reverseListRecursion(list.getHead(), list.getHead(), list.getHead());
        list.setHead(reversedHead);
        System.out.println();
        list.print();

    }
}
