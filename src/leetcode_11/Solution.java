package leetcode_11;

/**
 * Created by Jason on 2016/5/8.
 */

/**
 * Problem definition:
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * You may not slant the container.
 */

/**
 * Answer:
 * start from the widest container
 * then the container goes to less wide where height must be higher than before
 * get the max water
 */

public class Solution {

    public int maxArea(int[] height) {
        if (height==null||height.length==0) {
            return 0;
        }
        int water = 0, i =0, j = height.length - 1;
        while (i<j) {
            int h = Math.min(height[i],height[j]);
            water = Math.max(water,(j-i)*h);
            while (i<j&&height[i]<=h) {
                i++;
            }
            while (i<j&&height[j]<=h){
                j--;
            }
        }
        return water;
    }

}
