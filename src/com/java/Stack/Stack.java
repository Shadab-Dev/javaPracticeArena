package com.java.Stack;

import java.util.ArrayList;
import java.util.List;

public class Stack {
    private int top;
    private List<Integer> arr;

    public Stack() {
        arr = new ArrayList<>();
        top = -1;
    }

    public Stack(List<Integer> stack) {
        arr = stack;
        top = arr.size()-1;
    }

    public void push(int element) {
        arr.add(++top, element);
    }

    public int pop() {
        return arr.remove(top--);
    }

    public void print() {
        System.out.println("Stack: " + arr);
        System.out.println("Top Index: " + top + ", Top Element: " + arr.get(top));
    }

    public int peek() {
        return arr.get(top);
    }
}
