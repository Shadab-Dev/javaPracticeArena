package com.java;

public class ReverseInteger {

    public static void main(String[] args) {
        int num = 1534236469;
        int rev = reverseInt(num);
        System.out.println(rev);
    }

    private static int reverseInt(int x) {
        boolean negativeFlag = false;
        if(x < 0) {
            negativeFlag = true;
            // convert the number to a positive number
            x *= -1;
        }

        int finalInt = 0;
        while(x > 0) {
            finalInt = finalInt * 10 + (x % 10);
            x = x / 10;
        }

        if(finalInt > Integer.MAX_VALUE || finalInt < Integer.MIN_VALUE) {
            return 0;
        }
        return negativeFlag ? finalInt * -1 : finalInt;
    }
}
