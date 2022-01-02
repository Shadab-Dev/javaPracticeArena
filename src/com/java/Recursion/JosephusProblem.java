package com.java.Recursion;

import java.util.ArrayList;
import java.util.List;

public class JosephusProblem {
    public static void main(String[] args) {
        System.out.println(findTheWinner(5, 2));
    }

    public static int findTheWinner(int n, int k) {
        List<Integer> input = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            input.add(i+1);
        }
        return helper(input, 0, k);
    }

    private static int helper(List<Integer> input, int start, int k) {
        if(input.size() == 1) return input.get(0);
        int curr = (start + (k-1)) % input.size();
        input.remove(curr);
        System.out.println(input);
        return helper(input, curr, k);
    }
}
