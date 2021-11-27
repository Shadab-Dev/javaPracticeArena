// Given an array of books in which each elem is the no. of pages in a book, and no. of students,
// we need to find out what is the min no. of maximum pages that can be allocated to a student based on certain conditions
// condition 1 : At least 1 book should be allotted to each student
// condition 2 : Pages in the book must not be divided, at least one book as a whole must be allotted
// condition 3 : Allocation should be done in a contiguous manner
// given arr = {10, 20, 30, 40}, s = 2
// min pages will be 60
// https://www.youtube.com/watch?v=2JSQIhPcHQg&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=21
package com.java.Searching;

public class MinAllotmentOfPages {
    public static void main(String[] args) {
        int[] arr = {12, 34, 67, 90};
        int students = 2;
        int min = findMinPages(arr, students);
        System.out.println(min);
    }

    private static int findMinPages(int[] arr, int students) {
        if(arr.length == 0) return -1;
        if(arr.length == students) return arr[arr.length-1];
        if(arr.length < students) return -1;

        // initializing the result with -1
        int minPages = -1;
        // initialize the starting point with the highest elem of the array,
        // because this number will be the min number in any of the book partitions
        int start = arr[0];
        // initialize the end as sum, because at a time, all the books can be allocated to 1 student
        int end = findSum(arr);

        // apply binary search to find mid-elem, this mid-elem will be assumed as minPages
        while(start<=end) {
            int mid = start + (end-start)/2;
            // We need to validate, if the mid(minPages) can form partitions so that books can be divided to each student
            if(isValid(arr, mid, students)) {
                minPages = mid;
                end = mid-1;
            } else start = mid+1;
        }
        return minPages;
    }

    private static boolean isValid(int[] arr, int mid, int students) {
        int sum = 0;
        int tempStudents = 1;
        for(int i : arr) {
            sum+=i;
            if(sum > mid) tempStudents++;
            if(tempStudents > students) return false;
        }
        return true;
    }

    private static int findSum(int[] arr) {
        int sum = 0;
        for(int i : arr) {
            sum += i;
        }
        return sum;
    }
}
