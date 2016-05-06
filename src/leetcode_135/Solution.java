package leetcode_135;

/**
 * Created by Jason on 2016/5/6.
 */

/**
 * Problem definition:
 * There are N children standing in a line. Each child is assigned a rating value.

 * You are giving candies to these children subjected to the following requirements:

 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 */

/**
 * Answer:
 * find the increasing and the decreasing sequences on the top peak respectively, calculate the assigning candies,
 * remove the duplicate candy
 *
 * if rating[i]==ratings[i-1], non duplicate situation
 */
public class Solution {

    public int candy(int[] ratings) {
        if (ratings==null||ratings.length<1) {
            return 0;
        }
        int total = 0,current = ratings[0],count = 1, n = ratings.length;
        int left = 1, right = 1, i = 1;
        while (i<n) {
            while (i<n&&ratings[i]>ratings[i-1]) {
                left++;
                i++;
            }
            while (i<n&&ratings[i]<ratings[i-1]) {
                right++;
                i++;
            }
            if (i<n&&ratings[i]==ratings[i-1]) {
                i++;
                total += 1;
            }
            total += getCount(left,right);
            left = 1;
            right = 1;
            total -= 1;
        }
        total += getCount(left,right);
        return total;
    }

    private int getCount(int left,int right) {
        int total = 0, max = Math.max(left,right), min = Math.min(left,right);
        total += (1+max)*max/2 + (1+min-1)*(min-1)/2;
        return total;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,2,2};
        Solution solution = new Solution();
        solution.candy(nums);
    }

}
