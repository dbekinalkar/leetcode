/*
 * @lc app=leetcode id=16 lang=java
 *
 * [16] 3Sum Closest
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int diff = Integer.MAX_VALUE;
        boolean negative = false;

        int l, r, sum, abs;
        for(int i = 0; i < nums.length - 2; i++) {
            l = i + 1;
            r = nums.length - 1;
            while(l < r) {
                sum = nums[l] + nums[r] + nums[i] - target;
                abs = Math.max(sum, -1 * sum);

                if(abs < diff) {
                    diff = abs;
                    negative = sum < 0;
                }
                
                if(sum < 0) {
                    l++;
                }
                else {
                    r--;
                }
            }
        }

        if(negative) diff *= -1;

        return target + diff;
    }
}
// @lc code=end

