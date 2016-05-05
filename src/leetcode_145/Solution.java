package leetcode_145;

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
 * return [3,2,1].
 */

/**
 * Answer:
 * non-recursion transverse
 * if the right node has not been output, push to the stack
 * else output
 * how to justify the right node has not been output
 * use the pre variable to record pre output node, if current.right == pre, has output else not.
 */
public class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;
        TreeNode pre = null;
        while (current!=null) {
            stack.push(current);
            current = current.left;
        }
        while (!stack.empty()) {
            TreeNode top = stack.pop();
            if (top.right!=null) {
                if (pre!=null&&top.right==pre) {
                    result.add(top.val);
                    pre = top;
                } else {
                    stack.push(top);
                    current = top.right;
                    while (current != null) {
                        stack.push(current);
                        current = current.left;
                    }
                }
            } else {
                result.add(top.val);
                pre = current;
            }
        }
        return result;
    }

}
