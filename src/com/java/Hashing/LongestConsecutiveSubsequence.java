// Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
// You must write an algorithm that runs in O(n) time.
// Input: nums = [100,4,200,1,3,2]
// Output: 4
// Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
package com.java.Hashing;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubsequence {
    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 2};
        int result = findlongestSubsequence(arr);
        System.out.println(result);
    }

    private static int findlongestSubsequence(int[] arr) {
        if(arr.length<2) return arr.length;
        Set<Integer> set = new HashSet<>();
        int maxLength = 1;
        // insert all elements in the hashSet
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        // The idea is to iterate over the HashSet and find the next element
        for(Integer elem : set) {
            // We only proceed if the i-1 elem is not present
            // if its present then it means the current element is not the first element in the subsequence
            if(!set.contains(elem-1)) {
                int currLength = 1;
                // We keep incrementing the length if we find the next integer value in the set
                while(true) {
                    if(set.contains(elem+currLength)) {
                        currLength++;
                        maxLength = Math.max(maxLength, currLength);
                    // if we dont find the next integer value, we break and start from length 1
                    } else break;
                }
            }
        }
        return maxLength;
    }
}
