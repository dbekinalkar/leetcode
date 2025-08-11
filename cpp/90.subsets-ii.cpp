/*
 * @lc app=leetcode id=90 lang=cpp
 *
 * [90] Subsets II
 */

// @lc code=start
class Solution {
public:
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        std::sort(nums.begin(), nums.end());
        vector<vector<int>> res;
        vector<int> curr;
        subset(res, nums, curr, 0);
        
        return res;
    }

    void subset(vector<vector<int>>& res, vector<int>& nums, vector<int>& curr, int i) {
        res.push_back(curr);

        while(i < nums.size()) {
            curr.push_back(nums[i]);
            subset(res, nums, curr, i + 1);
            curr.pop_back();

            do {
                i++;
            } while(i < nums.size() && nums[i] == nums[i-1]);
        }
    }
};
// @lc code=end

