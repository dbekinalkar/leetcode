/*
 * @lc app=leetcode id=22 lang=cpp
 *
 * [22] Generate Parentheses
 */

// @lc code=start
class Solution {
public:
    vector<string> generateParenthesis(int n) {
        std::vector<std::string> res;
        std::string builder;

        build(res, builder, n, 0, 0);

        return res;
    }

    void build(std::vector<std::string>& res, std::string& builder, int n, int open, int closed) {
        if(closed == n) {
            res.push_back(builder);
            return;
        }

        if(open < n) {
            builder.push_back('(');
            build(res, builder, n, open + 1, closed);
            builder.pop_back();
        }

        if(closed < open) {
            builder.push_back(')');
            build(res, builder, n, open, closed + 1);
            builder.pop_back();
        }
    }

};
// @lc code=end

