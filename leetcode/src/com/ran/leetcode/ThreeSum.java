package com.ran.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in
 * the array which gives the sum of zero.
 * 
 * Note: Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c) The solution set must not
 * contain duplicate triplets. For example, given array S = {-1 0 1 2 -1 -4},
 * 
 * A solution set is: (-1, 0, 1) (-1, -1, 2)
 * 
 * @author taor
 * @since Oct 17, 2013
 */
public class ThreeSum {

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {

        ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        int begin = 0;
        int end = num.length - 1;
        ArrayList<Integer> result;
        while (begin < end) {
            int tempEnd = end;
            int next = begin + 1;
            while (next < tempEnd) {

                result = new ArrayList<Integer>();
                if (num[begin] + num[next] == -num[tempEnd]) {
                    result.add(num[begin]);
                    result.add(num[next]);
                    result.add(num[tempEnd]);
                    if (!resultList.contains(result)) {
                        resultList.add(result);
                    }
                    next++;
                }
                else if (num[begin] + num[next] > -num[tempEnd]) {
                    tempEnd--;
                }
                else {
                    next++;
                }
            }
            begin++;
        }

        return resultList;
    }

}
