// Given a string, find the first unique char from the left
// For string abeccbd, the answer should be a
package com.java.Strings;

import java.util.Arrays;

public class LeftMostNonRepeatingChar {
    private static final int SIZE = 26;
    public static void main(String[] args) {
        System.out.println(findLeftMostNonRepeatingChar("abbcbda"));
    }

    private static int findLeftMostNonRepeatingChar(String s) {
        int[] frequency = new int[SIZE];
        Arrays.fill(frequency, -1);

        // We traverse the frequency array and replace it with the index of the element if its freq is -1
        // if its not -1 then it means it has occurred before, so we mark it as -2
        for (int i = 0; i < s.length(); i++) {
            int charFreq = frequency[s.charAt(i) - 'a'];
            if(charFreq == -1) frequency[s.charAt(i) - 'a'] = i;
            else frequency[s.charAt(i) - 'a'] = -2;
        }
        int leftMost = Integer.MAX_VALUE;
        System.out.println(Arrays.toString(frequency));
        for (int i = 0; i < SIZE; i++) {
            if(frequency[i] > -1) leftMost = Math.min(leftMost, frequency[i]);
        }
        return leftMost == Integer.MAX_VALUE ? -1 : leftMost;
    }

}
