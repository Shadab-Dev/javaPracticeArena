// Given 2 String s1 = "abcd" and s2 = "bcda", check if s2 is a rotated version of s1.
package com.java.Strings;

public class StringRotations {
    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "bcda";
        boolean isRotated = checkForRotation(s1, s2);
        System.out.println(isRotated);
    }

    private static boolean checkForRotation(String s1, String s2) {
        // The idea is to concatenate s1 twice so that we create a circular version of s1 and then do naive pattern search
        s1 = s1 + s1;
        for (int i = 0; i < s1.length() - s2.length() + 1; i++) {
            int j = 0;
            if(s1.charAt(i) == s2.charAt(j)) {
                for (j = 1; j < s2.length(); j++) {
                    if(s1.charAt(i+j) != s2.charAt(j)) break;
                }
                if(j == s2.length()) return true;
            }
        }
        return false;
    }
}
