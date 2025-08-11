/*
 * @lc app=leetcode id=973 lang=cpp
 *
 * [973] K Closest Points to Origin
 */

// @lc code=start
class Solution {
public:
    vector<vector<int>> kClosest(vector<vector<int>>& points, int k) {
        using T = tuple<int,int,int>;
        std::priority_queue<T, vector<T>, std::greater<T>> pq;
        
        for(vector<int>& point : points) {
            pq.emplace(point[0] * point[0] + point[1] * point[1]
                , point[0]
                , point[1]);
        }

        vector<vector<int>> res;

        while(k--) {
            res.push_back({std::get<1>(pq.top()), std::get<2>(pq.top())});
            pq.pop();
        }

        return res;
    }
};
// @lc code=end

