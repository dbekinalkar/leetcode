/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        Integer val;

        for(int i = 0; i < nums.length; i++) {
            val = map.getOrDefault(nums[i], null);
            if(val != null) {
                res[0] = val;
                res[1] = i;

                return res;
            }

            map.put(target - nums[i], i);
        
        }

        return res;
    }
}
// @lc code=end

