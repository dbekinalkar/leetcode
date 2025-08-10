/*
 * @lc app=leetcode id=15 lang=cpp
 *
 * [15] 3Sum
 */

// @lc code=start
class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        std::vector<std::vector<int>> res;

        std::sort(nums.begin(), nums.end());

        int i, r, l, sum;
        i = 0;

        for(int i = 0; i < nums.size() - 2; i++) {
            
            if(i > 0 && nums[i] == nums[i-1]) continue;

            l = i + 1;
            r = nums.size() - 1;

            while(l < r) {
                sum = nums[i] + nums[l] + nums[r];
                if(sum == 0) {
                    res.push_back({nums[i], nums[l], nums[r]});
                }

                if(sum <= 0) {
                    do {
                        l++;
                    } while(l < r && nums[l] == nums[l - 1]);
                }

                if(sum >= 0) {
                    do {
                        r--;
                    } while(l < r && nums[r] == nums[r + 1]);
                }
            }

            do {
                i++;
            } while(i < nums.size() - 2 && nums[i] == nums[i - 1]);
        }

        return res;
    }
};
// @lc code=end

