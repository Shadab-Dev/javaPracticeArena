// For an improved version, we would need a pattern which is always distinct.
// Since the pattern is distinct, we can be sure that the search pattern once matched cannot be repeated
// we use this idea to replace the i++ in the outer loop with a modified iteration
// where we start after the segment which has already been match
package com.java.Strings;

public class ImprovedNaivePatternSearch {
    public static void main(String[] args) {
        String text = "abcabcd";
        String pattern = "ca";
        findPatternInText(text, pattern);
    }

    private static void findPatternInText(String text, String pattern) {
        // we are subtracting pattern length from text because a partial completed pattern will anyways be of no use
        for (int i = 0; i < text.length() - pattern.length() + 1; ) {
            int j;
            for (j = 0; j < pattern.length(); j++) {
                if(text.charAt(i + j) != pattern.charAt(j)) break;
            }
            if(j == pattern.length()) System.out.print(i + " ");

            // if the first char didn't match then we use i++ to avoid infinite loop
            if(j==0) i++;
            // else we add j to i to make this algo linear
            else i = i + j;
        }
    }
}
