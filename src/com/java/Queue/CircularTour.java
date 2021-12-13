package com.java.Queue;

public class CircularTour {
    public static void main(String[] args) {
        int[] cost = {3,4,5,1,2};
        int[] gas =  {1,2,3,4,5};
        System.out.println(canCompleteCircuit(gas, cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int prevGas = 0;
        int currGas = 0;
        int start = 0;
        for (int i = 0; i < cost.length; i++) {
            // At each iteration we calc the currentGas
            currGas += (gas[i] - cost[i]);
            if (currGas < 0) {
                // If the currGas becomes negative, then we know that we cannot start from this point
                // So we move start to the next ith element and try store the gas calculated in prevGas variable
                start = i+1;
                // we will need prevGas because we want the circular loop.
                prevGas += currGas;
                // Since we are doing a new start from next i, we make the current gas as 0.
                currGas = 0;
            }
        }
        // If the sum of previous gas and current gas is greater than or equal to 0,
        // then the starting point is valid, else we do not find the loop
        // we use start + 1 when we take 1st gas station as 1, if we want to take 1st station as 0, then we only return start
        return (prevGas + currGas >= 0) ? start + 1 : -1;
    }
}
