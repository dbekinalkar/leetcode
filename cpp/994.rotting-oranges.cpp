/*
 * @lc app=leetcode id=994 lang=cpp
 *
 * [994] Rotting Oranges
 */

// @lc code=start
class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        using loc = pair<int, int>;
        deque<loc> rotted;

        int n = grid.size();
        int m = grid[0].size();

        int fresh = 0;
        int currLevel = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 2) {
                    rotted.emplace_back(i, j);
                    currLevel++;
                }
                else if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int t = 0;
        int nextLevel = 0;

        int dr[4] = {0, 0, 1, -1};
        int dc[4] = {1, -1, 0, 0};

        while(currLevel != 0 || nextLevel != 0) {
            if(currLevel == 0) {
                currLevel = nextLevel;
                nextLevel = 0;
                t++;
            }

            currLevel--;
            loc l = rotted.front();
            rotted.pop_front();

            for(int k = 0; k < 4; k++) {
                loc l2 = {l.first + dr[k], l.second + dc[k]};

                if(l2.first < 0 || l2.first >= n || l2.second < 0 || l2.second >= m) {
                    continue;
                }

                if(grid[l2.first][l2.second] != 1) {
                    continue;
                }

                grid[l2.first][l2.second] = 2;
                nextLevel++;
                fresh--;
                rotted.push_back(l2);
            }
        }

        return fresh == 0? t : -1;
    }
};
// @lc code=end

