/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().toCharArray();

        int i = 0;
        int j = chars.length - 1;
        while(i < j) {
            if(!Character.isAlphabetic(chars[i]) && !Character.isDigit(chars[i])) {
                i++;
            }
            else if(!Character.isAlphabetic(chars[j]) && !Character.isDigit(chars[j])) {
                j--;
            }
            else if(chars[i] != chars[j]) {
                return false;
            }
            else {
                i++;
                j--;
            }
        }

        return true;
    }
}
// @lc code=end

