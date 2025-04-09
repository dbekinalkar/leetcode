/*
 * @lc app=leetcode id=7 lang=java
 *
 * [7] Reverse Integer
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        long reversed = 0;

        while(x != 0) {
            reversed *= 10;
            reversed += x % 10;
            x /= 10;
        }

        if(reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) {
            return 0;
        }

        return (int) reversed;
    }
}
// @lc code=end

