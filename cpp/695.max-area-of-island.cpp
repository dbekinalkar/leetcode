/*
 * @lc app=leetcode id=695 lang=cpp
 *
 * [695] Max Area of Island
 */

// @lc code=start
class Solution {
public:
    int dr[4] = {0, 0, 1, -1};
    int dc[4] = {1, -1, 0, 0};

    int maxAreaOfIsland(vector<vector<int>>& grid) {
        int max = 0;

        for(int i = 0; i < grid.size(); i++) {
            for(int j = 0; j < grid[0].size(); j++) {
                max = std::max(max, bfs(grid, i, j));
            }
        }

        return max;
    }

    int bfs(vector<vector<int>>& grid, int r, int c) {
        int n = grid.size();
        int m = grid[0].size();

        if(r < 0 | r >= n | c < 0 | c >= m) {
            return 0;
        }
        if(grid[r][c] != 1) {
            return 0;
        }

        grid[r][c] = 0;

        int ret = 1;

        for(int k = 0; k < 4; k++) {
            ret += bfs(grid, r + dr[k], c + dc[k]);
        }

        return ret;
    }
};
// @lc code=end

