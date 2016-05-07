package leetcode_77;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Jason on 2016/5/7.
 */

/**
 * Problem definition:
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

 * For example,
 * If n = 4 and k = 2, a solution is:

 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */

/**
 * Answer:
 * recursion + backtrack
 * use the begin idx to avoid duplicate
 */
public class Solution {
    private List<List<Integer>> results = new ArrayList<List<Integer>>();

    public List<List<Integer>> combine(int n, int k) {
        Stack<Integer> stack = new Stack<Integer>();
        combine(n,k,stack,1);
        return results;
    }

    private void combine(int n, int k, Stack<Integer> stack, int idx) {
        if (k==0) {
            if (!stack.empty()) {
                results.add(new ArrayList<Integer>(stack));
            }
        } else {
            for (int i=idx;i<=n;i++) {
                stack.push(i);
                combine(n,k-1,stack,i+1);
                stack.pop();
            }
        }
    }


}
