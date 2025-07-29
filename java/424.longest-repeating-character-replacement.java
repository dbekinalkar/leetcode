/*
 * @lc app=leetcode id=424 lang=java
 *
 * [424] Longest Repeating Character Replacement
 */

// @lc code=start
class Solution {
    public int characterReplacement(String s, int k) {
        char[] chars = s.toCharArray();
        int n = s.length();
        
        int[] freq = new int[26];
        int maxFreq = 0;

        int maxLength = 0;
        int l = -1;
        for(int r = 0; r < n; r++) {
            freq[chars[r] - 'A']++;
            maxFreq = Math.max(maxFreq, freq[chars[r] - 'A']);

            if(r - l - maxFreq > k) {
                l++;
                freq[chars[l] - 'A']--;
            }

            maxLength = Math.max(maxLength, r - l);
        }
        return maxLength;
    }
}
// @lc code=end

