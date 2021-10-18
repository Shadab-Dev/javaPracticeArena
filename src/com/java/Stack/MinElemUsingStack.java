// Given an array = {18, 19, 24, 15, 16}, find the minimum element at each index using a stack
package com.java.Stack;

public class MinElemUsingStack {
    static Stack st = new Stack();
    static Stack min = new Stack();

    public static void main(String[] args) {
        int[] arr = {18, 19, 24, 15, 16};
        for(int elem : arr) {
            push(elem);
        }
        System.out.println(getMin());
    }

    static void push(int elem) {
        if(min.peek()==-1) {
            min.push(elem);
        } else if(elem < min.peek()) min.push(elem);
        st.push(elem);
    }

    static int pop() {
        if(st.peek()==-1) return -1;
        if(st.peek() == min.peek()) {
            min.pop();
            return st.pop();
        }
        return st.pop();
    }

    static int getMin() {
        return min.peek();
    }
}
