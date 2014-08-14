package com.ran.leetcode;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given
 * number, target. Return the sum of the three integers. You may assume that each input would have
 * exactly one solution.
 * 
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * @author RanceTao
 * 
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] num, int target) {

        Arrays.sort(num);
        int closestSum = Integer.MAX_VALUE;

        int minDiff = Integer.MAX_VALUE;

        int i = 0;
        int endIndex = num.length - 1;

        for (i = 0; i < num.length - 2; i++) {

            int j = i + 1;
            while (j < endIndex) {
                int sum = num[j] + num[endIndex] + num[i];
                if (Math.abs(sum - target) < minDiff) {
                    minDiff = Math.abs(sum - target);
                    closestSum = sum;
                }
                if (sum > target) {
                    endIndex--;
                } else {
                    j++;
                }
            }
            endIndex = num.length - 1;
        }

        return closestSum;
    }

    public static void main(String[] args) {

        int target = 1;
        int[] num = {0, 2, 1, -3};
        ThreeSumClosest tsc = new ThreeSumClosest();
        System.out.print(tsc.threeSumClosest(num, target));
    }
}
