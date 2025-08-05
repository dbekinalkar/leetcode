/*
 * @lc app=leetcode id=695 lang=java
 *
 * [695] Max Area of Island
 */

// @lc code=start
class Solution {
    int[] dr = {0, 0, -1, 1};
    int[] dc = {1, -1, 0, 0};
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int max = 0;
        for(int r = 0; r < n; r++) {
            for(int c = 0; c < m; c++) {
                max = Math.max(max, search(grid, r, c));
            }
        }

        return max;
    }

    private int search(int[][] grid, int r, int c) {
        int n = grid.length;
        int m = grid[0].length;
        if(r < 0 || r >= n || c < 0 || c >= m || grid[r][c] != 1) {
            return 0;
        }

        grid[r][c] = 0;

        int res = 1;

        for(int k = 0; k < 4; k++) {
            res += search(grid, r + dr[k], c + dc[k]);
        }

        return res;
    }
}
// @lc code=end

