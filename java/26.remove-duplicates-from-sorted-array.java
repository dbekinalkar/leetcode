/*
 * @lc app=leetcode id=26 lang=java
 *
 * [26] Remove Duplicates from Sorted Array
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int unique = 1;

        int uniqueIdx = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i - 1]) continue;

            unique++;
            nums[uniqueIdx] = nums[i];
            uniqueIdx++;
        }

        return unique;
    }
}
// @lc code=end

