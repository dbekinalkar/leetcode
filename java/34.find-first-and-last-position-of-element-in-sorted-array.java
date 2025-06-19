/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if(nums.length == 0) { 
            return res;
        }

        int l, r, mid;

        l = 0;
        r = nums.length - 1;
        while(l <= r) {
            mid = (l + r) / 2;
            if(nums[mid] < target) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }

        if(l < 0 || l >= nums.length || nums[l] != target) {
            return res;
        }

        res[0] = l;

        l = 0;
        r = nums.length - 1;
        while(l <= r) {
            mid = (l + r) / 2;
            if(nums[mid] <= target) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }

        res[1] = r;

        return res;
    }
}
// @lc code=end

