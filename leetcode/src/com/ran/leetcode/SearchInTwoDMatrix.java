package com.ran.leetcode;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * 
 * Integers in each row are sorted from left to right. The first integer of each row is greater than the last integer of
 * the previous row. For example,
 * 
 * Consider the following matrix:
 * 
 * [ 
 * [1, 3, 5, 7], 
 * [10, 11, 16, 20], 
 * [23, 30, 34, 50] 
 * ] Given target = 3, return true.
 * 
 * @author taor
 * @date Jan 31, 2014
 */
public class SearchInTwoDMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null)
            return false;
        if (matrix.length == 1 && matrix[0].length == 1 && matrix[0][0] == target)
            return true;

        if (matrix.length == 1 && matrix[0].length == 1 && matrix[0][0] != target)
            return false;
        
        int rowMid =  (matrix.length -1)/ 2;
        int columnMid = (matrix[0].length -1)/ 2;
        
        int rowEnd = matrix.length -1;
        int columnEnd = matrix[0].length -1 ;
             

        if (target == matrix[rowMid][columnMid])
            return true;
        else if (target > matrix[rowMid][columnMid]) {
            return searchMatrix(copyMatrix(rowMid+1, columnMid+1, rowEnd, columnEnd, matrix), target);
        }
        else {
            return searchMatrix(copyMatrix(0, 0, rowMid, columnMid, matrix), target);
        }
    }

    public int[][] copyMatrix(int rowBegin, int columnBegin, int rowEnd, int columnEnd, int[][] matrix) {

        int rowLen = rowEnd - rowBegin+1;
        int columnLen = columnEnd - columnBegin+1;
        int[][] result = new int[rowLen][columnLen];

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < columnLen; j++) {
                result[i][j] = matrix[rowBegin][columnBegin];
                columnBegin++;
            }
            rowBegin++;
        }
        return result;
    }

    public static void main(String[] args){
        int[][] matrix = {{1,1}};
        int target = 2;
        SearchInTwoDMatrix sd = new SearchInTwoDMatrix();
        System.out.println(sd.searchMatrix(matrix, target));
    }
}
