package com.java.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheDesign {
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(3);
        lRUCache.put(1, 1);
        lRUCache.put(2, 2);
        lRUCache.put(3, 3);
        lRUCache.put(4, 4);
        lRUCache.get(4);
        lRUCache.get(3);
        lRUCache.get(2);
        lRUCache.get(1);
        lRUCache.put(5, 5);
        lRUCache.print();
    }

    static class LRUCache {
        private Map<Integer,Node> map;
        private Node head, tail;
        private int capacity, count;

        public LRUCache(int capacity) {
            map = new HashMap<>();
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.pre = head;
            this.capacity = capacity;
        }

        public void put(int key, int value) {
            Node result = map.get(key);
            if(result == null) {
                // We get a MISS and we will need to insert this node in the front of the list
                result = new Node(key, value);
                map.put(key, result);
                insertInList(result);
            }
            // We get a HIT and we need to update the value of the node and move it to the front
            else {
                result.value = value;
                moveNodeToFront(result);
            }
        }

        public int get(int key) {
            Node result = map.get(key);
            // we get a MISS and we return -1
            if(result == null) return -1;
            // We get a HIT, and we need to move the result node to the front
            else {
                moveNodeToFront(result);
                return result.value;
            }
        }

        private void moveNodeToFront(Node result) {
            // this means the current node is already at front
            if(result.pre == head) return;
            // If tail is pointing to result node, change tail pre
            if(tail.pre == result) tail.pre = result.pre;
            // Else, move the node to the front
            result.pre.next = result.next;
            result.next.pre = result.pre;

            Node temp = head.next;
            temp.pre = result;
            head.next = result;
            result.next = temp;
            result.pre = head;
        }

        private void insertInList(Node result) {
            // We always insert at the beginning so no need to check conditions here
            Node temp = head.next;
            temp.pre = result;
            head.next = result;
            result.next = temp;
            result.pre = head;
            count++;
            // if the capacity is full, we remove element from tail
            if(count > capacity) removeTail();
        }

        private void removeTail() {
            Node removedNode = tail.pre;
            Node temp = tail.pre.pre;
            temp.next = tail;
            tail.pre = temp;
            // remove the key from map
            map.remove(removedNode.key);
            count--;
        }

        public void print() {
            Node temp = head;
            System.out.println();
            while(temp!=null) {
                int pre = (temp.pre!=null) ? temp.pre.value : -1;
                int next = (temp.next!=null) ? temp.next.value : -1;
                System.out.print("[ " + temp.key + ", " + temp.value + " Pre: "+ pre + " Next: "+ next +" ] -> ");
                temp = temp.next;
            }
            System.out.println();
//            if(head != null) System.out.println("Head: [ " + head.key + ", " + head.value + " ]");
//            else System.out.println("Head: null");
//            if(tail != null) System.out.println("Tail: [ " + tail.key + ", " + tail.value + " ]");
//            else System.out.println("Tail: null");
            System.out.println("Count: " + count);
        }

        class Node {
            int key;
            int value;
            Node pre;
            Node next;

            public Node(int key, int value)
            {
                this.key = key;
                this.value = value;
            }
        }
    }


}
