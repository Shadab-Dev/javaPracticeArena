// Given a string you need to print the size of the longest possible substring that has exactly K unique characters.
// If there is no possible substring then print -1.
// Input:
// S = "aabacbebebe", K = 3
// Output: 7
package com.java.SlidingWindow;

public class LongestSubstringOfKChars {
    public static void main(String[] args) {
        String s = "aabbcc";
        int k = 1;
        System.out.println(findLongestSubstring(s, k));
    }

    private static int findLongestSubstring(String s, int k) {
        int i = 0, j = 0, count = 0, result = -1;
        int[] visited = new int[26];

        while(j<s.length()){
            visited[s.charAt(j) - 'a']++;
            if(visited[s.charAt(j) - 'a'] == 1) count++;
            if(count < k) j++;
            else if(count == k) {
                result = Math.max(result, j-i+1);
                j++;
            }else {
                while (count > k) {
                    if(visited[s.charAt(i) - 'a'] == 1) count--;
                    visited[s.charAt(i) - 'a']--;
                    i++;
                }
                j++;
            }
        }
        return result == 0 ? -1 : result;
    }
}
