package com.java.Recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(result, "(" , n-1, n);
        return result;
    }

    public static void helper(List<String> result, String output, int open, int close) {
        if(open > close) return;
        if(open == 0 && close ==0) {
            result.add(output);
            return;
        }
        if(open != 0) helper(result, output+"(", open-1, close);
        if(close != 0) helper(result, output+")", open, close-1);
    }
}
