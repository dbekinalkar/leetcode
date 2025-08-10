/*
 * @lc app=leetcode id=33 lang=cpp
 *
 * [33] Search in Rotated Sorted Array
 */

// @lc code=start
class Solution {
public:
    int search(vector<int>& nums, int target) {
        int l = 0;
        int r = nums.size() - 1;
        int m;

        while (l <= r) {
            m = l + (r - l) / 2;

            if (nums[m] == target) {
                return m;
            } 
            else if (nums[m] >= nums[l]) {
                if (nums[l] <= target && target <= nums[m]) {
                    r = m - 1;
                } 
                else {
                    l = m + 1;
                }
            } 
            else {
                if (nums[m] <= target && target <= nums[r]) {
                    l = m + 1;
                } 
                else {
                    r = m - 1;
                }
            }
        }

        return -1;  
    }
};
// @lc code=end

