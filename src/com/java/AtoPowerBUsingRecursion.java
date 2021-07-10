package com.java;

public class AtoPowerBUsingRecursion {
    public static void main(String[] args) {
        int a = 2;
        int b = 3;
        int result = findAtoPowerB(a, b);
        System.out.println(result);
    }

    private static int findAtoPowerB(int a, int b) {
        if(b == 0) return 1;
        return a * findAtoPowerB(a, b-1);
    }
}
