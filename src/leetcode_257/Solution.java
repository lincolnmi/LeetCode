package leetcode_257;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jason on 2016/5/5.
 */

/**
 * Given a binary tree, return all root-to-leaf paths.
 * For example, given the following binary tree:
 *   1
 *  / \
 * 2   3
 * \
 *  5
 * All root-to-leaf paths are:
 *["1->2->5", "1->3"]
 */

/**
 * Answer:
 * leaf: add path to the list
 * non-leaf: add to path
 */
public class Solution {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if (root==null) {
            return result;
        } else {
            String path = "";
            binaryTreePaths(result, path, root);
            return result;
        }
    }

    private void binaryTreePaths(List<String> result, String path, TreeNode root) {
        if (root==null) {
            return;
        } else if (root.left==null&&root.right==null) {
            if (path.equals("")) {
                path += root.val;
            } else {
                path += "->" + root.val;
            }
            result.add(path);
        } else {
            if (path.equals("")) {
                path += root.val;
            } else {
                path += "->" + root.val;
            }
            binaryTreePaths(result,path,root.left);
            binaryTreePaths(result,path,root.right);
        }
    }

}
