package leetcode_287;

/**
 * Created by Jason on 2016/5/14.
 */

/**
 * Problem definition:
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

 * Note:
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 */

/**
 * Answer:
 * transverse the array from left to right
 * after process the index i, the index i has the right value (i+1)
 * if nums[i]==i+1, i++
 * if nums[i] == nums[nums[i]] or nums[i]<i+1, duplicate number exists
 * else swap(nums[i],nums[nums[i]])
 */
public class Solution {

    public int findDuplicate(int[] nums) {
        int i = 0, len = nums.length;
        while (i<len) {
            if (nums[i]==i+1) {
                i++;
            } else if (nums[i]<i+1) {
                break;
            } else {
                swap(nums,i,nums[i]);
            }
        }
        return nums[i];
    }

    private void swap(int[] array,int i,int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
