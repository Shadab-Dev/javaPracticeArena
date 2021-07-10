package com.java;

import java.util.Stack;

public class BalancedParenthesis {
    public static void main(String[] args) {
        String parenthesis = "({[[()]]})";
        boolean isBalanced = checkParenthesis(parenthesis);
        System.out.println(isBalanced);
    }

    private static boolean checkParenthesis(String parenthesis) {
        Stack<Character> charStack = new Stack<>();
        for (int i = 0; i < parenthesis.length(); i++) {
            if(parenthesis.charAt(i) == '{' || parenthesis.charAt(i) == '[' || parenthesis.charAt(i) == '(') {
                charStack.push(parenthesis.charAt(i));
            } else {
                char element = charStack.pop();
                switch (element) {
                    case '{': if(parenthesis.charAt(i) != '}') return false; else break;
                    case '(': if(parenthesis.charAt(i) != ')') return false; else break;
                    case '[': if(parenthesis.charAt(i) != ']') return false; else break;
                    default: break;
                }
            }
        }
        if(!charStack.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
}
