package leetcode_114;

import java.util.Stack;

/**
 * Created by Jason on 2016/5/14.
 */

/**
 * Problem definition:
 * Given a binary tree, flatten it to a linked list in-place.

 * For example,
*  Given

 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * The flattened tree should look like:
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */

/**
 * Answer:
 * pre.right = root.right
 * root.right = root.left
 * root.left = null
 *
 * where is the pre
 * pre is the right most root.left
 */
public class Solution {

    public void flatten(TreeNode root) {
        while (root!=null) {
            TreeNode pre = root.left;
            if (pre!=null) {
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }

}
