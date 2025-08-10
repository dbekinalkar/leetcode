/*
 * @lc app=leetcode id=150 lang=cpp
 *
 * [150] Evaluate Reverse Polish Notation
 */

// @lc code=start
class Solution {
public:
    int evalRPN(vector<string>& tokens) {

        std::stack<int> stk;

        std::unordered_map<std::string, std::function<void()>> map = {
            {"+", [&](){
                int y = stk.top();
                stk.pop();
                int x = stk.top();
                stk.pop();
                stk.push(x + y);
            }},
            {"-", [&](){
                int y = stk.top();
                stk.pop();
                int x = stk.top();
                stk.pop();
                stk.push(x - y);
            }},
            {"*", [&](){
                int y = stk.top();
                stk.pop();
                int x = stk.top();
                stk.pop();
                stk.push(x * y);
            }},
            {"/", [&](){
                int y = stk.top();
                stk.pop();
                int x = stk.top();
                stk.pop();
                stk.push(x / y);
            }}
        }; 

        for(std::string& s : tokens) {
            if(map.contains(s)) {
                map[s]();
            }
            else {
                stk.push(std::stoi(s));
            }
        }

        return stk.top();
    }
};
// @lc code=end

