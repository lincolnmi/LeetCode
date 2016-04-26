package leetcode_16;

/**
 * Created by Jason on 2016/4/26.
 */

/** Problem Definition:
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 Return the sum of the three integers. You may assume that each input would have exactly one solution.

 For example, given array S = {-1 2 1 -4}, and target = 1.
 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */

import java.util.Arrays;
import java.util.List;

/**
 * Answer:
 * Step 1: sort the array, the length is n
 * Step 2: choose the non-duplicate element one by one, suppose the current index is i
 * Step 3: set j = i+1, k = n-1;
 * Step 4: binary search(j,k) compute value = array[i]+array[j]+array[k],
 * minInterval=min(|value-target|,minInterval)
 *
 * enhanced binary search
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = 1000000;
        int v = -1;
        for (int i=0;i<nums.length;i++) {
            while (i>=1&&i<nums.length&&nums[i]==nums[i-1]) {
                i++;
            }
            if (i>=nums.length) {
                break;
            }
            int j = i + 1, k = nums.length - 1;
            while (j<k) {
                int value = nums[i] + nums[j] + nums[k];
                if (value>target) {
                    k--;
                    if (value-target<min) {
                        min = value-target;
                        v = value;
                    }
                    while (j<k&&nums[k]==nums[k+1]) {
                        k--;
                    }
                } else if (value==target) {
                    return target;
                } else {
                    j++;
                    if (target-value<min) {
                        min = target-value;
                        v = value;
                    }
                    while (j<k&&nums[j]==nums[j-1]) {
                        j++;
                    }
                }
            }
        }
        return v;
    }

    public static void main(String[] args) {
        int[] S = {-1,0,1,2,-1,-4};
        int value = new Solution().threeSumClosest(S,1);
        System.out.println(value);
    }
}
