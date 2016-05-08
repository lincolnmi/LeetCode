package leetcode_108;

/**
 * Created by Jason on 2016/5/8.
 */

/**
 * Problem definition:
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */

/**
 * Answer:
 * start from the middle element to construct the balanced BST
 */
public class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums==null||nums.length==0) {
            return null;
        }
        return sortedArrayToBST(nums,0,nums.length-1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left<=right) {
            int mid = (right-left)/2+left;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = sortedArrayToBST(nums,left,mid-1);
            node.right = sortedArrayToBST(nums,mid+1,right);
            return node;
        } else {
            return null;
        }
    }

}
