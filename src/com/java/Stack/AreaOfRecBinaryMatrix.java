// Given a binary matrix, find the max area of the rectangle present in the matrix
package com.java.Stack;

import java.util.Arrays;

public class AreaOfRecBinaryMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
            {0, 1, 1, 0},
            {1, 1, 1, 1},
            {1, 1, 1, 1},
            {1, 1, 0, 0}
        };
        int max = findMaxAreaInMatrix(matrix);
        System.out.println(max);
    }

    // Since we already know how to solve this problem using a histogram(1D array),
    // we will convert this problem in a 1D array and then find the maxArea for each 1D array,
    // after we find the area for one iteration, we will add the height in the next iteration to increase the overall area,
    // We will need to make sure that if there is a 0 at ground level, then we dont calc the area of that elem
    private static int findMaxAreaInMatrix(int[][] matrix) {
        int maxArea = Integer.MIN_VALUE;

        // Create a 1D array to store the height at each iteration
        int[] finalHistogram = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                // For each column we will check if there is a zero,
                // For zero, we will not calc the area
                if(matrix[i][j] == 0) finalHistogram[j] = 0;
                else finalHistogram[j] += matrix[i][j];
            }
            System.out.println(Arrays.toString(finalHistogram));

            // When we get the heights at each iteration, we find the max area for that iteration
            int area = findAreaOfRectangle(finalHistogram);
            if(area > maxArea) maxArea = area;
        }
        return maxArea;
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
