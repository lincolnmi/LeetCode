package leetcode_94;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jason on 2016/5/4.
 */

/**
 * Problem definition:
 * Given a binary tree, return the inorder traversal of its nodes' values.

 * For example:
 * Given binary tree {1,#,2,3},
 * 1
 * \
 *  2
 * /
 * 3
 * return [1,3,2].
 */

/**
 * Answer:
 * basic inorder binary tree
 */
public class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        inorderTraversal(list,root);
        return list;
    }

    private void inorderTraversal(List<Integer> list, TreeNode current) {
        if (current!=null) {
            inorderTraversal(list,current.left);
            list.add(current.val);
            inorderTraversal(list,current.right);
        }
    }


}
