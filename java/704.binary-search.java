/*
 * @lc app=leetcode id=704 lang=java
 *
 * [704] Binary Search
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        int m;

        while(l < r) {
            m = (l + r) / 2;
            if(nums[m] == target) {
                return m;
            }
            else if(nums[m] < target) {
                l = m + 1;
            }
            else if(nums[m] > target) {
                r = m;
            }
        }

        return -1;
    }
}
// @lc code=end

