package com.ran.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral
 * order.
 * 
 * For example, Given the following matrix:
 * 
 * @formatter off [ [ 1, 2, 3 ], [ 4, 5, 6 ], [ 7, 8, 9 ] ] You should return [1,2,3,6,9,8,7,4,5].
 * @formatter on
 * @author RanceTao
 * 
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        return spiralOrder(matrix, new ArrayList<Integer>());
    }

    public List<Integer> spiralOrder(int[][] matrix, List<Integer> list) {

        int i = 0;
        int j = 0;

        int m = matrix.length;
        int n = matrix[0].length;

        if (m == 0 && n == 0) {
            list = new ArrayList<Integer>();
            list.add(matrix[0][0]);
            return list;
        }
        while (m > 0 && n > 0) {

            // left to right
            while (i < n) {
                list.add(matrix[m][i]);
                i++;
            }
            // top to bottom
            while (j < m) {
                list.add(matrix[j][n]);
                j++;
            }
            // right to left
            while (i > 0) {
                list.add(matrix[m][i]);
                i--;
            }
            // bottom to top
            while (j > 0) {
                list.add(matrix[j][n]);
                j--;
            }
            i++;
            j++;
            m = m - 2;
            n = n - 2;

        }

        return list;
    }
}
