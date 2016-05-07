package leetcode_39;

import java.util.*;

/**
 * Created by Jason on 2016/5/7.
 */

/**
 * Problem definition:
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 * The same repeated number may be chosen from C unlimited number of times.

 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 2,3,6,7 and target 7,
 * A solution set is:
 * [7]
 * [2, 2, 3]
 */

/**
 * Answer:
 * recursion + backtrack
 * note that, record the start index to avoid duplicate
 */
public class Solution {

    private List<List<Integer>> results = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        Stack<Integer> result = new Stack<Integer>();
        combinationSum(candidates,target,result,0);
        return results;
    }

    public void combinationSum(int[] candidates, int target,Stack<Integer> stack,int idx) {
        if (target==0) {
            if (!stack.empty()) {
                ArrayList<Integer> clone = new ArrayList<Integer>();
                for (int value:stack) {
                    clone.add(value);
                }
                results.add(clone);
            }
        } else {
            for (int i=idx;i<candidates.length;i++) {
                int candidate = candidates[i];
                if (target>=candidates[i]) {
                    stack.push(candidate);
                    combinationSum(candidates, target - candidate, stack, i);
                    stack.pop();
                } else {
                    break;
                }
            }
        }
    }

}
