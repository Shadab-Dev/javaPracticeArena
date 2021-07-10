package com.java;

public class ReverseWordsInString {
    public static void main(String[] args) {
        String str = "Strings are Awesome!";
        String rev = reverseWords(str);
        System.out.println(rev);
    }

    private static String reverseWords(String str) {
        StringBuffer result = new StringBuffer();
        int initialPos = str.length();
        for (int i = str.length()-1; i > -1; i--) {
            if(str.charAt(i) == ' ') {
                result.append(str, i+1, initialPos);
                result.append(" ");
                initialPos = i;
            }
            if(i==0) {
                result.append(str, i, initialPos);
            }
        }
        return result.toString();
    }
}
