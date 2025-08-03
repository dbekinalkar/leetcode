/*
 * @lc app=leetcode id=153 lang=java
 *
 * [153] Find Minimum in Rotated Sorted Array
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n;
        int m;
        while(l < r) {
            m = l + (r - l) / 2;

            if(nums[m] > nums[n-1]) {
                l = m + 1;
            }
            else {
                r = m;
            }
        }

        return  nums[l];
    }
}
// @lc code=end

