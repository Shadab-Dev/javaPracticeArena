package com.java.Recursion;

import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(41);
        st.push(3);
        st.push(32);
        st.push(2);
        st.push(11);
        System.out.println(sort(st));
    }

    public static Stack<Integer> sort(Stack<Integer> s) {
       if(s.size() <= 1) return s;
       int curr = s.pop();
       s = sort(s);
       return insertToStack(s, curr);
    }

    private static Stack<Integer> insertToStack(Stack<Integer> s, int elem) {
        if(s.size() == 0 || s.peek() < elem) {
            s.push(elem);
            return s;
        }
        int curr = s.pop();
        s = insertToStack(s, elem);
        s.push(curr);
        return s;
    }
}
