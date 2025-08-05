/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 */

// @lc code=start
class Solution {
    int[] dr = {0, 0, -1, 1};
    int[] dc = {1, -1, 0, 0};
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];

        for(int r = 0; r < n; r++) {
            for(int c = 0; c < m; c++) {
                if(search(board, word, visited, n, m, r, c, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean search(char[][] board, String word, boolean[][] visited, int n, int m, int r, int c, int i) {
        if(i >= word.length()) {
            return true;
        }
        
        if(r < 0 || r >= n 
        || c < 0 || c >= m 
        || visited[r][c] 
        || word.charAt(i) != board[r][c]) {
            return false;
        }

        visited[r][c] = true;

        for(int k = 0; k < 4; k++) {
            if(search(board, word, visited, n, m, r + dr[k], c + dc[k], i + 1)) {
                return true;
            }
        }

        visited[r][c] = false;

        return false;
    }
}
// @lc code=end

