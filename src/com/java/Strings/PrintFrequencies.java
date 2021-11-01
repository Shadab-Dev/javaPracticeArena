// For a given String print each character frequencies
// All the chars in the string must be lowercase
package com.java.Strings;

public class PrintFrequencies {
    public static void main(String[] args) {
        printFrequencies("hello");
    }

    private static void printFrequencies(String s) {
        char[] arr = s.toCharArray();
        int[] frequency = new int[26];
        for (int i = 0; i < arr.length; i++) {
            frequency[(int) arr[i] - 'a']++;
        }
        for (int i = 0; i < frequency.length; i++) {
            if(frequency[i] != 0) {
                System.out.println((char)(i+'a') + ": " + frequency[i]);
            }
        }
    }
}
