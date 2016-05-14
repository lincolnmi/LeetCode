package leetcode_153;

/**
 * Created by Jason on 2016/5/14.
 */

/**
 * Problem definition:
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * You may assume no duplicate exists in the array.
 */

/**
 * Answer:
 * basic method
 * transverse the array from the left to the right until the current value is not larger than the rightmost value
 *
 * advanced method:
 * binary search
 * if left_value < right_value, return left_value
 * if left_value<=mid_value, left = mid + 1, means the minimum value in the right
 * if left_value>mid_value, right = mid, means the minimum value in the left, here right is mid rather than mid+1,
 * because the current mid value may be the minimum value
 */
public class Solution {

    /* basic method
    public int findMin(int[] nums) {
        int len = nums.length, i = 0;
        while (len>1&&nums[i]>nums[len-1]) {
            i++;
        }
        return nums[i];
    }*/

    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;
        while (left<right) {
            int mid = left + (right-left) / 2;
            if (nums[left]<nums[right]) {
                return nums[left];
            } else if (nums[left]<=nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

}
