// Given a String "AB", find all the subsets of this string
// Ans = "", "A", "B", "AB" = 4
package com.java.Recursion;

public class SubsetsOfString {
    public static void main(String[] args) {
        String s = "AB";
        findSubsets(s, "", 0);
    }

    private static void findSubsets(String s, String current, int i) {
        if(s.length()==0){
            System.out.println(s);
            return;
        }
        findSubsets(s, current, i+1);
        findSubsets(s, current+s.charAt(i), i+1);
    }
}
