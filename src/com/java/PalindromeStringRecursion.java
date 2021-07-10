package com.java;

public class PalindromeStringRecursion {
    public static void main(String[] args) {
        String str = "neene";
        boolean isPalindrome = checkPalindrome(str, 0, str.length()-1);
        System.out.println(isPalindrome);
    }

    private static boolean checkPalindrome(String str, int left, int right) {
        if(left >= right) return true;
        if(str.charAt(left) != str.charAt(right)) return false;
        return checkPalindrome(str, left+1, right-1);
    }
}