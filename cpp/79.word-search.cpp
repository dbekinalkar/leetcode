/*
 * @lc app=leetcode id=79 lang=cpp
 *
 * [79] Word Search
 */

// @lc code=start
class Solution {
public:
    int dr[4] = {0, 0, 1, -1};
    int dc[4] = {1, -1, 0, 0};
    bool exist(vector<vector<char>>& board, string word) {
        int n = board.size();
        int m = board[0].size();
        vector<vector<bool>> v (n, vector<bool>(m, false));

        for(int r = 0; r < n; r++) {
            for(int c = 0; c < m; c++) {
                if(search(board, word, v, r, c, 0)) return true;
            }
        }

        return false;
    }

    bool search(vector<vector<char>>& board, string word, vector<vector<bool>>& v, int r, int c, int i) {
        if(i == word.size()) return true;

        int n = board.size();
        int m = board[0].size();

        if(r < 0 | r >= n | c < 0 | c >= m) return false;
        if(word[i] != board[r][c] || v[r][c]) return false;

        v[r][c] = true;

        for(int k = 0; k < 4; k++) {
            if(search(board, word, v, r + dr[k], c + dc[k], i + 1)) {
                return true;
            }
        }

        v[r][c] = false;

        return false;
    }
};
// @lc code=end

