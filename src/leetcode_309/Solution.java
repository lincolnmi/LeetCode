package leetcode_309;

/**
 * Created by Jason on 2016/5/4.
 */

/**
 * Problem definition:
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 * (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 */

/**
 * Answer:
 * buy[i] means the maximum profit at the end of ith day, at day i can choose buy or rest
 * sell[i] means the maximum profit at the end of ith day with sell, at day i can choose sell or rest
 * rest[i] means the maximum profit at the end of ith day with rest, at day i must rest
 *
 * buy[i] = max(rest[i-1]-price[i],buy[i-1])  //buy or rest
 * sell[i] = max(buy[i-1]+price[i],sell[i-1]) //sell or rest
 * rest[i] = max(buy[i-1],sell[i-1],rest[i-1])//rest
 *
 * note that buy[i]<=rest[i]<=sell[i], that means rest[i]=sell[i-1]
 *
 * so
 * buy[i] = max(sell[i-2]-price[i],buy[i-1])
 * sell[i] = max(buy[i-1]+price[i],sell[i-1])
 *
 * Further
 * since states of day i relies only on i-1 and i-2 we can reduce the O(n) space to O(1).
 */
public class Solution {

    public int maxProfit(int[] prices) {
        int pre_buy, buy = Integer.MIN_VALUE, pre_sell = 0, sell = 0;
        for (int price:prices) {
            pre_buy = buy;
            buy = Math.max(pre_sell-price,pre_buy);
            pre_sell = sell;
            sell = Math.max(pre_buy+price,pre_sell);
        }
        return sell;
    }

}
