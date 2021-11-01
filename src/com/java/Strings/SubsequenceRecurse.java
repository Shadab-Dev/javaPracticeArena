package com.java.Strings;

public class SubsequenceRecurse {
    public static void main(String[] args) {
        System.out.println(isSubsequence("ABCD", "ABE"));
    }

    private static boolean isSubsequence(String s1, String s2) {
        if(s2.equals("")) return true;
        if(s1.equals("")) return false;

        int s1Index = 0, s2Index = 0;
        if(s1.charAt(0) == s2.charAt(0)) {
            s1Index++; s2Index++;
        }
        else s1Index++;
        return isSubsequence(s1.substring(s1Index), s2.substring(s2Index));
    }
}
