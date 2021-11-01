package com.java.Strings;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("aa"));
    }

    private static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;
        while (start<end) {
            if(s.charAt(start) != s.charAt(end)) return false;
            start++; end--;
        }
        return true;
    }
}
