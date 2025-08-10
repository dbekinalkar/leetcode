/*
 * @lc app=leetcode id=11 lang=cpp
 *
 * [11] Container With Most Water
 */

// @lc code=start
class Solution {
public:
    int maxArea(vector<int>& height) {
        int l = 0;
        int r = height.size() - 1;

        int max = 0;

        while(l < r) {
            int area = (r - l) * std::min(height[l], height[r]);
            max = std::max(max, area);

            if(height[l] < height[r]) {
                l++;
            }
            else {
                r--;
            }
        }

        return max;
    }
};
// @lc code=end

