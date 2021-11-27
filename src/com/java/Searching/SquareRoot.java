package com.java.Searching;

public class SquareRoot {
    public static void main(String[] args) {
        System.out.println(findSquareRoot(2147395599));
    }

    private static int findSquareRoot(int x) {
        if (x == 0) return 0;
        int start = 1, end = x, ans = 0;
        while (start <= end) {
            int mid = start + (end-start)/2;
            if(mid <= x / mid) {
                ans = mid;
                start = mid + 1;
            }
            else end = mid -1;

        }
        return ans;
    }
}
