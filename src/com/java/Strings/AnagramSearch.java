// given a String and a pattern, return an array which gives the starting location of anagrams from that string
package com.java.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnagramSearch {
    private static final int SIZE = 26;
    public static void main(String[] args) {
        String s = "geeksforgeeks";
        String pattern = "frog";
        System.out.println(findOccurrenceOfAnagram(s, pattern));
    }

    private static List<Integer> findOccurrenceOfAnagram(String s, String pattern) {
        List<Integer> result = new ArrayList<>();
        if(pattern.length() > s.length()) return result;

        // create a frequency array of for pattern as well as for the string
        int[] freq_pattern = new int[SIZE];
        int[] freq_s = new int[SIZE];
        for (int i = 0; i < pattern.length(); i++) {
            freq_pattern[pattern.charAt(i) - 'a']++;
            // prefill the freq_string with the first window frequency
            freq_s[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length() - pattern.length() + 1; i++) {
            // check if frequencies of both are equal, if yes then we have found an anagram at current index
            if(Arrays.equals(freq_pattern, freq_s)) result.add(i);
            // use the sliding window technique and remove the left char freq
            // and add the right char freq to update the window
            if(i + pattern.length() < s.length()) {
                freq_s[s.charAt(i + pattern.length()) - 'a']++;
                freq_s[s.charAt(i) - 'a']--;
            }
        }
        return result;
    }
}
