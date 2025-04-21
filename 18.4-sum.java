/*
 * @lc app=leetcode id=18 lang=java
 *
 * [18] 4Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList();


        Arrays.sort(nums);

        int i, j, l, r;
        long total;

        for(i = 0; i < nums.length - 3; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;

            for(j = i + 1; j < nums.length - 2; j++) {
                if(j > i + 1 && nums[j] == nums[j-1]) continue;

                l = j + 1;
                r = nums.length - 1;


                while(l < r) {
                    total = (long) nums[i] + nums[j] + nums[l] + nums[r];


                    if(total == target) {
                        res.add(List.of(nums[i], nums[j], nums[l], nums[r]));

                        while(l < r && nums[l] == nums[l+1]) {
                            l++;
                        }
                        l++;

                        while(l < r && nums[r] == nums[r-1]) {
                            r--;
                        }
                        r--;
                    }
                    else if(total < target) {
                        l++;
                    }
                    else {
                        r--;
                    }
                }
            }
        }


        return res;
    }
}
// @lc code=end

