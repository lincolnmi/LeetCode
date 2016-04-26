package leetcode_110;

/**
 * Created by Jason on 2016/4/26.
 */

/**
 * Problem definition
 Given a binary tree, determine if it is height-balanced.

 For this problem, a height-balanced binary tree is defined as a binary tree in which
 the depth of the two subtrees of every node never differ by more than 1.
 */

/**
 * Answer:
 transverse recursively
 check the left and right height of each node, valid when and only when the abs(left-height)<=1
 */

public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root==null) {
            return true;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.abs(left - right)<=1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int getHeight(TreeNode node) {
        if (node==null) {
            return 0;
        } else {
            return Math.max(getHeight(node.left),getHeight(node.right))+1;
        }
    }
}
