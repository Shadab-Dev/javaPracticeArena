// https://www.youtube.com/watch?v=seOKHXB_w74&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=12
// Given an array of toys in which each char represent a type of toy,
// Help John to pick the max number of toys such that toys can only be picked in a contiguous manner
// And max type of toy can only be 2
// Input: abaccab
// Output: 4, which is "acca"
package com.java.SlidingWindow;

public class PickToys {
    public static void main(String[] args) {
        String s = "abaccab";
        int k = 2;
        System.out.println(findNoOfToys(s, k));
    }

    private static int findNoOfToys(String s, int k) {
        int i = 0, j = 0, count = 0, result = 0;
        int[] freq = new int[26];
        while(j<s.length()) {
            freq[s.charAt(j) - 'a']++;
            if(freq[s.charAt(j) - 'a'] == 1) count++;

           if(count < k) {
               j++;
           } else if(count == k) {
               result = Math.max(result, j-i+1);
               j++;
           } else {
                while (count > k) {
                    freq[s.charAt(i) - 'a']--;
                    if(freq[s.charAt(i) - 'a'] == 0) count--;
                    i++;
                }
               j++;
           }
        }
        return result == 0 ? -1 : result;
    }
}
