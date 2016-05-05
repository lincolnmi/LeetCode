package leetcode_199;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jason on 2016/5/5.
 */

/**
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 * For example:
 * Given the following binary tree,
 *     1            <---
 *   /   \
 *  2     3         <---
 *   \     \
 *    5     4       <---
 *You should return [1, 3, 4].
 */

/**
 * Answer:
 * recursion transverse
 * use a variable level to record the current transverse level,
 * if the current recorded variables less than level, that means that level is not been recorded
 * else has been recorded, break that level
 */
public class Solution {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightSideView(root,result,1);
        return result;
    }

    private void rightSideView(TreeNode root,List<Integer> result,int level) {
        if (root==null) {
            return;
        } else {
            if (result.size()<level) {
                result.add(root.val);
            }
            rightSideView(root.right,result,level+1);
            rightSideView(root.left,result,level+1);
        }
    }

}
