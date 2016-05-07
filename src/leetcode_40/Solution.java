package leetcode_40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by Jason on 2016/5/7.
 */

/**
 * Problem definition:
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 * Each number in C may only be used once in the combination.

 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8,
 * A solution set is:
 * [1, 7]
 * [1, 2, 5]
 * [2, 6]
 * [1, 1, 6]
 */

/**
 * Answer:
 * recursion+backtrack
 * each element can only be used once, so the start index plus one
 * to avoid duplicate result, check whether i>begin and candidates[i]==candidates[i-1], if so break it
 */
public class Solution {

    private List<List<Integer>> results = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Stack<Integer> result = new Stack<Integer>();
        combinationSum2(candidates, target, result, 0);
        return results;
    }

    public void combinationSum2(int[] candidates, int target,Stack<Integer> stack,int idx) {
        if (target==0) {
            if (!stack.empty()) {
                results.add(new ArrayList<Integer>(stack));
            }
        } else {
            for (int i=idx;i<candidates.length;i++) {
                if (i>idx&&candidates[i]==candidates[i-1]) {
                    continue;
                }
                int candidate = candidates[i];
                if (target>=candidates[i]) {
                    stack.push(candidate);
                    combinationSum2(candidates, target - candidate, stack, i+1);
                    stack.pop();
                } else {
                    break;
                }
            }
        }
    }

}
