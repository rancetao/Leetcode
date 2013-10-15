package com.ran.leetcode;

import java.util.Arrays;

import com.ran.leetcode.domain.TreeNode;

public class ConvertSortedArrayToBST {

    /**
     * 
     * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
     * 
     * @param args
     */

    public TreeNode sortedArrayToBST(int[] num) {

        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (num == null || num.length == 0)
            return null;
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

    public static void main(String[] args) {

        // TODO Auto-generated method stub

    }

}
