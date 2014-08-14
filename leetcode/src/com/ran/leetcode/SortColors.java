package com.ran.leetcode;


/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same
 * color are adjacent, with the colors in the order red, white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue
 * respectively.
 * 
 * Note: You are not suppose to use the library's sort function for this problem.
 * 
 * 
 * Follow up: A rather straight forward solution is a two-pass algorithm using counting sort. First,
 * iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of
 * 0's, then 1's and followed by 2's.
 * 
 * Could you come up with an one-pass algorithm using only constant space?
 * 
 * @author RanceTao
 * 
 */
public class SortColors {

    public void sortColors(int[] A) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                count0++;
            }
            if (A[i] == 1) {
                count1++;
            }
            if (A[i] == 2) {
                count2++;
            }
        }
        for (int i = 0; i < count0; i++) {
            A[i] = 0;
        }
        for (int i = count0; i < count0 + count1; i++) {
            A[i] = 1;
        }
        for (int i = count0 + count1; i < count0 + count1 + count2; i++) {
            A[i] = 2;
        }
    }

    public void sortColors2(int[] A) {
        int positionZero = 0;
        int positionOne = 0;
        int positionTwo = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                A[positionTwo] = 2;
                A[positionOne] = 1;
                A[positionZero] = 0;
                positionZero++;
                positionOne++;
                positionTwo++;
            } else if (A[i] == 1) {
                A[positionTwo] = 2;
                A[positionOne] = 1;
                positionOne++;
                positionTwo++;
            } else if (A[i] == 2) {
                A[positionTwo] = 2;
                positionTwo++;
            }
        }
    }
}
