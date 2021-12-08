// Given an array = {18, 19, 24, 15, 16}, find the minimum element at each index using a stack
package com.java.Stack;

public class MinElemUsingConstantSpace {
    static Stack st = new Stack();

    public static void main(String[] args) {
        st.push(5);
        st.push(2);
        st.push(1);
        st.print();
        System.out.println("Min: " + st.getMin());
        st.pop();
        st.print();
        System.out.println("Min: " + st.getMin());
        st.pop();
        st.print();
    }
}
