package com.ran.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Follow up for "Remove Duplicates": What if duplicates are allowed at most twice?
 * 
 * For example, Given sorted array A = [1,1,1,2,2,3],
 * 
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 * 
 * @author taor
 * @date Jan 27, 2014
 */
public class RemoveDuplicatedElementsFromSortedArrayII {

    // return the length of result array
    public int removeDuplicates(int[] A) {

        if (A.length == 0)
            return 0;
        if (A.length == 1)
            return 1;

        List<Integer> listA = new ArrayList<Integer>();

        for (int i = 0; i < A.length; ++i) {
            listA.add(A[i]);
        }

        int beginIndex = 0;
        while (beginIndex < listA.size()) {
            int secondIndex = beginIndex + 1;
            while (secondIndex + 1 < listA.size()) {
                if (listA.get(beginIndex).equals(listA.get(secondIndex))
                        && listA.get(beginIndex).equals(listA.get(secondIndex + 1))) {
                    listA.remove(secondIndex);
                }
                else {
                    break;
                }
            }
            beginIndex++;
        }

        return listA.size();
    }

    public static void main(String[] args) {

        RemoveDuplicatedElementsFromSortedArrayII rd = new RemoveDuplicatedElementsFromSortedArrayII();
        int[] A = {1, 1, 1, 2};
        rd.removeDuplicates(A);
    }
}
