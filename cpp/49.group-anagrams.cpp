/*
 * @lc app=leetcode id=49 lang=cpp
 *
 * [49] Group Anagrams
 */

// @lc code=start
class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        std::vector<std::vector<std::string>> res;

        std::unordered_map<std::string, std::vector<std::string>> groups;

        for(std::string& str : strs) {
            std::string key = str;
            std::sort(key.begin(), key.end());

            groups[key].push_back(std::move(str));
        }


        for(auto& kv : groups) {
            res.push_back(std::move(kv.second));
        }

        return res;
    }
};
// @lc code=end

