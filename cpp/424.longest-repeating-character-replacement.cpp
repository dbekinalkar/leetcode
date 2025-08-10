/*
 * @lc app=leetcode id=424 lang=cpp
 *
 * [424] Longest Repeating Character Replacement
 */

// @lc code=start
class Solution {
public:
    int characterReplacement(string s, int k) {
        int max = 0;
        int maxFreq = 0;
        int freq[26] = {};
        
        int l = 0;

        for(int r = 0; r < s.length(); r++) {
            freq[s[r]-'A']++;
            maxFreq = std::max(maxFreq, freq[s[r]-'A']);

            while(k + maxFreq < r - l + 1) {
                freq[s[l]-'A']--;
                l++;
            }

            max = std::max(max,  r - l + 1);
        }

        return max;
    }
};
// @lc code=end

