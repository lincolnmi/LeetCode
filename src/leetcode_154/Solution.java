package leetcode_154;

/**
 * Created by Jason on 2016/5/14.
 */

/**
 * Problem definition:
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * The array may contain duplicates.
 */

/**
 * Answer:
 * use the mid value compares to the right value
 * if nums[mid]>nums[right] left = mid + 1
 * else if nums[mid]<nums[right] right = mid
 * else right--
 */
public class Solution {

    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;
        while (left<right) {
            int mid = left + (right-left) / 2;
            if (nums[mid]>nums[right]) {
                left = mid + 1;
            } else if (nums[mid]<nums[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        return nums[left];
    }
}
