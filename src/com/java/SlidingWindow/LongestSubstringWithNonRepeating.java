// Given a string s, find the length of the longest substring without repeating characters.
// Input: s = "abcabcbb"
// Output: 3
package com.java.SlidingWindow;

import java.util.HashMap;

public class LongestSubstringWithNonRepeating {
    public static void main(String[] args) {
        String s = "tmmzuxt";
        System.out.println(findLongestSubstring(s));
    }

    private static int findLongestSubstring(String s) {
        if(s.isEmpty()) return 0;
        int i = 0, j = 0, result = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (j<s.length()) {
            // insert character into map if the elem does not exist
            if(!map.containsKey(s.charAt(j))) map.put(s.charAt(j), 1);
            // if it exists then update the count by 1
            else map.put(s.charAt(j), map.get(s.charAt(i))+1);

            if(map.get(s.charAt(j)) == 1)  result = Math.max(result, j-i+1);
            else {
                while (map.get(s.charAt(j)) != 1) {
                    // keep decreasing count of ith element by 1
                    map.put(s.charAt(i), map.get(s.charAt(i))-1);
                    // if the count is 0 then remove the key from the map
                    if(map.get(s.charAt(i)) == 0) map.remove(s.charAt(i));
                    i++;
                }
            }
            j++;
        }
        return result;
    }
}
