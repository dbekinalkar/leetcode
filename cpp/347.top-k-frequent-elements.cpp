/*
 * @lc app=leetcode id=347 lang=cpp
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start
class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        std::unordered_map<int, int> count;
        std::priority_queue<pair<int, int>> pq;
        
        for(int num : nums) {
            count[num]++;
        }

        for(auto[f, s] : count) {
            pq.push({s, f});
        }

        std::vector<int> res;

        while (k--) {
            res.push_back(pq.top().second); 
            pq.pop();
        }

        return res;
    }
};
// @lc code=end

