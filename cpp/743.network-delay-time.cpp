/*
 * @lc app=leetcode id=743 lang=cpp
 *
 * [743] Network Delay Time
 */

// @lc code=start
class Solution {
public:
    int networkDelayTime(vector<vector<int>>& times, int n, int k) {
        vector<vector<int>> outedge_index(n+1);

        for(int i = 0; i < times.size(); i++) {
            outedge_index[times[i][0]].push_back(i);
        }

        vector<bool> visited (n+1);
        int visited_count = 0;
        int max_time = 0;

        priority_queue<pair<int, int>, vector<pair<int,int>>, std::greater<pair<int,int>>> pq {};

        pq.push({0, k});

        while(!pq.empty() && visited_count != n) {
            auto [time, i] = pq.top();
            pq.pop();

            if(visited[i]) {
                continue;
            }

            max_time = time;
            visited[i] = true;
            visited_count++;

            for(int outedge_i : outedge_index[i]) {
                pq.push({time + times[outedge_i][2], times[outedge_i][1]});
            }
        }

        return visited_count == n? max_time : -1;

    }
};
// @lc code=end

