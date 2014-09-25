package com.ran.leetcode;

public class Pow {

    public double pow(double x, int n) {

        if (x == 0 && n == 0) {
            return Integer.MIN_VALUE;
        }

        if (x == 0) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return x;
        }

        boolean aMinus = x < 0 ? true : false;
        boolean bMinus = n < 0 ? true : false;

        int bAbs = Math.abs(n);
        double aAbs = Math.abs(x);

        double tempAnswer;
        // check if n is odd
        if ((n & 1) != 0) {
            tempAnswer = pow(aAbs, bAbs - 1) * aAbs;
        } else {
            tempAnswer = pow(aAbs * aAbs, bAbs / 2);
        }

        if (bMinus) {
            tempAnswer = 1.0 / tempAnswer;
        }
        if (aMinus && (n & 1) != 0) {
            tempAnswer *= -1;
        }

        return tempAnswer;
    }
}
