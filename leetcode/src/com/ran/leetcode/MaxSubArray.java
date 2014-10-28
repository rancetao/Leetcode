package com.ran.leetcode;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

 For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 */


/**
 * Created by rantao on 10/16/14.
 */
public class MaxSubArray {

    public int maxSubArray(int[] A) {

        if (A == null || A.length == 0) {
            return 0;
        }
        if (A.length == 1) {
            return A[0];
        }

        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (sum > max) {
                max = sum;
            }

            if (sum < 0) {
                sum = 0;
            }
        }

        return max;


    }
}
