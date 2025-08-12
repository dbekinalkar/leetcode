/*
 * @lc app=leetcode id=17 lang=cpp
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start
class Solution {
public:
    vector<string> letterCombinations(string digits) {
        vector<string> res;
        if(digits.empty()) return res;
        
        vector<string> map{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        string curr;

        auto dfs = [&](int i, auto dfs) {
            if(i == digits.size()) {
                res.push_back(curr);
                return;
            }

            char d = digits[i];

            for(char c : map[d - '2']) {
                curr.push_back(c);
                dfs(i + 1, dfs);
                curr.pop_back();
            }
        };

        dfs(0, dfs);

        return res;
    }
};
// @lc code=end

