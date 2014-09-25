package com.ran.leetcode;

import com.ran.leetcode.domain.TreeLinkNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by rantao on 9/24/14.
 */
public class PopulateNextPointerInEachNode {

    public void connect(TreeLinkNode root) {

        if (root == null || root.left == null || root.right == null) {
            return;
        }

        if (root.left != null) {
            root.left.next = root.right;
        }

        if (root.right != null && root.next != null) {
            root.right.next = root.next.left == null ? null : root.next.left;
        }

        connect(root.left);
        connect(root.right);
    }
}
