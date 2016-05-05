package leetcode_103;

import java.util.*;

/**
 * Created by Jason on 2016/5/5.
 */

/**
 * Problem definition
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *   3
 *  / \
 * 9  20
 * /  \
 * 15   7
 * return its zigzag level order traversal as:
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 */

/**
 * Answer:
 * non-recursion version:
 *
 * level transverse, reverse result at even level
 *
 * recursion version:
 * use the level variable to control each level
 */
public class Solution {

    /**
     * non-recursion version
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        boolean order = true;
        if (root==null) {
            return results;
        } else {
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(root);
            int count = 1,level = 1;
            while (!queue.isEmpty()) {
                List<Integer> result = new ArrayList<Integer>();
                for (int i=0;i<count;i++) {
                    TreeNode node = queue.remove();
                    if (order) {
                        result.add(node.val);
                    } else {
                        result.add(0,node.val);
                    }
                    if (node.left!=null) {
                        queue.add(node.left);
                    }
                    if (node.right!=null) {
                        queue.add(node.right);
                    }
                }
                order = order ? false : true;
                results.add(result);
                count = queue.size();
            }
        }
        return results;
    }

    /**
     * recursion version
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder_recursion(TreeNode root) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        boolean order = true;
        if (root==null) {
            return results;
        } else {
            helper(root,results,0);
        }
        return results;
    }

    private void helper(TreeNode root, List<List<Integer>> results, int level) {
        if (root==null) {
            return;
        }
        if (results.size()<=level) {
            results.add(new ArrayList<Integer>());
        }
        List<Integer> result = results.get(level);
        if (level%2==0) {
            result.add(root.val);
        } else {
            result.add(0,root.val);
        }
        helper(root.left,results,level+1);
        helper(root.right,results,level+1);
    }

}
