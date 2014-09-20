package com.ran.leetcode;

/**
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * <p>
 * For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6. Created by rantao on
 * 9/18/14.
 */
public class TrapWater {
	public int trap(int[] A) {
		if (null == A)
			return -1;
		if (A.length == 0 || A.length == 1)
			return 0;

		int[] leftMaxHeight = new int[A.length];
		int[] rightMaxHeight = new int[A.length];

		leftMaxHeight[0] = 0;
		for (int i = 1; i < A.length; i++) {
			leftMaxHeight[i] = Math.max(leftMaxHeight[i - 1], A[i - 1]);
		}

		for (int i : leftMaxHeight) {
			System.out.println(i);
		}

		rightMaxHeight[A.length - 1] = 0;
		for (int i = A.length - 2; i >= 0; i--) {
			rightMaxHeight[i] = Math.max(rightMaxHeight[i + 1], A[i + 1]);
		}

		for (int i : rightMaxHeight) {
			System.out.println(i);
		}

		int trapedWater = 0;
		for (int i = 0; i < A.length - 1; i++) {
			if (Math.min(leftMaxHeight[i], rightMaxHeight[i]) - A[i] > 0) {
				trapedWater += Math.min(leftMaxHeight[i], rightMaxHeight[i])
						- A[i];
			}
		}
		return trapedWater;
	}
}
