/*
 * @lc app=leetcode id=121 lang=cpp
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int max = 0;
        int profit = 0;

        auto prev = prices.begin();

        for(auto curr = std::next(prev); curr != prices.end(); ++curr) {
            profit += *curr - *prev;
            profit = std::max(profit, 0);
            max = std::max(max, profit);
            prev = curr;
        }

        return max;
    }
};
// @lc code=end

