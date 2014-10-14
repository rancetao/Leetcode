package com.ran.leetcode;

/**
 * Implement int sqrt(int x).

 Compute and return the square root of x.
 */


/**
 * Created by rantao on 10/10/14.
 */
public class SqrtX {

    public int sqrt(int x) {

        if (x <= 0) {
            return -1;
        }

        if (x == 0) {
            return 0;
        }

        int high = x / 2 + 1;
        int low = 0;
        while (low < high) {
            double mid = low + (high - low) / 2;
            double res = mid * mid;
            if (res == (double) x) {
                return (int) mid;
            } else if (res > (double) x) {
                high = (int) (mid - 1);
            } else {
                low = (int) (mid + 1);
            }
        }

        return high;

    }
}
