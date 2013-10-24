package com.ran.leetcode;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?


For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
  
 * really?
 * @author taor
 * @since Oct 23, 2013
 */
public class UniqueBinarySearchTree {
    
    public int numTrees(int n) {
        
        return uniqueBinarySearchTreesHelper(1, n);
    }
    public int uniqueBinarySearchTreesHelper(int s, int e){
        if(s > e)
            return 1;
        if(s == e)
            return 1;

        int result = 0;
        for(int i = s; i <= e; ++i)
            // get sorted in the left tree and get sorted in the right tree.
            result += uniqueBinarySearchTreesHelper(s, i - 1) * uniqueBinarySearchTreesHelper(i + 1, e);

        return result;
    }    
}
