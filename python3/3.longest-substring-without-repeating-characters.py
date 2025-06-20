#
# @lc app=leetcode id=3 lang=python3
#
# [3] Longest Substring Without Repeating Characters
#

# @lc code=start
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        maxcount = 0
        charcount = defaultdict(int)
        l = 0

        for r, c in enumerate(s):
            charcount[c] += 1

            while charcount[c] > 1:
                charcount[s[l]] -= 1
                l += 1

            maxcount = max(maxcount, r - l + 1)

        return maxcount
# @lc code=end

