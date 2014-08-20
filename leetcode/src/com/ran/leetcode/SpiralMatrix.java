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
        ArrayList<Integer> result = new ArrayList<Integer>();

        if (matrix == null || matrix.length == 0)
            return result;

        int row = matrix.length;
        int col = matrix[0].length;

        int x = 0;
        int y = 0;

        while (row > 0 && col > 0) {

            // if one row/column left, no circle can be formed
            if (row == 1) {
                for (int i = 0; i < col; i++) {
                    result.add(matrix[x][y++]);
                }
                break;
            } else if (col == 1) {
                for (int i = 0; i < row; i++) {
                    result.add(matrix[x++][y]);
                }
                break;
            }

            // below, process a circle

            // top - move right
            for (int i = 0; i < col - 1; i++) {
                result.add(matrix[x][y++]);
            }

            // right - move down
            for (int i = 0; i < row - 1; i++) {
                result.add(matrix[x++][y]);
            }

            // bottom - move left
            for (int i = 0; i < col - 1; i++) {
                result.add(matrix[x][y--]);
            }

            // left - move up
            for (int i = 0; i < row - 1; i++) {
                result.add(matrix[x--][y]);
            }

            x++;
            y++;
            row = row - 2;
            col = col - 2;
        }

        return result;
    }


    public static void main(String[] args) {
        SpiralMatrix sm = new SpiralMatrix();
        int[][] matrix = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> list = sm.spiralOrder(matrix);
    }
}
