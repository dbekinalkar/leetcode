/*
 * @lc app=leetcode id=746 lang=cpp
 *
 * [746] Min Cost Climbing Stairs
 */

// @lc code=start
class Solution {
public:
    int minCostClimbingStairs(vector<int>& cost) {
        vector<int> dp(3, INT_MAX);
        dp[0] = 0;
        dp[1] = 0;

        for(int i = 0; i < cost.size(); i++) {
            dp[(i + 1) % 3] = std::min(dp[(i + 1) % 3], dp[i % 3] + cost[i]);
            dp[(i + 2) % 3] = std::min(dp[(i + 2) % 3], dp[i % 3] + cost[i]);
            dp[i % 3] = INT_MAX;
        }

        return dp[cost.size() % 3];
    }
};
// @lc code=end

