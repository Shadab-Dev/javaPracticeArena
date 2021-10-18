// Similar to tha last problem but here you can sell multiple times
package com.java.Arrays;

public class StockBuyAndSell2 {
    public static void main(String[] args) {
        int[] arr = {5, 2, 6, 1, 4, 7, 3, 6};
        int maxProfit = findMaxProfit(arr);
        System.out.println(maxProfit);
    }

    private static int findMaxProfit(int[] arr) {
        int maxProfit = 0;
        for (int i = 1; i < arr.length; i++) {
            // since we are allowed to do any number of transactions
            // if we find a day which is greater than the last day, then we do a transaction
            if(arr[i] > arr[i-1]) maxProfit += arr[i] - arr[i-1];
        }
        return maxProfit;
    }
}
