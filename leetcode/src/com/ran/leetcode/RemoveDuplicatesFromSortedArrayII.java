package com.ran.leetcode;

/**
 * Created by rantao on 10/13/14.
 */
public class RemoveDuplicatesFromSortedArrayII {


    public int removeDuplicates(int[] A) {

        if (A.length < 3) {
            return A.length;
        }
        int index = 1;
        int count = 1;
        for (int i = 1; i < A.length; i++) {

            if (A[i] == A[i - 1]) {
                count++;
            } else {
                count = 1;
            }

            if (count <= 2) {
                A[index] = A[i];
                index++;
            }
        }
        return index;

    }

    public static void main(String[] args) {

        RemoveDuplicatesFromSortedArrayII ss = new RemoveDuplicatesFromSortedArrayII();
        int[] A = {1, 1, 1, 1};
        ss.removeDuplicates(A);
    }
}
