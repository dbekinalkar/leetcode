/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] rightPrefixProduct = new int[n];
        rightPrefixProduct[n-1] = 1;

        for(int i = n - 1; i > 0; i--) {
            rightPrefixProduct[i-1] = nums[i] * rightPrefixProduct[i];
        }

        int leftProduct = nums[0];

        int[] res = new int[n];
        res[0] = rightPrefixProduct[0];

        for(int i = 1; i < n; i++) {
            res[i] = leftProduct * rightPrefixProduct[i];

            leftProduct *= nums[i];
        }
        
        return res;
    }
}
// @lc code=end

