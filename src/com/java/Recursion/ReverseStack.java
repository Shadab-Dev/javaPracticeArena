package com.java.Recursion;

import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        System.out.println(reverseStack(st));
    }

    private static Stack<Integer> reverseStack(Stack<Integer> st) {
        if(st.size() <= 1) return st;
        int curr = st.pop();
        st = reverseStack(st);
        return insertInStack(st, curr);
    }

    private static Stack<Integer> insertInStack(Stack<Integer> st, int curr) {
        if(st.isEmpty()) {
            st.push(curr);
            return st;
        }
        int elem = st.pop();
        st = insertInStack(st, curr);
        st.push(elem);
        return st;
    }
}
