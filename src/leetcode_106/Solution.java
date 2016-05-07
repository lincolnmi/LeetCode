package leetcode_106;

import java.util.Arrays;

/**
 * Created by Jason on 2016/5/7.
 */

/**
 * Problem definition:
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 */

/**
 * Answer:
 * get the postorder last element which is root value of subtree
 * use this value to split inorder
 * recurse it
 */
public class Solution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder==null||inorder.length==0||postorder==null||postorder.length==0) {
            return null;
        } else {
            int len = inorder.length, value = postorder[len-1], i = 0;
            TreeNode node = new TreeNode(value);
            for (;i<len;i++) {
                if (inorder[i]==value) {
                    break;
                }
            }
            node.left = buildTree(splitArray(inorder, 0, i),splitArray(postorder, 0, i));
            node.right = buildTree(splitArray(inorder, i + 1, len), splitArray(postorder,i,len-1));
            return node;
        }
    }

    private int[] splitArray(int[] array,int from, int to) {
        if (to-from>=1) {
            return Arrays.copyOfRange(array,from,to);
        } else {
            return null;
        }
    }

}
