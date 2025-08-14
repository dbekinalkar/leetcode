/*
 * @lc app=leetcode id=200 lang=cpp
 *
 * [200] Number of Islands
 */

// @lc code=start
class Solution {
public:
    int dr[4] = {0, 0, 1, -1};
    int dc[4] = {1, -1, 0, 0};
    int numIslands(vector<vector<char>>& grid) {
        int count = 0;
        for(int r = 0; r < grid.size(); r++) {
            for(int c = 0; c < grid[0].size(); c++) {
                count += bfs(grid, r, c);
            }
        }

        return count;
    }

    bool bfs(vector<vector<char>>& grid, int r, int c) {
        int n = grid.size();
        int m = grid[0].size();
        if(r < 0 | r >= n | c < 0 | c >= m) {
            return false;
        }

        if(grid[r][c] != '1') {
            return false;
        }

        grid[r][c] = '0';

        for(int k = 0; k < 4; k++) {
            bfs(grid, r + dr[k], c + dc[k]);
        }

        return true;
    }
};
// @lc code=end

