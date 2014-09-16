/**
 * 
 */
package com.ran.leetcode;

/**
 * @author rantao
 *
 */
public class SprialMatrixII {

	public int[][] spiralMatrix(int n) {
		if (n < 0)
			return null;
		int[][] res = new int[n][n];
		int levelNum = n / 2;
		int num = 1;
		for (int round = 0; round < levelNum; round++) {
			for (int i = round; i < n - round; i++) {
				res[round][i] = num++;
			}
			for (int i = round + 1; i < n - round; i++) {
				res[i][n - 1 - round] = num++;
			}
			for (int i = n - 2 - round; i >= round; i--) {
				res[n - 1 - round][i] = num++;
			}
			for (int i = n - 2 - round; i > round; i--) {
				res[i][round] = num++;
			}
		}
		if (n % 2 == 1) {
			res[levelNum][levelNum] = num;
		}
		return res;
	}
}
