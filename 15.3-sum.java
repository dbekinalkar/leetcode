/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList();

        Arrays.sort(nums);

        int i, l, r, total;

        for(i = 0; i < nums.length-2; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;

            l = i + 1;
            r = nums.length - 1;

            while(l < r) {
                total = nums[i] + nums[l] + nums[r];
                if(total == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while(l < r && nums[l] == nums[l+1]) {
                        l++;
                    }
                    l++;

                    while(l < r && nums[r] == nums[r-1]) {
                        r--;
                    }
                    r--;
                }
                else if(total < 0) {
                    l++;
                }
                else {
                    r--;
                }
            }
        }

        return res;
    }
}
// @lc code=end

