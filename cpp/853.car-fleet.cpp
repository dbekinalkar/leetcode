/*
 * @lc app=leetcode id=853 lang=cpp
 *
 * [853] Car Fleet
 */

// @lc code=start
class Solution {
public:
    int carFleet(int target, vector<int>& position, vector<int>& speed) {
        int n = position.size();
        vector<int> idx(n);

        for(int i = 0; i < n; i++) {
            idx[i] = i;
        }

        std::sort(idx.begin(), idx.end(), [&](int a, int b) -> bool {
            return position[a] < position[b];
        });

        std::stack<double> stk;

        for(int i = 0; i < n; i++) {
            double arrival = static_cast<double>(target - position[idx[i]]) / speed[idx[i]];
            while(!stk.empty() && arrival >= stk.top()) {
                stk.pop();
            }
            stk.push(arrival);
        }

        return stk.size();
    }
};
// @lc code=end

