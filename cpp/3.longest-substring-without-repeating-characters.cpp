/*
 * @lc app=leetcode id=3 lang=cpp
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        bool found[128] = {};

        int max = 0;

        int l = 0;

        for(int r = 0; r < s.size(); r++) {
            while(found[s[r]]) {
                found[s[l]] = false;
                l++;
            }
            found[s[r]] = true;
            max = std::max(max, r - l + 1);
        }

        return max;
    }
};
// @lc code=end

