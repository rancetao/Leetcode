package com.ran.leetcode;

import com.ran.leetcode.domain.TreeNode;

//@formatter:off
/**
 * Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
 * @author rantao
 *
 */
//@formatter:on

public class FlattenBTToLinkedList {
  private TreeNode lastNode;

  public void flatten(TreeNode root) {
    if (root == null) {
      return;
    }

    TreeNode tempRight = root.right;
    if (lastNode != null) {
      lastNode.left = null;
      lastNode.right = root;
    }

    lastNode = root;
    flatten(root.left);
    flatten(tempRight);
  }
}
