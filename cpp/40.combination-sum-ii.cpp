/*
 * @lc app=leetcode id=40 lang=cpp
 *
 * [40] Combination Sum II
 */

// @lc code=start
class Solution {
public:
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        std::sort(candidates.begin(), candidates.end());
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

        while(i < candidates.size()) {
            curr.push_back(candidates[i]);
            sum(res, candidates, target - candidates[i], curr, i + 1);
            curr.pop_back();

            do {
                i++;
            } while(i < candidates.size() && candidates[i] == candidates[i - 1]);
        }
    }
};
// @lc code=end

