package leetcode_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Jason on 2016/4/26.
 */

/**
 * Problem definition:
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

 Note:
 Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 The solution set must not contain duplicate triplets.
 For example, given array S = {-1 0 1 2 -1 -4},

 A solution set is:
 (-1, 0, 1)
 (-1, -1, 2)
 */

/**
 * Answer:
 * Step 1: sort the array
 * Step 2: get the non-duplicate number from the array one by one
 * Step 3: transform the 3-sum problem into the 2-sum problem which removes the duplicate elements
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        for (int i=0;i<nums.length;i++) {
            while (i>=1&&i<nums.length&&nums[i]==nums[i-1]) {
                i++;
            }
            if (i>=nums.length) {
                break;
            }
            int target = 0 - nums[i];
            int j = i+1, k = nums.length - 1;
            while (j<k&&j<nums.length) {
                int value = nums[j] + nums[k];
                if (nums[j]+nums[k]==target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    lists.add(list);
                    j++;
                    while (j<k&&nums[j]==nums[j-1]) {
                        j++;
                    }
                    k--;
                    while (j<k&&nums[k]==nums[k+1]) {
                        k--;
                    }
                } else if (nums[j]+nums[k]>target) {
                    k--;
                    while (j<k&&nums[k]==nums[k+1]) {
                        k--;
                    }
                } else {
                    j++;
                    while (j<k&&nums[j]==nums[j-1]) {
                        j++;
                    }
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        int[] S = {-1,0,1,2,-1,-4};
        List<List<Integer>> results = new Solution().threeSum(S);
        for (List<Integer> result:results) {
            for (int value:result) {
                System.out.print(value+" ");
            }
            System.out.println();
        }
    }

}