/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int l = 0;
        HashSet<Character> set = new HashSet<Character>();
        char c, c2;

        for(int r = 0; r < s.length(); r++) {
            c = s.charAt(r);
            if(!set.contains(c)) {
                set.add(c);
                continue;
            }

            max = Math.max(max, r-l);
            while((c2 = s.charAt(l)) != c) {
                set.remove(c2);
                l++;
            }
            l++;
        }

        max = Math.max(max, s.length()-l);

        return max;
    }
}
// @lc code=end

