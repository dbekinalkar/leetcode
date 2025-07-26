/*
 * @lc app=leetcode id=202 lang=java
 *
 * [202] Happy Number
 */

// @lc code=start
class Solution {
    public boolean isHappy(int n) {
        if(n == 1) return true;
        Set<Integer> found = new HashSet();

        int fast = next(n);

        while(n != fast) {
            n = next(n);
            fast = next(next(fast));
            if(fast == 1) {
                return true;
            }
        }

        return false;
    }

    public int next(int n) {
        int next = 0;
        while(n != 0) {
            next += (n % 10) * (n % 10);
            n /= 10;
        }

        return next;
    }
}
// @lc code=end

