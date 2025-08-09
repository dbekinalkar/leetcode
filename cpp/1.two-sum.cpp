/*
 * @lc app=leetcode id=1 lang=cpp
 *
 * [1] Two Sum
 */

// @lc code=start
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        std::unordered_map<int, int> map;

        for(int i = 0; i < nums.size(); i++) {
            if(map.contains(nums[i])) {
                return { map[nums[i]], i };
            }

            map[target - nums[i]] = i;
        }

        return {};
    }
};
// @lc code=end

