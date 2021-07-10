package com.java;

class ListNode {
    private int value;
    private ListNode next;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}

public class Linkedlist {
    private ListNode head;

    public ListNode getHead() {
        return head;
    }

    public void setHead(ListNode head) {
        this.head = head;
    }

    public Linkedlist(int value) {
        ListNode listNode = new ListNode();
        listNode.setValue(value);
        listNode.setNext(null);
        this.head = listNode;
    }

    public void add(int value) {
        ListNode listNode = new ListNode();
        listNode.setValue(value);

        if(this.head == null) {
            listNode.setNext(null);
            this.head = listNode;
        } else {
            ListNode pointer = this.head;
            while(pointer.getNext() != null) {
                pointer = pointer.getNext();
            }
            pointer.setNext(listNode);
        }
    }

    public void print() {
        ListNode pointer = this.head;
        while(pointer != null) {
            System.out.print(pointer.getValue() + "-->");
            pointer = pointer.getNext();
        }
    }

    public void removeByValue(int value) {
        ListNode pointer = this.head;
        // Delete the nodes from initial part of list
        while(pointer.getValue() == value) {
            pointer = pointer.getNext();
        }
        if(pointer!=this.head) this.head = pointer;

        while(pointer != null) {
            if(pointer.getNext() != null && pointer.getNext().getValue() == value) {
                pointer.setNext(pointer.getNext().getNext());
            } else {
                pointer = pointer.getNext();
            }
        }

    }

    // https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/553/
    public void removeWithoutHead(ListNode toDelete) {
        if(toDelete == null || toDelete.getNext() == null) return;
        toDelete.setValue(toDelete.getNext().getValue());
        toDelete.setNext(toDelete.getNext().getNext());
    }

    public ListNode removeNthFromEnd(int n) {
        ListNode proceedingPointer = this.head;
        ListNode tailingPointer = this.head;
        int counter = 0;
        while(proceedingPointer.getNext()!=null) {
            proceedingPointer = proceedingPointer.getNext();
            if(counter == n) {
                tailingPointer = tailingPointer.getNext();
            } else {
                counter++;
            }
        }
        ListNode removedNode = tailingPointer.getNext();
        tailingPointer.setNext(tailingPointer.getNext().getNext());
        return removedNode;
    }

    public ListNode reverseList(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = p1;
        ListNode p3 = p2;
        while(p1!=null) {
            p3=p2;
            p2=p1;
            p1=p1.getNext();
            if(p2!=head) {
                p2.setNext(p3);
                if(p3==head) {
                    p3.setNext(null);
                }
            }
        }
        head = p2;
        return head;
    }

    public ListNode reverseListRecursion(ListNode head, ListNode p1, ListNode p2) {
        if(p1==null) return p2;
        ListNode p3=p2;
        p2=p1;
        p1=p1.getNext();
        if(p2!=head) {
            p2.setNext(p3);
            if(p3==head) {
                p3.setNext(null);
            }
        }
        return reverseListRecursion(head, p1, p2);
    }
}
