// Given an array = {3, 1, 4, 8, 7, 2, 5} find the max profit that you can obtain if you buy and sell only once
package com.java.Arrays;

public class StockBuyAndSell1 {
    public static void main(String[] args) {
        int[] arr = {3, 5, 4, 1, 7, 2, 5};
        int maxProfit = findMaxProfit(arr);
        System.out.println(maxProfit);
    }

    private static int findMaxProfit(int[] arr) {
        int minSoFar = arr[0];
        int maxProfit = 0;
        for (int i = 1; i < arr.length; i++) {
            minSoFar = Math.min(arr[i], minSoFar);
            maxProfit = Math.max(arr[i]-minSoFar, maxProfit);
        }
        return maxProfit;
    }
}
