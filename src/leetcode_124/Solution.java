package leetcode_124;

/**
 * Created by Jason on 2016/5/4.
 */

/**
 * Problem definition:
 * Given a binary tree, find the maximum path sum.
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path does not need to go through the root.
 * For example:
 * Given the below binary tree,
 *   1
 *  / \
 * 2   3
 * Return 6.
 */

/**
 * Answer:
 * recursion, global variable maxSum and local variable each path sum
 */
public class Solution {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root==null) {
            return 0;
        }
        DFS(root);
        return maxSum;
    }

    private int DFS(TreeNode root) {
        if (root!=null) {
            int left = DFS(root.left);
            int right = DFS(root.right);
            maxSum = Math.max(maxSum,root.val + ((left>0)?left:0) + ((right>0)?right:0));
            return root.val + Math.max(Math.max(left,right),0);
        }
        return 0;
    }

}
