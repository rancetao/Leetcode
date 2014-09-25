package com.ran.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * <p>
 * The same repeated number may be chosen from C unlimited number of times.
 * <p>
 * Note: All numbers (including target) will be positive integers. Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak). The solution set must not contain
 * duplicate combinations. For example, given candidate set 2,3,6,7 and target 7, A solution set is: [7] [2, 2, 3]
 *
 * @author taor
 * @date Apr 10, 2014
 */

// It is not my solution but it deserve to take a look.
public class CombinationSum {

    public static void main(String args[]) {

        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        CombinationSum cs = new CombinationSum();
        cs.combinationSum(candidates, target);
    }

    public ArrayList<ArrayList<Integer>> combinationSumMine(int[] candidates, int target) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if (candidates == null || candidates.length == 0) {
            return result;
        }

        Arrays.sort(candidates);
        int start = 0;
        ArrayList<Integer> currentPossibleSolution = new ArrayList<Integer>();
        calculateResult(candidates, currentPossibleSolution, start, result, target);

        return result;
    }

    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if (candidates == null || candidates.length == 0 || target < 0) {
            return result;
        }

        Arrays.sort(candidates);

        int start = 0;
        ArrayList<Integer> current = new ArrayList<Integer>();
        buildResult(candidates, start, current, target, result);

        return result;
    }

    private void calculateResult(int[] candidates, ArrayList<Integer> currentPossibleSolution,
        int start, ArrayList<ArrayList<Integer>> result, int target) {

        if (target == 0) {
            result.add(new ArrayList<Integer>(currentPossibleSolution));
            return;
        }

        for (int i = 0; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                return;
            }
            currentPossibleSolution.add(candidates[i]);
            calculateResult(candidates, currentPossibleSolution, i, result, target - candidates[i]);
            currentPossibleSolution.remove(currentPossibleSolution.size() - 1);
        }
    }

    private void buildResult(int[] candidates, int start, ArrayList<Integer> current, int target,
        ArrayList<ArrayList<Integer>> result) {

        if (target == 0) {
            ArrayList<Integer> temp = new ArrayList<Integer>(current);
            result.add(temp);
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                return;
            }

            current.add(candidates[i]);
            buildResult(candidates, i, current, target - candidates[i], result);
            current.remove(current.size() - 1);
        }
    }
}
