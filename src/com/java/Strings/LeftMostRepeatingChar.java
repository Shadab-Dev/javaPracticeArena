// given a string find the left most repeating char
// For a string "abccb" the answer should be "b"
package com.java.Strings;

public class LeftMostRepeatingChar {
    // Assuming that we are only dealing with small case chars
    private static final int SIZE = 26;

    public static void main(String[] args) {
        System.out.println(findLeftMostRepeatingChar("abcca"));
    }

    private static char findLeftMostRepeatingChar(String s) {
        boolean[] visited = new boolean[SIZE];
        char leftMost = 0;
        for (int i = s.length()-1; i > -1; i--) {
            if(!visited[s.charAt(i) - 'a']) visited[s.charAt(i) - 'a'] = true;
            else leftMost = s.charAt(i);
        }
        return leftMost;
    }
}
