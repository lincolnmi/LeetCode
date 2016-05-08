package leetcode_219;

import java.util.HashMap;

/**
 * Created by Jason on 2016/5/8.
 */

/**
 * Problem definition:
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j
 * in the array such that nums[i] = nums[j] and the difference between i and j is at most k.
 */

/**
 * Answer:
 * use a map to record the value and its index
 * in indice i, justify whether nums[i] has exsited before, if so compute the distance between these two duplicate indices
 * no larger than k, return true
 */
public class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i=0,len = nums.length;i<len;i++) {
            if (map.containsKey(nums[i])) {
                if (i-map.get(nums[i])<=k) {
                    return true;
                }
            }
            map.put(nums[i],i);
        }
        return false;
    }

}
