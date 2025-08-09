/*
 * @lc app=leetcode id=268 lang=cpp
 *
 * [268] Missing Number
 */

// @lc code=start
class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int total = nums.size() * (nums.size() + 1) / 2;

        for(int num : nums) {
            total -= num;
        }

        return total;
    }
};
// @lc code=end

