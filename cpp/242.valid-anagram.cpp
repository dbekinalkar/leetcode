/*
 * @lc app=leetcode id=242 lang=cpp
 *
 * [242] Valid Anagram
 */

// @lc code=start
class Solution {
public:
    bool isAnagram(string s, string t) {
        int count[26];

        for(char c : s) {
            count[c - 'a']++;
        }

        for(char c : t) {
            count[c - 'a']--;
        }

        return std::all_of(&count[0], &count[26], [](int c){ return c == 0; });
    }
};
// @lc code=end

