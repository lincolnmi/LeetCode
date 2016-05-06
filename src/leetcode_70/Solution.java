package leetcode_70;

/**
 * Created by Jason on 2016/5/6.
 */

/**
 * Problem definition:
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */

/**
 * Answer:
 * fibonacci array
 * recursion will timeout, just one-time transverse
 */
public class Solution {

    public int climbStairs(int n) {
        /**
         * Time limited
         * if (n==0||n==1) {
         * return 1;
         * } else if (n==2) {
         * return 2;
         * } else {
         * return climbStairs(n-1) + climbStairs(n-2);
         * }
         */
        if (n==0||n==1) {
            return 1;
        } else if (n==2) {
            return 2;
        } else {
            int first = 1, second = 2,total = 0;
            for (int i=3;i<=n;i++) {
                total = first+second;
                first = second;
                second = total;
            }
            return total;
        }
    }

}
