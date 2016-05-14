package leetcode_162;

/**
 * Created by Jason on 2016/5/14.
 */

/**
 * Problem definition:
 * transverse from the left to the right to get first value which less than the left value
 * the left value is the wanted peak
 */
public class Solution {

    public int findPeakElement(int[] nums) {
        int minValue = Integer.MIN_VALUE, i = 0, len = nums.length;
        for (;i<len;i++) {
            if (minValue<=nums[i]) {
                minValue = nums[i];
            } else {
                break;
            }
        }
        return i-1;
    }

}
