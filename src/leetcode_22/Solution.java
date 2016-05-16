package leetcode_22;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jason on 2016/5/16.
 */

/**
 * Problem definition:
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 */

/**
 * Answer:
 * recursion
 * add valid parentheses according by left and right size
 * if left>0, add '(' must be valid
 * if right>0 and left<right, add ')' must be valid
 */
public class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<String>(n*n);
        generateParenthesis(results,"",n,n);
        return results;
    }

    private void generateParenthesis(List<String> results, String str, int left, int right) {
        if (left==0&&right==0) {
            results.add(str);
            return;
        }
        if (left>0) {
            generateParenthesis(results,str+"(",left-1,right);
        }
        if (right>0&&left<right) {
            generateParenthesis(results,str+")",left,right-1);
        }
    }


}
