/*
 * @lc app=leetcode id=20 lang=cpp
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
public:

    char toclosed(char c) {
        switch(c) {
            case '(':
                return ')';
            case '[':
                return ']';
            case '{':
                return '}';
            default:
                return '\0';
        }
    }

    bool isValid(string s) {
        std::stack<char> stk;

        for(char c : s) {
            if(c == '(' | c == '[' | c == '{') {
                stk.push(toclosed(c));
            }
            else if(stk.empty() || c != stk.top()) {
                return false;
            }
            else {
                stk.pop();
            }
        }

        return stk.empty();
    }
};
// @lc code=end

