package com.java;

public class PrintHelloRecursion {

    public static void main(String[] args) {
        printHello(5);
    }

    private static void printHello(int i) {
        // condition to stop recursion
        if(i == 0) {
            return;
        }
        // subProblem objective
        System.out.println("Hello!");

        // statement that moves inputs towards the stopping condition
        i -= 1;

        // call to same function
        printHello(i);
    }
}
