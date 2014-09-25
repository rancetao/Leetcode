package com.ran.leetcode;

/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

 For example,
 Given n = 3,

 You should return the following matrix:
 [
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
 ]
 */


/**
 * @author rantao
 */
public class SprialMatrixII {

    public int[][] spiralMatrix(int n) {

        if (n < 0) {
            return null;
        }
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
