package com.java.Recursion;

import java.util.HashSet;
import java.util.Set;

public class PermutionsOfAString {
    public static void main(String[] args) {
        printPermutations("ABC");
    }

    private static void printPermutations(String s) {
        Set<String> set = new HashSet<>();
        helper(s, set, 0);
        System.out.println(set);
    }

    private static void helper(String input, Set<String> set, int index) {
        if(index == input.length()) return;
        for (int i = index; i < input.length(); i++) {
            input = swap(input, i, index);
            System.out.println(input);
            helper(input, set, index+1);
        }
    }

    public static String swap(String input, int i, int j) {
        char[] arr = input.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return String.valueOf(arr);
    }
}
