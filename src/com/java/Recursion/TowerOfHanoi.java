package com.java.Recursion;

public class TowerOfHanoi {
    public static void main(String[] args) {
        // Here, A is initial stack, B is auxilary stack and C is final stack
        // First try to visualize in 2 iterations where N = 2
        printOperations(2, 'A', 'B', 'C');
    }

    public static void printOperations(int n, char A, char B, char C) {
        if(n==1){
            System.out.println("Move Plate " + n + " from Rod " + A + " to Rod " + C);
            return;
        }
        // We first try to move the first half from A to B
        printOperations(n-1, A, C, B);
        // Then we perform the operation for current iteration
        System.out.println("Move Plate " + n + " from Rod " + A + " to Rod " + C);
        // Then we move the half that was stored it B back to C
        printOperations(n-1, B, A, C);
    }
}
