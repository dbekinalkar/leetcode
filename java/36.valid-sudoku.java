/*
 * @lc app=leetcode id=36 lang=java
 *
 * [36] Valid Sudoku
 */

// @lc code=start
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] boxes = new int[9];

        for(int currRow = 0; currRow < 9; currRow++) {
            for(int currCol = 0; currCol < 9; currCol++) {
                if(!Character.isDigit(board[currRow][currCol])) {
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
}
// @lc code=end

