package com.ran.leetcode;

/**
 * Created by rantao on 10/13/14.
 */
public class RemoveDuplicatesFromSortedArrayII {


    public int removeDuplicates(int[] A) {

        if (A == null || A.length == 0) {
            return 0;
        }

        int pre = A[0];
        boolean flag = false;
        int count = 0;

        // index for updating
        int o = 1;

        for (int i = 1; i < A.length; i++) {
            int curr = A[i];

            if (curr == pre) {
                if (!flag) {
                    flag = true;
                    A[o++] = curr;

                    continue;
                } else {
                    count++;
                }
            } else {
                pre = curr;
                A[o++] = curr;
                flag = false;
            }
        }

        return A.length - count;
    }

    public static void main(String[] args) {

        RemoveDuplicatesFromSortedArrayII ss = new RemoveDuplicatesFromSortedArrayII();
        int[] A = {1, 1, 1, 1};
        ss.removeDuplicates(A);
    }
}
