/*
 * @lc app=leetcode id=417 lang=java
 *
 * [417] Pacific Atlantic Water Flow
 */

// @lc code=start
class Solution {
    int[] dr = {0, 0, 1, -1};
    int[] dc = {1, -1, 0, 0};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList();

        int n = heights.length;
        int m = heights[0].length;

        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        for(int r = 0; r < n; r++) {
            bfs(heights, pacific, n, m, r, 0, Integer.MIN_VALUE);
            bfs(heights, atlantic, n, m, r, m - 1, Integer.MIN_VALUE);
        }

        for(int c = 0; c < m; c++) {
            bfs(heights, pacific, n, m, 0, c, Integer.MIN_VALUE);
            bfs(heights, atlantic, n, m, n - 1, c, Integer.MIN_VALUE);
        }

        for(int r = 0; r < n; r++) {
            for(int c = 0; c < m; c++) {
                if(pacific[r][c] && atlantic[r][c]) {
                    res.add(List.of(r, c));
                }
            }
        }

        return res;
    }

    public void bfs(int[][] heights, boolean[][] visited, int n, int m, int r, int c, int prev) {
        if(r < 0 || r >= n || c < 0 || c >= m || visited[r][c] || prev > heights[r][c]) return;
        
        visited[r][c] = true;

        for(int k = 0; k < 4; k++) {
            bfs(heights, visited, n, m, r + dr[k], c + dc[k], heights[r][c]);
        }
    }
}
// @lc code=end

