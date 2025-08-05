/*
 * @lc app=leetcode id=994 lang=java
 *
 * [994] Rotting Oranges
 */

// @lc code=start
class Solution {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Deque<int[]> q = new ArrayDeque();

        int count = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
                else if(grid[i][j] == 1) {
                    count++;
                }
            }
        }

        int t = 0;
        int currLevel = q.size();
        int nextLevel = 0;

        while(!q.isEmpty()) {
            if(currLevel == 0) {
                t++;
                currLevel = nextLevel;
                nextLevel = 0;
            }

            currLevel--;
            int[] loc = q.poll();

            for(int k = 0; k < 4; k++) {
                int ret = checkAndAdd(grid, n, m, q, loc[0] + dx[k], loc[1] + dy[k]);
                count -= ret;
                nextLevel += ret;
            }
        }

        if(count > 0) return -1;

        return t;
    }

    public int checkAndAdd(int[][] grid, int n, int m, Deque<int[]> q, int i, int j) {
        if(i < 0 || i >= n || j < 0 || j >= m || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = 2;
        q.add(new int[]{i, j});

        return 1;
    }
}
// @lc code=end

