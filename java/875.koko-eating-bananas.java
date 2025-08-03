/*
 * @lc app=leetcode id=875 lang=java
 *
 * [875] Koko Eating Bananas
 */

// @lc code=start
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);

        int l = 1;
        int r = piles[piles.length - 1];
        int m;

        while(l < r) {
            m = l + (r - l) / 2;

            if(check(m, piles, h)) {
                r = m;
            }
            else {
                l = m + 1;
            }
        }

        return l;
    }

    public boolean check(int ans, int[] piles, int h) {
        for(int pile : piles) {
            h -= (pile + ans - 1) / ans;

            if(h < 0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

