/*
 * @lc app=leetcode id=36 lang=cpp
 *
 * [36] Valid Sudoku
 */

// @lc code=start
class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        int rows[9] = {};
        int cols[9] = {};
        int boxes[9] = {};

        for(int currRow = 0; currRow < 9; currRow++) {
            for(int currCol = 0; currCol < 9; currCol++) {
                if(!isdigit(board[currRow][currCol])) {
                    continue;
                }

                int currBox = currRow / 3 + 3 * (currCol / 3);
                int inBoxIndex = currCol - 3 * (currCol / 3) + 3 * (currRow - 3 * (currRow / 3));

                int digitBit = 1 << (board[currRow][currCol] - '0');
                if((rows[currRow] & (digitBit)) != 0
                    || (cols[currCol] & (digitBit)) != 0
                    || (boxes[currBox] & (digitBit)) != 0
                ) {
                    return false;
                }
                else {
                    rows[currRow] |= digitBit;
                    cols[currCol] |= digitBit;
                    boxes[currBox] |= digitBit;
                }
            }
        }

        return true;
    }
};
// @lc code=end

