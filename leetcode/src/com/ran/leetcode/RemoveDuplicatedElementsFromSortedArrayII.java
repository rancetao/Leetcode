package com.ran.leetcode;


/**
 * Follow up for "Remove Duplicates": What if duplicates are allowed at most twice?
 * <p>
 * For example, Given sorted array A = [1,1,1,2,2,3],
 * <p>
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 *
 * @author taor
 * @date Jan 27, 2014
 */
public class RemoveDuplicatedElementsFromSortedArrayII {

  public static void main(String[] args) {

    RemoveDuplicatedElementsFromSortedArrayII rd = new RemoveDuplicatedElementsFromSortedArrayII();
    int[] A = {1, 1, 1, 2};
    rd.removeDuplicates(A);
  }

  // return the length of result array
  public int removeDuplicates(int[] A) {

    int i = 1, j = 0;
    int cnt = 0;

    if (A.length < 3) {
      return A.length;
    }

    for (; i < A.length; i++) {
      if (A[i] == A[j]) { // 重复的情况
        if (cnt == 0) { // 当且仅当重复一次（共出现两次）的情况下才复制
          A[++j] = A[i];
        }
        cnt++;
      } else { // 不重复的情况，更新j的位置，然后直接复制过去
        A[++j] = A[i];
        cnt = 0; // 重置counter
      }
    }

    return j + 1;
  }
}
