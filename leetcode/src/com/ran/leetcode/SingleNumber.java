package com.ran.leetcode;

import java.util.HashMap;
import java.util.Set;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you implement it without
 * using extra memory?
 * 
 * @author RanceTao
 * 
 */
public class SingleNumber {
    public int singleNumber(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            if (map.get(A[i]) != null)
                map.put(A[i], 2);
            else
                map.put(A[i], 1);
        }

        Set<Integer> set = map.keySet();
        for (Integer j : set) {
            if (map.get(j) == 1) {
                result = j;
                break;
            }
        }
        return result;
    }

    /**
     * The key to solve this problem is bit manipulation. XOR will return 1 only on two different
     * bits. So if two numbers are the same, XOR will return 0. Finally only one number left.
     * 
     * @param A
     * @return
     */
    public int singleNumberNoExtraMemory(int[] A) {
        int x = 0;

        for (int a : A) {
            x = x ^ a;
        }

        return x;
    }
}
