/*
 * @lc app=leetcode id=746 lang=java
 *
 * [746] Min Cost Climbing Stairs
 */

// @lc code=start
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] stairCosts = new int[n + 1];

        int currCost;

        for(int i = 2; i <= n; i++) {
            stairCosts[i] = Math.min(stairCosts[i-1] + cost[i-1], stairCosts[i-2] + cost[i-2]);
        }

        return stairCosts[n];
    }
}
// @lc code=end

