package leetcode_173;

import java.util.Stack;

/**
 * Created by Jason on 2016/5/4.
 */

/**
 * Problem definition:
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 */

/**
 * Answer:
 * use the stack to help us traverse, similar as non-recursion traverse binary tree
 */
public class BSTIterator {
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        TreeNode current = root;
        while (current!=null) {
            stack.push(current);
            current = current.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return stack.empty()==false;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode top = stack.pop();
        TreeNode current = top.right;
        while (current != null) {
            stack.push(current);
            current = current.left;
        }
        return top.val;

    }
}
