// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
// Input: s = "()[]{}"
// Output: true
package com.java.Stack;

import java.util.Stack;

public class BalanceParenthesis {
    public static void main(String[] args) {
        String brackets = "[]}}";
        System.out.println(isValid(brackets));
    }

    private static boolean isValid(String brackets) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < brackets.length(); i++) {
            if(brackets.charAt(i) == '{' || brackets.charAt(i) == '[' || brackets.charAt(i) == '(')
                stack.push(brackets.charAt(i));
            else {
                if(stack.isEmpty()) return false;
                char top = stack.pop();
                if(brackets.charAt(i) == '}' && top != '{') return false;
                else if (brackets.charAt(i) == ')' && top != '(') return false;
                else if (brackets.charAt(i) == ']' && top != '[') return false;
            }
        }
        if(stack.isEmpty()) return true;
        return false;
    }
}
