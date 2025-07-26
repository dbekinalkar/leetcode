/*
 * @lc app=leetcode id=66 lang=java
 *
 * [66] Plus One
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int carry = 1;
        int i = n - 1;
        while(carry != 0 && i >= 0) {
            digits[i]+=carry;
            carry = digits[i] >= 10 ? 1 : 0;
            digits[i] %= 10;
            i--;
        } 

        if(carry == 1) {
            int[] ret = new int[n + 1];
            ret[0] = 1;
            for(i = 0; i < n; i++) {
                ret[i + 1] = digits[i];
            }
            return ret;
        }

        return digits;
    }
}
// @lc code=end

