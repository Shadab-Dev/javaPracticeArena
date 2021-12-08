// Evaluate the value of an arithmetic expression in Reverse Polish Notation.
// Valid operators are +, -, *, and /. Each operand may be an integer or another expression.
package com.java.Stack;

import java.util.Stack;

public class PostfixEvaluation {

    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        int result = evalRPN(tokens);
        System.out.println(result);
    }

    public static int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<>();
        String op1, op2;
        for (int i = 0; i < tokens.length; i++) {
            switch (tokens[i]) {
                case "+":
                    op1 = st.pop();
                    op2 = st.pop();
                    st.push((Integer.parseInt(op2) + Integer.parseInt(op1) + ""));
                    break;
                case "-":
                    op1 = st.pop();
                    op2 = st.pop();
                    st.push((Integer.parseInt(op2) - Integer.parseInt(op1) + ""));
                    break;
                case "*":
                    op1 = st.pop();
                    op2 = st.pop();
                    st.push((Integer.parseInt(op2) * Integer.parseInt(op1) + ""));
                    break;
                case "/":
                    op1 = st.pop();
                    op2 = st.pop();
                    st.push((Integer.parseInt(op2) / Integer.parseInt(op1) + ""));
                    break;
                default: st.push(tokens[i]);
            }
            System.out.println(st);
        }
        return Integer.parseInt(st.pop());
    }
}
