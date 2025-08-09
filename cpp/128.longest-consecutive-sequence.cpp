/*
 * @lc app=leetcode id=128 lang=cpp
 *
 * [128] Longest Consecutive Sequence
 */

// @lc code=start
class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        std::unordered_set<int> found (nums.begin(), nums.end());

        int max = 0;
        int count;

        for(int num : found) {
            if(found.contains(num - 1)) continue;

            count = 0;

            do {
                count++;
                num++;
            } while(found.contains(num));

            max = std::max(max, count);
        }

        return max;
    }
};
// @lc code=end

