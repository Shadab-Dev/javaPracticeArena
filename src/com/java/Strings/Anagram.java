// Check if 2 strings are anagram of each other.
// 2 Strings are considered Anagrams if the no. of occurrence of all the chars are same but the order is different
//eg: listen and silent are anagrams
package com.java.Strings;

public class Anagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("listen", "silentb"));
    }

    private static boolean isAnagram(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        int[] frequency = new int[26];
        // use ASCII conversion to store the count of a char in a char frequency array
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            int index = (int) ch - 'a';
            frequency[index]++;
        }
        // For the second string decrement the count
        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            int index = (int) ch - 'a';
            frequency[index]--;
        }
        // If both strings are anagrams the final count in all elements of the freq array should be 0
        for (int i = 0; i < frequency.length; i++) {
            if(frequency[i] != 0) return false;
        }
        return true;
    }
}
