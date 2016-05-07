package leetcode_216;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Jason on 2016/5/7.
 */

/**
 * Problem definition:
 * Find all possible combinations of k numbers that add up to a number n,
 * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 * Ensure that numbers within the set are sorted in ascending order.
 * Example 1:
 * Input: k = 3, n = 7
 * Output:
 * [[1,2,4]]
 * Example 2:
 * Input: k = 3, n = 9
 * Output:
 * [[1,2,6], [1,3,5], [2,3,4]]
 */

/**
 * Answer:
 * recursion+backtrack
 * use the begin index to avoid duplicate
 */

public class Solution {

    private List<List<Integer>> results = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        Stack<Integer> stack = new Stack<Integer>();
        combinationSum3(k,n,stack,1);
        return results;
    }

    private void combinationSum3(int k,int n,Stack<Integer> stack,int idx) {
        if (k==0&&n==0) {
            if (!stack.empty()) {
                results.add(new ArrayList<Integer>(stack));
            }
        } else {
            for (int i=idx;i<=9;i++) {
                if (i<=n) {
                    stack.push(i);
                    combinationSum3(k-1,n-i,stack,i+1);
                    stack.pop();
                } else {
                    break;
                }
            }
        }
    }

}
