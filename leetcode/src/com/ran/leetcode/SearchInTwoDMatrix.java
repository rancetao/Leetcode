package com.ran.leetcode;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * 
 * Integers in each row are sorted from left to right. The first integer of each
 * row is greater than the last integer of the previous row. For example,
 * 
 * Consider the following matrix:
 * 
 * [ [1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 50] ] Given target = 3, return
 * true.
 * 
 * @author taor
 * @date Jan 31, 2014
 */
public class SearchInTwoDMatrix {

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}

		int xLength = matrix[0].length;
		int min = 0;
		int max = matrix[0].length * matrix.length - 1;

		int y, x, current;
		while (min <= max) {
			current = (min + max) / 2;
			x = current / xLength;
			y = current % xLength;
			if (matrix[x][y] == target) {
				return true;
			} else if (target < matrix[x][y]) {
				max = current - 1;
			} else {
				min = current + 1;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 1 } };
		int target = 2;
		SearchInTwoDMatrix sd = new SearchInTwoDMatrix();
		System.out.println(sd.searchMatrix(matrix, target));
	}
}
