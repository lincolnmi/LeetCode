package leetcode_217;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Jason on 2016/5/8.
 */

/**
 * Problem definition:
 * Given an array of integers, find if the array contains any duplicates. Your function should return true
 * if any value appears at least twice in the array, and it should return false if every element is distinct.
 */

/**
 * Answer:
 * using hashset to store numbers
 * hashset is faster than hashmap
 */
public class Solution {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i=0,len=nums.length;i<len;i++) {
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
        }
        return false;
    }

}
