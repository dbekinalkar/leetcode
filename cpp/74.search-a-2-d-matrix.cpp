/*
 * @lc app=leetcode id=74 lang=cpp
 *
 * [74] Search a 2D Matrix
 */

// @lc code=start
class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int n = matrix.size();
        int m = matrix[0].size();

        int l = 0;
        int r = n * m;
        int mid, midr, midc;

        while(l < r) {
            mid = l + (r - l) / 2;

            midr = mid / m;
            midc = mid % m;

            if(matrix[midr][midc] == target) {
                return true;
            }
            else if(matrix[midr][midc] < target) {
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }

        return false;
    }
};
// @lc code=end

