// http://www.ardendertat.com/2011/10/10/programming-interview-questions-6-combine-two-strings/
package com.java;

public class CombineTwoStrings {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "defe";
        String str3 = "adebcfe";
        boolean isValid = checkValidShuffle(str1, str2, str3);
        System.out.println(isValid);
    }

    private static boolean checkValidShuffle(String str1, String str2, String str3) {
        if(str1.isEmpty() && str2.isEmpty()) return true;
        if(str3.isEmpty()) return false;
        if(!str1.isEmpty() && str3.charAt(0) == str1.charAt(0)){
            str1 = str1.substring(1);
        } else if(!str2.isEmpty() && str3.charAt(0) == str2.charAt(0)){
            str2 = str2.substring(1);
        }
        str3 = str3.substring(1);
        return checkValidShuffle(str1, str2, str3);
    }
}
