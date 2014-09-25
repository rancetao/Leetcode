package com.ran.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * <p>
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * <p>
 * For example, There is one obstacle in the middle of a 3x3 grid as illustrated below.
 */
// @formatter:off
// [
// [0,0,0],
// [0,1,0],
// [0,0,0]
// ]
// @formatter:on
/*
 * The total number of unique paths is 2.
 * 
 * @author rantao
 */

public class UniquePathII {

    public List<List<Pointer>> getUniquePaths(int[][] matrix) {

        if (null == matrix) {
            return null;
        }

        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        Set<Pointer> visitedList = new HashSet<>();

        List<List<Pointer>> res = new ArrayList<>();
        List<Pointer> path = new ArrayList<>();

        // top to down
        findPaths(0, 0, rowLen - 1, colLen - 1, matrix, path, visitedList, res);

        return res;
    }

    private void findPaths(int x, int y, int endX, int endY, int[][] matrix, List<Pointer> path,
        Set<Pointer> visitedList, List<List<Pointer>> res) {

        if (x > endX || y > endY || checkVisited(x, y, visitedList) || matrix[x][y] == 1) {
            return;
        }

        Pointer pointer = new Pointer(x, y, matrix[x][y]);
        path.add(pointer);
        visitedList.add(pointer);

        if (x == endX && y == endY) {

            List<Pointer> aPath = path;
            res.add(aPath);
        }

        findPaths(x + 1, y, endX, endY, matrix, path, visitedList, res);
        findPaths(x, y + 1, endX, endY, matrix, path, visitedList, res);
    }

    private Boolean checkVisited(int x, int y, Set<Pointer> pointers) {

        Pointer temp = new Pointer(x, y);
        if (pointers.contains(temp)) {
            return true;
        } else {
            return false;
        }
    }


    private class Pointer {

        int x;
        int y;
        int val;

        Pointer(int a, int b, int value) {

            x = a;
            y = b;
            val = value;
        }

        Pointer(int a, int b) {

            x = a;
            y = b;
            val = -1;
        }

        void pointer() {

            x = 0;
            y = 0;
            val = 0;
        }

        int getVal() {

            return this.val;
        }

        public int hashCode() {

            int hash = 1;
            hash = hash * 17 + String.valueOf(x).hashCode();
            hash = hash * 31 + String.valueOf(y).hashCode();
            return hash;
        }

        public boolean equals(Object obj) {

            if (!(obj instanceof Pointer)) {
                return false;
            }
            Pointer newObj = (Pointer) obj;
            if (newObj.hashCode() == this.hashCode()) {
                return true;
            } else {
                return false;
            }
        }

    }
}
