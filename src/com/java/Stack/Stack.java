package com.java.Stack;

import java.util.ArrayList;
import java.util.List;

public class Stack {
    private int top;
    private int min;
    private List<Integer> arr;

    public Stack() {
        arr = new ArrayList<>();
        top = -1;
        min = 0;
    }

    public Stack(List<Integer> stack) {
        arr = stack;
        top = arr.size()-1;
    }

    public void push(int element) {
        if(top == -1) min = element;
        else if(element < min) {
            int temp = element;
            element = 2 * element - min;
            min = temp;
        }
        arr.add(++top, element);
    }

    public int pop() {
        if(arr.get(top) < min) {
            int temp = min;
            min = 2 * min - arr.get(top);
            arr.remove(top--);
            return temp;
        } else return arr.remove(top--);
    }

    public int peek() {
        if(top == -1) return -1;
        if(arr.get(top) < min) return min;
        return arr.get(top);
    }

    public int get(int index) {
        return arr.get(index);
    }

    public int getMin() {
        return min;
    }

    public void print() {
        System.out.println("Stack: " + arr);
        System.out.println("Top Index: " + top + ", Top Element: " + this.peek());
    }

    public void leanPrint() {
        System.out.println(arr);
    }
}
