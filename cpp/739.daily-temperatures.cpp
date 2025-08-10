/*
 * @lc app=leetcode id=739 lang=cpp
 *
 * [739] Daily Temperatures
 */

// @lc code=start
class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        std::stack<int> stk;

        std::vector<int> res(temperatures.size(), 0);

        for(int i = 0; i < temperatures.size(); i++) {
            while(!stk.empty() && temperatures[i] > temperatures[stk.top()]) {
                res[stk.top()] = i - stk.top();
                stk.pop();
            }

            stk.push(i);
        }

        return res;
    }
};
// @lc code=end

