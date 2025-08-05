/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */

// @lc code=start
class Solution {
    int[] dr = {0, 0, -1, 1};
    int[] dc = {1, -1, 0, 0};
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int count = 0;
        for(int r = 0; r < n; r++) {
            for(int c = 0; c < m; c++) {
                count += search(grid, r, c);
            }
        }

        return count;
    }

    private int search(char[][] grid, int r, int c) {
        int n = grid.length;
        int m = grid[0].length;
        if(r < 0 || r >= n || c < 0 || c >= m || grid[r][c] != '1') {
            return 0;
        }

        grid[r][c] = '0';

        for(int k = 0; k < 4; k++) {
            search(grid, r + dr[k], c + dc[k]);
        }

        return 1;
    }
}
// @lc code=end

