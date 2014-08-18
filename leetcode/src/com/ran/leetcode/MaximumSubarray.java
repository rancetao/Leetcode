package com.ran.leetcode;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the
 * largest sum.
 * 
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4], the contiguous subarray [4,−1,2,1] has the
 * largest sum = 6.
 * 
 * More practice: If you have figured out the O(n) solution, try coding another solution using the
 * divide and conquer approach, which is more subtle.
 * 
 * @author RanceTao
 * 
 */
public class MaximumSubarray {

    public int maxSubArray(int[] A) {
        int max = A[0];
        int maxSum = 0;

        for (int i = 0; i < A.length; i++) {
            maxSum += A[i];
            if (maxSum > max) {
                max = maxSum;
            }

            if (maxSum < 0) {
                maxSum = 0;
            }
        }
        return max;
    }

}
