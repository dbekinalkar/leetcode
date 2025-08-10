/*
 * @lc app=leetcode id=153 lang=cpp
 *
 * [153] Find Minimum in Rotated Sorted Array
 */

// @lc code=start
class Solution {
public:
    int findMin(vector<int>& nums) {
        int n = nums.size();
        int l = 0;
        int r = n;
        int m;
        while(l < r) {
            int m = l + (r - l) / 2;
            if(nums[m] <= nums[n - 1]) {
                r = m;
            }
            else {
                l = m + 1;
            }
        }

        return nums[l];
    }
};
// @lc code=end

