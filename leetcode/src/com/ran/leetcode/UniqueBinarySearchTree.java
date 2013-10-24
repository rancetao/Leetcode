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
  
 *
 * @author taor
 * @since Oct 23, 2013
 */
public class UniqueBinarySearchTree {
    
public int numTrees(int n) {
        
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        if (n == 2)
            return 2;        
           
        return numTrees(n,n, 0);        
    }

    public int numTrees(int n, int m, int result) {
        
        if(m == 0)
            return 0;
        if(m == 1)
            return 1;
        if (m == 2)
            return 2;
        
        while(m>2){
           
            --m;
        }        
        return result;        
    }
}
