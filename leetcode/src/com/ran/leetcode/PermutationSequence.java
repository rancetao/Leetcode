package com.ran.leetcode;

import java.util.ArrayList;

/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * <p>
 * By listing and labeling all of the permutations in order, We get the
 * following sequence (ie, for n = 3):
 * <p>
 * "123" "132" "213" "231" "312" "321" Given n and k, return the kth permutation
 * sequence.
 * <p>
 * Note: Given n will be between 1 and 9 inclusive.
 *
 * @author RanceTao
 */

public class PermutationSequence {

    public static void main(String[] args) {

        PermutationSequence ps = new PermutationSequence();
        ps.getPermutation(4, 3);
    }

    public ArrayList<String> getPermutations(int n) {

        ArrayList<String> result = new ArrayList<String>();
        ArrayList<String> tempResult = new ArrayList<String>();

        if (n < 1) {
            return null;
        }
        if (n == 1) {
            result.add("1");
            return result;
        }

        ArrayList<String> lastResult = getPermutations(n - 1);
        for (int i = 0; i < lastResult.size(); i++) {
            String temp = lastResult.get(i);
            for (int j = n - 1; j > 0; j--) {

                String newItem = temp.substring(0, j) + String.valueOf(n)
                    + temp.substring(j);
                result.add(newItem);

            }
            tempResult.add(String.valueOf(n) + temp);
        }

        result.addAll(tempResult);

        return result;

    }

    public String getPermutation(int n, int k) {

        ArrayList<String> list = getPermutations(n);
        System.out.println(list.get(k - 1));
        return list.get(k - 1);
    }

    public String getPermutationFast(int n, int k) {

        StringBuilder sb = new StringBuilder();
        boolean[] used = new boolean[n];

        k = k - 1;
        int factor = 1;
        for (int i = 1; i < n; i++) {
            factor *= i;
        }

        for (int i = 0; i < n; i++) {
            int index = k / factor;
            k = k % factor;
            for (int j = 0; j < n; j++) {
                if (used[j] == false) {
                    if (index == 0) {
                        used[j] = true;
                        sb.append((char) ('0' + j + 1));
                        break;
                    } else {
                        index--;
                    }
                }
            }
            if (i < n - 1) {
                factor = factor / (n - 1 - i);
            }
        }

        return sb.toString();
    }
}
