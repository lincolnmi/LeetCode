package leetcode_122;

/**
 * Created by Jason on 2016/5/4.
 */

/**
 * Problem Definition
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 * (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time
 * (ie, you must sell the stock before you buy again).
 */

/**
 * Answer:
 * given two examples:
 * a<=b<=c<=d, maxProfit = d - a = (d-c)+(c-b)+(b-a)
 * a<=b>=b'<=c<=d, maxProfit = (b-a) + (d-b')
 * so, the problem can be transformed to find monotone sequence
 */
public class Solution {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i=1;i<prices.length;i++) {
            maxProfit += Math.max(prices[i]-prices[i-1],0);
        }
        return maxProfit;
    }

}
