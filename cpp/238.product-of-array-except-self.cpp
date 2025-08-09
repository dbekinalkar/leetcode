/*
 * @lc app=leetcode id=238 lang=cpp
 *
 * [238] Product of Array Except Self
 */

// @lc code=start
class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        vector<int> right(nums.size());
        right[nums.size() - 1] = 1;

        for(int i = nums.size() - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        int left = 1;

        for(int i = 0; i < nums.size(); i++) {
            right[i] *= left;
            left *= nums[i];
        }

        return right;
    }
};
// @lc code=end

