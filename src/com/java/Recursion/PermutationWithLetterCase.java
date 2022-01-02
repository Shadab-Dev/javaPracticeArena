package com.java.Recursion;

import java.util.ArrayList;
import java.util.List;

public class PermutationWithLetterCase {
    public static void main(String[] args) {
        System.out.println(letterCasePermutation("a1b2"));
    }

    public static List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        helper(s, "", result);
        return result;
    }

    public static void helper(String input, String output, List<String> result) {
        if(input.isEmpty()) {
            result.add(output);
            return;
        }
        String curr = input.charAt(0) + "";
        try{
            Integer.parseInt(curr);
            helper(input.substring(1), output+curr, result);

        } catch (Exception ex) {
            String op1 = output + curr.toLowerCase();
            String op2 = output + curr.toUpperCase();
            helper(input.substring(1), op1, result);
            helper(input.substring(1), op2, result);
        }
    }
}
