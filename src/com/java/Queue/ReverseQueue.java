package com.java.Queue;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;

public class ReverseQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        reverse(queue);
        System.out.println(queue);
    }

    private static void reverse(Queue<Integer> queue) {
        if(queue.isEmpty()) return;
        int element = queue.remove();
        reverse(queue);
        queue.add(element);
    }
}
