package com.ran.leetcode;

import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to
 * adjacent numbers on the row below.
 *
 * For example, given the following triangle
 */
//@formatter:off
//[
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
//@formatter:on


/**
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 * @author RanceTao
 */
public class Triangle {

    // Bottom up
    public int minimumTotal(List<List<Integer>> triangle) {

        int[] total = new int[triangle.size()];
        int l = triangle.size() - 1;

        for (int i = 0; i < triangle.get(l).size(); i++) {
            total[i] = triangle.get(l).get(i);
        }

        // iterate from last second row
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i + 1).size() - 1; j++) {
                total[j] = triangle.get(i).get(j) + Math.min(total[j], total[j + 1]);
            }
        }

        return total[0];
    }
}
