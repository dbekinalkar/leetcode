/*
 * @lc app=leetcode id=27 lang=java
 *
 * [27] Remove Element
 */

// @lc code=start
class Solution {
    public int removeElement(int[] nums, int val) {
        int not_val = 0;
        int not_val_index = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == val) continue;

            not_val++;

            nums[not_val_index] = nums[i];
            not_val_index++;
        }


        return not_val;
    }
}
// @lc code=end

