package com.java.Stack;

public class Test {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.print();
        stack.push(2);
        stack.print();
        stack.push(3);
        stack.print();
        stack.pop();
        stack.print();
    }
}
