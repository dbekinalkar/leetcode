/*
 * @lc app=leetcode id=28 lang=java
 *
 * [28] Find the Index of the First Occurrence in a String
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {
        boolean found = false;
        for(int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            found = true;
            for(int j = 0; j < needle.length(); j++) {
                if(haystack.charAt(i+j) != needle.charAt(j)) {
                    found = false;
                    break;
                }
            }
            if(found) return i;
        }

        return -1;
    }
}
// @lc code=end

