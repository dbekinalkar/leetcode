/*
 * @lc app=leetcode id=74 lang=java
 *
 * [74] Search a 2D Matrix
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int l = 0;
        int r = n * m;

        while(l < r) {
            int mid = l + (r - l) / 2;

            int row = mid / m;
            int col = mid % m;

            if(matrix[row][col] == target) {
                return true;
            } 
            else if(matrix[row][col] > target) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }

        return false;
    }
}
// @lc code=end

