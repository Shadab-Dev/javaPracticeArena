package com.java.Queue;

import java.util.Stack;

public class QueueUsingStack {
    public static void main(String[] args) {
        SQueue queue = new SQueue();
        queue.enque(1);
        queue.enque(2);
        queue.enque(3);
        System.out.println(queue.deque());
        System.out.println(queue.deque());
        System.out.println(queue.deque());
        queue.enque(1);
        System.out.println(queue.peek());
    }
}

class SQueue {
    private Stack<Integer> input;
    private Stack<Integer> output;

    public SQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }

    public void enque (int element) {
        input.push(element);
    }

    public int peek() {
        if(!output.isEmpty()) return output.peek();
        else {
            while (!input.isEmpty()) output.push(input.pop());
            return output.peek();
        }
    }

    public int deque() {
        if(!output.isEmpty()) return output.pop();
        else {
            while (!input.isEmpty()) output.push(input.pop());
            return output.pop();
        }
    }

    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}
