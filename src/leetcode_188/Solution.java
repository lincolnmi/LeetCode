package leetcode_188;

/**
 * Created by Jason on 2016/5/4.
 */

/**
 * Problem Definition:
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 */

/**
 * Answer:
 * DP solution
 * f[i,j] represent the k transactions until the jth price, not end at j so we should need an variable to record the maxProfit
 * f[i,j]=max(f[i,j-1],f[i-1,k]+price[j]-price[k]) where k<=j
 * means f[i,j]=max(f[i,j-1],price[j]+max(f[i-1,k]-price[k]), where k<=j
 * Note that, max(f[i-1,k]-price[k]), where k<j, we can use a variable to keep the maximum value so far to avoid O(n) loop
 *
 * Further more
 * O(n) space complexity
 *
 * Special case:
 * if k >= prices.size()/2, since maximum count of transaction is prices.size()/2, we can make the maximum transactions
 * this case is important since k is large enough, time and space will cost a lot.
 */
public class Solution {

    public int maxProfit(int k, int[] prices) {
        if (prices==null||prices.length==0) {
            return 0;
        } else {
            int n = k, m = prices.length;
            if (k>=m/2) {
                int maxProfit = 0;
                for (int i=1;i<m;i++) {
                    maxProfit += Math.max(prices[i]-prices[i-1],0);
                }
                return maxProfit;
            }
            int[][] profits = new int[n+1][m];
            for (int i=1;i<=n;i++) {
                int temp = profits[i-1][0] - prices[0];
                for (int j=1;j<m;j++) {
                    temp = Math.max(temp,profits[i-1][j]-prices[j]);
                    profits[i][j] = Math.max(profits[i][j-1],prices[j]+temp);
                }
            }
            return profits[n][m-1];
        }
    }

    public int maxProfit2(int k, int[] prices) {
        if (prices==null||prices.length==0) {
            return 0;
        } else {
            int n = k, m = prices.length;
            if (k>=m/2) {
                int maxProfit = 0;
                for (int i=1;i<m;i++) {
                    maxProfit += Math.max(prices[i]-prices[i-1],0);
                }
                return maxProfit;
            }
            int[] profits = new int[m];
            for (int i=1;i<=n;i++) {
                int temp = profits[0] - prices[0];
                for (int j=1;j<m;j++) {
                    temp = Math.max(temp,profits[j]-prices[j]);
                    profits[j] = Math.max(profits[j-1],prices[j]+temp);
                }
            }
            return profits[m-1];
        }
    }
}
