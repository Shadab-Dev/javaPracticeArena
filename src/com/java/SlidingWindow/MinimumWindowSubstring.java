// Given two strings s and t of lengths m and n respectively,
// return the minimum window substring of s such that every character in t (including duplicates) is included in the window.
// If there is no such substring, return the empty string "".
// Input: s = "ADOBECODEBANC", t = "ABC"
// Output: "BANC"
// Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
package com.java.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ab";
        String t = "cd";
        System.out.println(getMinSubstring(s, t));
    }

    private static String getMinSubstring(String s, String t) {
        // handle edge case
        if(s.equals(t)) return t;
        // return empty if the pattern is greater than the string
        if(t.length() > s.length()) return "";

        int i = 0, j = 0, count;
        boolean found = false;
        String result = s;
        Map<Character, Integer> map = new HashMap<>();
        // Fill the map with char frequency of chars of t and store the size in count var
        for (int k = 0; k < t.length(); k++) {
            if(map.containsKey(t.charAt(k))) {
                map.put(t.charAt(k), map.get(t.charAt(k))+1);
            } else map.put(t.charAt(k), 1);
        }
        count = map.size();

        while (j<s.length()) {
            if(map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), map.get(s.charAt(j))-1);
                if(map.get(s.charAt(j)) == 0) count--;
            }
            // If the count is 0, then it means we have found a candidate substring
            if(count == 0) {
                found = true;
                // the next step is to minimize this substring while maintaining the freq of each char in pattern
                while (count == 0) {
                    // we return the min substring
                    result = (result.length() < s.substring(i, j+1).length()) ? result : s.substring(i, j+1);
                    if(map.containsKey(s.charAt(i))) {
                        map.put(s.charAt(i), map.get(s.charAt(i))+1);
                        if(map.get(s.charAt(i)) > 0) count++;
                    }
                    i++;
                }
            }
            j++;
        }

        return (found) ? result : "";
    }
}
