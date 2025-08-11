/*
 * @lc app=leetcode id=39 lang=cpp
 *
 * [39] Combination Sum
 */

// @lc code=start
class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>> res;
        vector<int> curr;
        sum(res, candidates, target, curr, 0);

        return res;
    }
    
    void sum(vector<vector<int>>& res, vector<int>& candidates, int target, vector<int>& curr, int i) {
        if(target == 0) {
            res.push_back(curr);
            return;
        }

        if(target < 0) {
            return;
        }

        for(int j = i; j < candidates.size(); j++) {
            curr.push_back(candidates[j]);
            sum(res, candidates, target - candidates[j], curr, j);
            curr.pop_back();
        }

    }

};
// @lc code=end

