/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] charCounts = new int[26];
        char[] chars = s.toCharArray();

        for(char c: chars) {
            charCounts[c-'a']++;
        }

        chars = t.toCharArray();

        for(char c:chars) {
            charCounts[c-'a']--;
        }

        for(int num: charCounts) {
            if(num != 0) return false;
        }

        return true;
    }
}
// @lc code=end

