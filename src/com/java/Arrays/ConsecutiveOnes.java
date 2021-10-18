// Given a binary array {0, 1, 1, 0, 1, 0} find the max number of consecutive ones
package com.java.Arrays;

public class ConsecutiveOnes {
    public static void main(String[] args) {
        int[] arr = {1,0,1,1,1,1,1,1,1};
        int maxOnes = findConsecutiveOnes(arr);
        System.out.println(maxOnes);
    }

    private static int findConsecutiveOnes(int[] arr) {
        int maxOnes = 0;
        int currentCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 1) {
                currentCount++;
                maxOnes = Math.max(currentCount, maxOnes);
            }
            else currentCount = 0;
        }
        return maxOnes;
    }
}
