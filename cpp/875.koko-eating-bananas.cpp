/*
 * @lc app=leetcode id=875 lang=cpp
 *
 * [875] Koko Eating Bananas
 */

// @lc code=start
class Solution {
public:
    int minEatingSpeed(vector<int>& piles, int h) {
        int l = 1;
        int r = *std::max_element(piles.begin(), piles.end());

        int m;

        while(l < r) {
            m = l + (r - l) / 2;

            if(check(piles, h, m)) {
                r = m;
            }
            else {
                l = m + 1;
            }
        }

        return l;
    }

    bool check(std::vector<int>& piles, int h, int ans) {
        int count = 0;
        for(int pile : piles) {
            count += (pile + ans - 1) / ans;
        }
        return count <= h;
    }
};
// @lc code=end

