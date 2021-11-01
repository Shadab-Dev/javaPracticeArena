// Given a string and a pattern, find the index from where the pattern starts and ends
package com.java.Strings;

public class NaivePatternSearching {
    public static void main(String[] args) {
        String text = "aaaaa";
        String pattern = "aaa";
        findPatternInText(text, pattern);
    }

    private static void findPatternInText(String text, String pattern) {
        // we are subtracting pattern length from text because a partial completed pattern will anyways be of no use
        for (int i = 0; i < text.length() - pattern.length() + 1; i++) {
            int j;
            for (j = 0; j < pattern.length(); j++) {
                if(text.charAt(i + j) != pattern.charAt(j)) break;
            }
            if(j == pattern.length()) System.out.print(i + " ");
        }
    }
}
