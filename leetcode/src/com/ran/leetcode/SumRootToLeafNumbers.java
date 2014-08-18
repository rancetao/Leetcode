package com.ran.leetcode;

import com.ran.leetcode.domain.TreeNode;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a
 * number.
 * 
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * 
 * Find the total sum of all root-to-leaf numbers.
 */
//@formatter:off
        //For example,
        //   1
        //  / \
        // 2   3
//@formatter:on
/**
 * The root-to-leaf path 1->2 represents the number 12. The root-to-leaf path 1->3 represents the
 * number 13.
 * 
 * Return the sum = 12 + 13 = 25.
 * 
 * @author RanceTao
 * 
 */

public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }


    public int sumNumbers(TreeNode node, int sum) {

        if (node == null)
            return 0;
        sum = sum * 10 + node.val;
        if (node.left == null && node.right == null)
            return sum;
        return sumNumbers(node.left, sum) + sumNumbers(node.right, sum);
    }
}
