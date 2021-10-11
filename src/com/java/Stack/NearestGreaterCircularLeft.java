// Given an arr = {1, 2, 0, 0, 3, 1, 2, 4}
// For each element, calculate the element which is greater than that element and is on the left side.
// for the first element, since there will be nothing on the left, we move in a circular fashion and find the element from the back
// Here answer will be {4, 4, 2, 2, 4, 3, 3, -1}
package com.java.Stack;

import java.lang.reflect.Array;
import java.util.Arrays;

public class NearestGreaterCircularLeft {
    public static void main(String[] args) {
        int[] arr = {5, 2, 0, 0, 3, 1, 2, 4};
        int[] output = findGreaterLeftCircular(arr);
        System.out.println(Arrays.toString(output));
    }

    private static int[] findGreaterLeftCircular(int[] arr) {
        int[] output = new int[arr.length];
        Stack st = new Stack();

        // Filling the array with -1 so that the element which don't have any other greater elem will have -1
        Arrays.fill(output, -1);

        // looping twice the size of arr so that we can have the same array elements after the arr
        for (int i = 0; i < (2*arr.length); i++) {
            // Using modulo to get the rotated elem at that index
            // eg: In this case when index given is 9, it should return elem 5 as the modulo is 0.
            int rotatedIndex = i % arr.length;

            while (st.peek()!=-1 && arr[st.peek()]<arr[rotatedIndex])
                output[st.pop()] = arr[rotatedIndex];

            if(i<arr.length) st.push(i);
            st.leanPrint();
            System.out.println("Output: " + Arrays.toString(output));
        }
        return output;
    }
}
