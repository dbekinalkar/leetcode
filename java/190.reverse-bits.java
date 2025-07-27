/*
 * @lc app=leetcode id=190 lang=java
 *
 * [190] Reverse Bits
 */

// @lc code=start
class Solution {
    public int reverseBits(int n) {
        int rev = 0;

        for(int i = 0; i < 32; i++) {
            rev <<= 1;
            rev |= n & 1;
            n >>>= 1;

        }

        return rev;
    }
}
// @lc code=end

