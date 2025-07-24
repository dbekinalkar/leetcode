/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int profit = 0;
        for(int i = 1; i < prices.length; i++) {
            profit += prices[i] - prices[i-1];
            maxProfit = Math.max(maxProfit, profit);
            if(profit < 0) profit = 0;
        }

        return maxProfit;
    }
}
// @lc code=end

