// Given a String "ABCD" and "AB" check whether s2 is a subsequence of s1.
// The difference between subarray and subsequence is that subarray is contiguous whereas subsequence is not contiguous but both are ordered
package com.java.Strings;

public class Subsequence {
    public static void main(String[] args) {
        System.out.println(isSubSequence("ABCD", "ABDC"));
    }

    private static boolean isSubSequence(String s1, String s2) {
        if(s2.equals("")) return true;
        int index = 0;
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) == s2.charAt(index)) index++;
            if(index == s2.length()) return true;
        }
        return false;
    }
}
