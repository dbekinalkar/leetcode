/*
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int maxLength = strs[0].length();
        char[] chars = strs[0].toCharArray();


        for(int i = 1; i < strs.length; i++) {
            maxLength = Math.min(maxLength, strs[i].length());
            for(int j = 0; j < maxLength; j++) {
                if(chars[j] != strs[i].charAt(j)) {
                    maxLength = j;
                    break;
                }
            }
        } 


        return new String(chars, 0, maxLength);

    }
}
// @lc code=end

