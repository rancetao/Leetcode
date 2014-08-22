package com.ran.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.ran.leetcode.domain.TreeNode;

public class BTPreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<Integer>();

        return preorderTraversal(root, new ArrayList<Integer>());
    }

    public List<Integer> preorderTraversal(TreeNode root, List<Integer> result) {

        if (root.left == null && root.right == null) {
            result.add(root.val);
            return result;
        }

        result.add(root.val);
        if (root.left != null)
            preorderTraversal(root.left, result);
        if (root.right != null)
            preorderTraversal(root.right, result);

        return result;
    }

    public List<Integer> preorderTraversalNotRecursive(TreeNode root) {
        if (root == null)
            return new ArrayList<Integer>();

        List<Integer> result = new ArrayList<Integer>();

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }
        return result;
    }

}
