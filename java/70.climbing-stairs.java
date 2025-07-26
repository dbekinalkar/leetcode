/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        int[] steps = new int[n + 2];
        steps[0] = 1;

        for(int i = 0; i < n; i++) {
            steps[i + 1] += steps[i];
            steps[i + 2] += steps[i];
        }

        return steps[n];
    }
}
// @lc code=end

