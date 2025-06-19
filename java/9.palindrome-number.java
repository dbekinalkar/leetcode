/*
 * @lc app=leetcode id=9 lang=java
 *
 * [9] Palindrome Number
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        if(x == 0) return true;
        if(x < 0 || x % 10 == 0) return false;

        int reverse = 0;
        while(x > reverse) {
            reverse *= 10;
            reverse += x % 10;

            x /= 10;
        }

        return x == reverse || x == reverse / 10;
    }
}
// @lc code=end

