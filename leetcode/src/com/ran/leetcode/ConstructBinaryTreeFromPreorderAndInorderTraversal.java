package com.ran.leetcode;

import com.ran.leetcode.domain.TreeNode;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * @author RanceTao
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int preOrderIndex = preorder.length - 1;
        int inOrderIndex = inorder.length - 1;

        return buildTree(preorder, 0, preOrderIndex, inorder, 0, inOrderIndex);
    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart,
        int inEnd) {

        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int val = root.val;

        if (preStart == preEnd && inStart == inEnd) {
            return root;
        }

        int k = 0;
        for (int i = inStart; i < inorder.length; i++) {
            if (inorder[i] == val) {
                k = i;
                break;
            }
        }

        int numInLeft = k - inStart;

        root.left =
            buildTree(preorder, preStart + 1, preStart + numInLeft, inorder, inStart, k - 1);

        root.right = buildTree(preorder, preStart + numInLeft + 1, preEnd, inorder, k + 1, inEnd);

        return root;
    }
}
