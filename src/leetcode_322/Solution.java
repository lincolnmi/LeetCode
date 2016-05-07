package leetcode_322;

import java.util.Arrays;

/**
 * Created by Jason on 2016/5/7.
 */

/**
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

 * Example 1:
 * coins = [1, 2, 5], amount = 11
 * return 3 (11 = 5 + 5 + 1)

 * Example 2:
 * coins = [2], amount = 3
 * return -1.

 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 */

/**
 * Answer:
 * let dp[i] means the minimum number of coins to make up i, initial all to -1
 * set dp[0]=0
 * transverse each coin
 *  if i<coin, means current cannot be used to make up i
 *  else if i>=coin and dp[i-coin]!=-1
 *  dp[i] = dp[i]>0?min(dp[i],dp[i-coin]+1):dp[i-coin]+1;
 */

public class Solution {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,-1);
        dp[0] = 0; // start from equal
        for (int i=0;i<=amount;i++) {
            for (int coin : coins) {
                if (i>=coin && dp[i-coin]!=-1) {
                    dp[i] = dp[i]>0?Math.min(dp[i],dp[i-coin]+1):dp[i-coin]+1;
                }
            }
        }
        return dp[amount];
    }

}
