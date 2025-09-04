/*
 * @lc app=leetcode id=1584 lang=cpp
 *
 * [1584] Min Cost to Connect All Points
 */

// @lc code=start
class Solution {
public:
    int minCostConnectPoints(vector<vector<int>>& points) {
        struct DistanceToPoint {
            int distance;
            int point_i;

            auto operator<=>(const DistanceToPoint&) const = default; 
        };
        priority_queue<DistanceToPoint, 
            vector<DistanceToPoint>, 
            std::greater<DistanceToPoint>> pq{};

        vector<int> visited (points.size());

        int visited_count = 0;

        int total_distance = 0;

        pq.push({0, 0});

        while(visited_count < points.size()) {
            auto [distance, point_i] = pq.top();
            pq.pop();

            if(visited[point_i]) {
                continue;
            }

            visited[point_i] = true;
            visited_count++;

            total_distance += distance;

            for(int i = 0; i < points.size(); i++) {
                int x0 = points[point_i][0];
                int y0 = points[point_i][1];
                if(!visited[i]) {
                    int x1 = points[i][0];
                    int y1 = points[i][1];
                    int manhattan = abs(x0-x1) + abs(y0-y1);
                    pq.push({manhattan , i});
                }
            }
        }

        return total_distance;
    }
};
// @lc code=end

