package com.ran.leetcode;

import com.ran.leetcode.domain.TreeNode;

import java.util.Arrays;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * @author taor
 * @since Oct 17, 2013
 */
public class ConvertSortedArraytoBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] num) {

        if (num == null || num.length == 0) {
            return null;
        }
        int begin = 0;
        int end = num.length;
        int mid = begin + (end - begin) / 2;

        TreeNode node = new TreeNode(num[mid]);

        int[] leftNum = Arrays.copyOfRange(num, begin, mid);
        int[] rightNum = Arrays.copyOfRange(num, mid + 1, end);
        if (leftNum.length > 0) {
            node.left = sortedArrayToBST(leftNum);
        }
        if (rightNum.length > 0) {
            node.right = sortedArrayToBST(rightNum);
        }

        return node;
    }
}
