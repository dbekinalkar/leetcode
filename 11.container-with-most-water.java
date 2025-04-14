/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int l, r;
        l = 0;
        r = height.length - 1;

        int max = 0;

        while(l < r) {
            max = Math.max(max, Math.min(height[l], height[r]) * (r - l));

            if(height[l] < height[r]) {
                l++;
            }
            else {
                r--;
            }
        }

        return max;
    }
}
// @lc code=end

