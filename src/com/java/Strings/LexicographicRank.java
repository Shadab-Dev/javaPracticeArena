// Given a String s = "ibytes", find the lexicographic rank of that string
package com.java.Strings;

public class LexicographicRank {
    private static final int SIZE = 256;
    public static void main(String[] args) {
        String s = "ibytes";
        long rank = findLexicographicRank(s);
        System.out.println(rank);
    }

    private static long findLexicographicRank(String s) {
        int[] factorial = new int[s.length()];
        int[] frequency = new int[SIZE];
        long rank = 0;

        // preprocess the factorials for s.length
        // and preprocess the frequency array
        factorial[1] = 1;
        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a']++;
            if(i>=2) factorial[i] = factorial[i-1] * i;
        }

        // apply the formula for finding the lexicographic rank
        for (int i = 0; i < s.length(); i++) {
            int noOfSmallerElements = getNoOfSmallerElements(frequency, s.charAt(i));
            int currentFactorial = factorial[s.length()-i -1];
            rank += (long) noOfSmallerElements * currentFactorial;
        }
        // the rank that we obtain will be the rank of strings smaller that the given string. So we would need to add 1 to this.
        return rank+1;
    }

    private static int getNoOfSmallerElements(int[] frequency, char c) {
        int result = 0;
        for (int i = 0; i < SIZE; i++) {
            if((i + 'a') == c) {
                // if we find the current char, then we replace its freq with 0 so that we do not use it again for further computations
                // This is a very important step to remember
                frequency[i] = 0;
                break;
            }
            if(frequency[i] > 0) result++;
        }
        return result;
    }
}
