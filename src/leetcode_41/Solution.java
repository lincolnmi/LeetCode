package leetcode_41;

/**
 * Created by Jason on 2016/5/14.
 */

/**
 * Problem definition:
 * Given an unsorted integer array, find the first missing positive integer.

 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.

 * Your algorithm should run in O(n) time and uses constant space.
 */

/**
 * Answer:
 * transverse the array from left to right
 * after processing location i, the location i put the right positive value i+1
 * if nums[i]<=0||nums[i]<i+1||nums[i]>len||nums[i]==nums[nums[i]-1], the invalid number, minus the length
 * otherwise swap(i,nums[i]-1)
 */
public class Solution {

    public int firstMissingPositive(int[] nums) {
        int i=0,len = nums.length;
        while (i<len) {
            if (nums[i]==i+1) {
                i++;
            } else if (nums[i]<=0||nums[i]<i+1||nums[i]>len||nums[i]==nums[nums[i]-1]) {
                nums[i] = nums[--len];
            } else {
                swap(nums,i,nums[i]-1);
            }
        }
        return i+1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
