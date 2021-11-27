// find the next alphabet which is provided as input in the given arr
// arr = {a, b, c, d, f, g, h}
// next alphabet of e will be f
// one point to note is even if the elem is present in the array, then also we need to fetch the next alphabet of the elem
// here, if elem is d, then also we need to return f even when d is present
package com.java.Searching;

public class NextAlphabet {
    public static void main(String[] args) {
        char[] arr = {'a', 'b', 'd', 'e', 'g'};
        char elem = 'a';
        char next = findNextAlphabet(arr, elem);
        System.out.println(next);
    }

    private static char findNextAlphabet(char[] arr, char elem) {
        if(arr.length == 0) return ' ';
        int start = 0;
        int end = arr.length-1;
        char next = ' ';

        while (start<=end) {
            int mid = start + (end-start)/2;
            // since we need to fetch the next alphabet, we continue the search
            if(arr[mid] == elem) start = mid+1;

            if(arr[mid]<elem) start = mid+1;
            if(arr[mid]>elem) {
                next = arr[mid];
                end = mid-1;
            }
        }
        return next;
    }
}
