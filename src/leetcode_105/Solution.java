package leetcode_105;

import leetcode_106.*;

import java.util.Arrays;

/**
 * Created by Jason on 2016/5/7.
 */

/**
 * Problem definition:
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 */

/**
 * Answer:
 * get the preorder first element which is root value of subtree
 * use this value to split inorder
 * recurse it
 */

public class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder==null||inorder.length==0||preorder==null||preorder.length==0) {
            return null;
        } else {
            int len = inorder.length, value = preorder[0], i = 0;
            TreeNode node = new TreeNode(value);
            for (;i<len;i++) {
                if (inorder[i]==value) {
                    break;
                }
            }
            node.left = buildTree(splitArray(preorder, 1, i+1),splitArray(inorder, 0, i));
            node.right = buildTree(splitArray(preorder, i+1, len), splitArray(inorder,i+1,len));
            return node;
        }
    }

    private int[] splitArray(int[] array,int from, int to) {
        if (to-from>=1) {
            return Arrays.copyOfRange(array, from, to);
        } else {
            return null;
        }
    }

}
