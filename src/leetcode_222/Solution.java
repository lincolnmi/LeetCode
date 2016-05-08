package leetcode_222;

/**
 * Created by Jason on 2016/5/8.
 */

/**
 * Problem definition:
 * Given a complete binary tree, count the number of nodes.
 */

/**
 * Answer:
 * count the left and right of each subtree
 * if equal means this subtree is full complete binary tree, use formula 2^height-1 to calculate the number of nodes
 * else recursively find the left and right subtree
 */

public class Solution {

    public int countNodes(TreeNode root) {
        if (root==null) {
            return 0;
        }
        int leftHeight = 0, rightHeight = 0;
        TreeNode leftNode = root, rightNode = root;
        while (leftNode!=null) {
            leftHeight++;
            leftNode = leftNode.left;
        }
        while (rightNode!=null) {
            rightHeight++;
            rightNode = rightNode.right;
        }
        if (leftHeight==rightHeight) {
            return (1<<leftHeight) - 1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

}
