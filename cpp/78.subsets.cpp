/*
 * @lc app=leetcode id=78 lang=cpp
 *
 * [78] Subsets
 */

// @lc code=start
class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> res;
        vector<int> curr;
        subset(res, nums, curr, 0);
        
        return res;
    }

    void subset(vector<vector<int>>& res, vector<int>& nums, vector<int>& curr, int i) {
        res.push_back(curr);

        for(int j = i; j < nums.size(); j++) {
            curr.push_back(nums[j]);
            subset(res, nums, curr, j + 1);
            curr.pop_back();
        }
    }
};
// @lc code=end

