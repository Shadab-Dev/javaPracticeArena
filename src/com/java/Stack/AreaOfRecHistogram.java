// Given the range of Histogram: {6, 2, 5, 4, 5, 1, 6}
// Find the max area of the rectangle present in the histogram
package com.java.Stack;

import java.util.Arrays;

public class AreaOfRecHistogram {
    public static void main(String[] args) {
        int[] histogram = {2, 1, 5, 6, 2, 3, 1};
        int maxRec = findAreaOfRectangle(histogram);
        System.out.println(maxRec);
    }

    private static int findAreaOfRectangle(int[] histogram) {
        int[] nslArr = findNSL(histogram);
        int[] nsrArr = findNSR(histogram);
        int[] area = new int[histogram.length];
        int maxRec = -1;
        for (int i = 0; i < histogram.length; i++) {
            int currentArea = (nsrArr[i] - nslArr[i] + 1) * histogram[i];
            area[i] = currentArea;
            if(currentArea > maxRec) maxRec = currentArea;
        }
        System.out.println(Arrays.toString(nslArr));
        System.out.println(Arrays.toString(nsrArr));
        System.out.println(Arrays.toString(area));
        return maxRec;
    }

    private static int[] findNSL(int[] arr) {
        int[] output = new int[arr.length];
        Stack st = new Stack();

        // since we want the smallest elem on the left, we run a normal loop
        for (int i = 0; i < arr.length; i++) {
            // If the stack is empty then add -1 to output and push the arr elem in the stack
            if(st.peek() == -1) {
                output[i] = 0;
                st.push(i);
                // If the top elem is smaller than arr elem, then that is the nearest smaller elem
            } else if(arr[st.peek()] < arr[i]) {
                output[i] = st.peek() + 1;
                st.push(i);
            } else {
                // If the top elem is greater, then keep popping until stack is empty,
                // or you find the top elem which is smaller than arr elem
                while (st.peek()!=-1 && arr[st.peek()]>=arr[i]) {
                    st.pop();
                }
                if(st.peek() == -1) output[i] = 0;
                else if(arr[st.peek()] < arr[i]) output[i] = st.peek() + 1;
                st.push(i);
            }

        }
        return output;
    }

    private static int[] findNSR(int[] arr) {
        int[] output = new int[arr.length];
        Stack st = new Stack();
        // {2, 1, 5, 6, 2, 3, 1}
        // since we want the smaller elem on the right, we run a reverse loop
        for (int i = arr.length-1; i > -1; i--) {
            // If the stack is empty then add -1 to output and push the arr elem in the stack
            if(st.peek() == -1) {
                output[i] = arr.length-1;
                st.push(i);
                // If the top elem is greater than arr elem, then that is the nearest greater elem
            } else if(arr[st.peek()] < arr[i]) {
                output[i] = st.peek() - 1;
                st.push(i);
            } else {
                // If the top elem is smaller, then keep popping until stack is empty,
                // or you find the top elem which is greater than arr elem
                while (st.peek()!=-1 && arr[st.peek()]>=arr[i]) {
                    st.pop();
                }
                if(st.peek() == -1) output[i] = arr.length-1;
                else if(arr[st.peek()] < arr[i]) output[i] = st.peek() - 1;
                st.push(i);
            }

        }
        return output;
    }
}
