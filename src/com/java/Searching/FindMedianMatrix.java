package com.java.Searching;

// INCOMPLETE
public class FindMedianMatrix {
    public static void main(String[] args) {
        int[][] mat = {
                {1,3,5},
                {2,6,9},
                {3,6,9}
        };
        // 1 2 3 3 5 6 6 9 9
        System.out.println(new FindMedianMatrix().findMedian(mat));
    }

    public int findMedian(int[][] mat) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        int totalElements = mat.length * mat[0].length;
        int ans = -1;
        for (int i = 0; i < mat.length; i++) {
            low = Math.min(low, mat[i][0]);
            high = Math.max(high, mat[i][mat.length-1]);
        }

        while(low<=high) {
            int mid = (low+high) / 2;
            int smaller = getSmallerElements(mat, mid);
            if(smaller <= Math.ceil(totalElements/2)) {
                ans = mid;
                low = mid+1;
            }
            else high = mid-1;
        }
        return ans;
    }

    private int getSmallerElements(int[][] mat, int mid) {
        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if(mat[i][j] <= mid) count++;
            }
        }
        return count;
    }

}
