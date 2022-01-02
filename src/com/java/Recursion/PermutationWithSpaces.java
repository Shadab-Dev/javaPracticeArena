package com.java.Recursion;

public class PermutationWithSpaces {
    public static void main(String[] args) {
        printPermutatutionWithSpaces("ABC");
    }

    public static void printPermutatutionWithSpaces(String s) {
        helper(s.substring(1), s.charAt(0)+"");
    }

    public static void helper(String input, String output) {
        if(input.isEmpty()) {
            System.out.println(output);
            return;
        }
        String op1 = output + input.charAt(0);
        String op2 = output + "_" + input.charAt(0);
        helper(input.substring(1), op1);
        helper(input.substring(1), op2);
    }
}
