// Consider a big party where N guests came to it and a log register for guest’s entry and exit times was maintained.
// Find the minimum time at which there were maximum guests at the party. Note that entries in the register are not in any order.
// Input:
// Entry= {1, 2, 10, 5, 5}
// Exit = {4, 5, 12, 9, 12}
// Output: 3 5
//Explanation: At time 5 there were guest number 2, 4 and 5 present.
package com.java.Sorting;

import java.util.Arrays;

public class MaxGuests {
    public static void main(String[] args) {
        int[] Entry = {13, 28, 29, 14, 40, 17, 3};
        int[] Exit = {107, 95, 111, 105, 70, 127, 74};
        int[] result = findMaxGuests(Entry, Exit);
        System.out.println(Arrays.toString(result));
    }

    private static int[] findMaxGuests(int[] entry, int[] exit) {
        int[] result = new int[2];
        Arrays.sort(entry); // 1 2 5 5 10
        Arrays.sort(exit);  // 4 5 9 12 12
        int i = 0, j = 0, count = 0, maxCount = 0, maxEntry = entry[0];
        while (i<entry.length && j<exit.length) {
            if(entry[i] <= exit[j]) {
                count++;
                if(count>maxCount) {
                    maxEntry = entry[i];
                    maxCount = count;
                }
                i++;
            } else {
                count--; j++;
            }
            maxCount = Math.max(maxCount, count);
        }
        result[0] = maxCount;
        result[1] = maxEntry;
        return result;
    }
}
