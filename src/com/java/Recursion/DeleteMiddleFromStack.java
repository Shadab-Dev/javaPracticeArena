package com.java.Recursion;

import java.util.Stack;

public class DeleteMiddleFromStack {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        System.out.println(deleteMiddle(st));
    }

    private static Stack<Integer> deleteMiddle(Stack<Integer> st) {
        int k = st.size()/2 + 1;
        return helper(st, k);
    }

    private static Stack<Integer> helper(Stack<Integer> st, int k) {
        if(st.size() == 0) return st;
        if(k == 1) {
            st.pop();
            return st;
        }
        int curr = st.pop();
        st = helper(st, k-1);
        st.push(curr);
        return st;
    }
}
