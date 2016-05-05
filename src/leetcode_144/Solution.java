package leetcode_144;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Jason on 2016/5/5.
 */

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.

 * For example:
 * Given binary tree {1,#,2,3},
 * 1
 *  \
 *   2
 *  /
 * 3
 * return [1,2,3].
 */

/**
 * Answer:
 * non-recursion transverse
 * use a stack to store passing node and record the value immediately
 */
public class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root==null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;
        while (current!=null) {
            stack.push(current);
            result.add(current.val);
            current = current.left;
        }
        while (!stack.empty()) {
            TreeNode top = stack.pop();
            current = top.right;
            while (current!=null) {
                stack.push(current);
                result.add(current.val);;
                current = current.left;
            }
        }
        return result;
    }

}
