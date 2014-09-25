package com.ran.leetcode;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * <p>
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 *
 * @author taor
 * @since Oct 17, 2013
 */
public class SearchInRotatedSortedArray {

    public static void main(String[] args) {

        // TODO Auto-generated method stub

    }

    public int search(int[] A, int target) {

        int begin = 0;
        int end = A.length - 1;

        while (begin <= end) {
            int mid = begin + (end - begin) / 2;
            if (A[mid] == target) {
                return mid;
            }
            if (A[begin] <= A[mid]) {
                if (A[begin] <= target && target <= A[mid]) {
                    end = mid - 1;
                } else {
                    begin = mid + 1;
                }
            } else {
                if (A[mid] <= target && target <= A[end]) {
                    begin = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

}
