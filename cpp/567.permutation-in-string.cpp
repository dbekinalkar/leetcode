/*
 * @lc app=leetcode id=567 lang=cpp
 *
 * [567] Permutation in String
 */

// @lc code=start
class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        if(s1.size() > s2.size()) return false;

        int freq[26] = {};

        for(char c : s1) {
            freq[c-'a']++;
        }

        for(int r = 0; r < s1.size(); r++) {
            freq[s2[r]-'a']--;
        }

        int l = 0;

        for(int r = s1.size(); r < s2.size(); r++) {
            if(std::count(&freq[0], &freq[26], 0) == 26) {
                return true;
            }

            freq[s2[r]-'a']--;
            freq[s2[l]-'a']++;
            l++;
        }

        if(std::count(&freq[0], &freq[26], 0) == 26) {
            return true;
        }

        return false;
    }
};
// @lc code=end

