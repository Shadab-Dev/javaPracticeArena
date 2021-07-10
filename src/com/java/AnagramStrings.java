package com.java;

import java.util.*;

public class AnagramStrings {

    public static void main(String[] args) {
        String str1 = "aabcc";
        String str2 = "ccaab";
        boolean isAnagram = checkIfAnagram(str1, str2);
    }

    private static boolean checkIfAnagram(String str1, String str2) {
        if(str1.length() != str2.length()) return false;

        boolean isAnagram = false;
        // for each element in str2 make an array which stores whether element in that index has already been visited
        boolean[] boolArr = new boolean[str2.length()];
        for (int i = 0; i < str2.length(); i++) {
            boolArr[i] = false;
        }
        for (int i = 0; i < str1.length(); i++) {
            isAnagram = false;
            for (int j = 0; j < str2.length(); j++) {
                if(str1.charAt(i) == str2.charAt(j) && (!boolArr[j])) {
                    isAnagram = true;
                    boolArr[j] = true;
                    break;
                }
            }
            System.out.println(Arrays.asList());
        }
        return isAnagram;
    }
}
