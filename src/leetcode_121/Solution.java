package leetcode_121;

/**
 * Created by Jason on 2016/5/4.
 */

/**
 * Problem definition
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit.
 */

/**
 * find the minimum price and maximum profit one by one O(n)
 */

public class Solution {

    public int maxProfit(int[] prices) {
        if (prices==null||prices.length==0) {
            return 0;
        }
        int minPrice = prices[0], maxProfit = 0;
        for (int price:prices) {
            maxProfit = Math.max(maxProfit,price-minPrice);
            minPrice = Math.min(minPrice,price);
        }
        return maxProfit;
    }

}
