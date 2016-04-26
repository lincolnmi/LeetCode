package leetcode_18;

/**
 * Created by Jason on 2016/4/26.
 */

/**
 * Problem Definition:
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

 Note:
 Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 The solution set must not contain duplicate quadruplets.
 For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

 A solution set is:
 (-1,  0, 0, 1)
 (-2, -1, 1, 2)
 (-2,  0, 0, 2)
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Answer:
 * Transform 4-sum to 3-sum, further to 2-sum
 * Step 1: sort the array
 * Step 2: choose the first number and the second number (non-duplicate), transform into 2 sum problem
 * Step 3: using the 2-sum method to solve, now the target = target - first - second
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        HashMap<Integer,List<Integer>> maps = new HashMap<Integer,List<Integer>>();
        for (int i=0;i<nums.length;i++) {
            while (i>=1&&i<nums.length&&nums[i]==nums[i-1]) {
                i++;
            }
            if (i>=nums.length) {
                break;
            }
            for (int j=i+1;j<nums.length;j++) {
                while (j>=i+2&&j<nums.length&&nums[j]==nums[j-1]) {
                    j++;
                }
                if (j>=nums.length) {
                    break;
                }

                int value = target - nums[i] - nums[j];
                if (maps.get(value)==null) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);list.add(nums[j]);
                    maps.put(value,list);
                } else {
                    List<Integer> list = maps.get(value);
                    list.add(nums[i]);list.add(nums[j]);
                    lists.add(list);
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        int[] S = {-1,0,1,2,-1,-2};
        List<List<Integer>> results = new Solution().fourSum(S,0);
        for (List<Integer> result:results) {
            for (int value:result) {
                System.out.print(value+" ");
            }
            System.out.println();
        }
    }

}
