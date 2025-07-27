/*
 * @lc app=leetcode id=338 lang=java
 *
 * [338] Counting Bits
 */

// @lc code=start
class Solution {
    public int[] countBits(int n) {
        if(n == 0) return new int[]{0};
        int[] ret = new int[n + 1];

        ret[0] = 0;
        ret[1] = 1;

        for(int i = 2; i <= n; i++) {
            if((i & 1) == 1) {
                ret[i] = ret[i - 1] + 1;
            }
            else {
                ret[i] = ret[i >> 1];
            }
        }

        return ret;
    }
}
// @lc code=end

