/*
 * @lc app=leetcode id=217 lang=cpp
 *
 * [217] Contains Duplicate
 */

// @lc code=start
class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        std::unordered_set<int> set;

        for(int num : nums) {
            if(set.contains(num)) {
                return true;
            }

            set.insert(num);
        }

        return false;
    }
};
// @lc code=end

