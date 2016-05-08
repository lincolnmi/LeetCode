package leetcode_220;

import java.util.HashMap;

/**
 * Created by Jason on 2016/5/8.
 */

/**
 * Problem definition:
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such that the
 * difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k.
 */

/**
 * Answer:
 * use a bucket to solve range (window size)
 * bucket size is 3, so (0,1,2) is map to the first bucket
 *
 * since (0,3) also satisfy the distance 3, so we also need to justify bucket-1 and bucket+1
 * the number of bucket is used to control the index distance
 */
public class Solution {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k<1||t<0) {
            return false;
        }
        HashMap<Long,Long> map = new HashMap<Long, Long>();
        long bucketSize = (long)t + 1;
        for (int i=0;i<nums.length;i++) {
            long num = (long)nums[i]-Integer.MIN_VALUE;
            long bucket = num / bucketSize;
            if (map.containsKey(bucket)
                    ||(map.containsKey(bucket-1)&&Math.abs(map.get(bucket-1)-num)<=t)
                    ||(map.containsKey(bucket+1)&&Math.abs(map.get(bucket+1)-num)<=t)) {
                return true;
            }
            if (map.entrySet().size()>=k) {
                map.remove(((long)nums[i-k]-Integer.MIN_VALUE)/bucketSize);
            }
            map.put(bucket,num);
        }
        return false;
    }

}

