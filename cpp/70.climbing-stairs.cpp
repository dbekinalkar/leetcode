/*
 * @lc app=leetcode id=70 lang=cpp
 *
 * [70] Climbing Stairs
 */

// @lc code=start
class Solution {
public:
    int climbStairs(int n) {
        vector<int> dp(3);
        dp[0] = 1;

        for(int i = 0; i < n; i++) {
            dp[(i + 1) % 3] += dp[i % 3];
            dp[(i + 2) % 3] += dp[i % 3];
            dp[i % 3] = 0;
        }

        return dp[n % 3];
    }
};
// @lc code=end

