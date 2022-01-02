// Given a String "AB", find all the subsets of this string
// Ans = "", "A", "B", "AB" = 4
package com.java.Recursion;

public class SubsetsOfString {
    public static void main(String[] args) {
        String s = "AB";
        findSubsets(s, "");
    }

    private static void findSubsets(String input, String output) {
        // If the input is empty, then we are at the leaf node of the recursive tree
        if(input.isEmpty()){
            System.out.println("'" + output + "'");
            return;
        }
        // We need to create 2 outputs, 1 where we take the first index of the input,
        String op1 = output + input.charAt(0);
        // and 1 where we keep the output exactly same as previous
        String op2 = output;
        // now we call the recursive method with smaller input (removing the 1st index char)
        input = input.substring(1);
        findSubsets(input, op2);
        findSubsets(input, op1);
    }
}
