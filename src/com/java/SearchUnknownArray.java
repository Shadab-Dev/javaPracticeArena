package com.java;

public class SearchUnknownArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,7,8,12,21,24,28,33,38,42,55,58,61};
        int k = 58;
        int index = findElement(arr, k);
        System.out.println(index);
    }

    private static int findElement(int[] arr, int element) {
        int index = -1;
        for (int j = 0; j < arr.length; j=j+2) {
            if(arr[j]==element) return j;
            if (arr[j]>element) {
                index = binarySearchElement(arr, 0, j, element);
            }
        }
        return index;
    }

    private static int binarySearchElement(int[] arr, int i, int j, int element) {
        int pivot = (i+j)/2;
        if(element==arr[pivot]) return pivot;
        if(element<arr[pivot]) return binarySearchElement(arr, i, pivot, element);
        if(element>arr[pivot]) return binarySearchElement(arr, pivot, j, element);
        return -1;
    }
}
