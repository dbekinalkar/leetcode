/*
 * @lc app=leetcode id=167 lang=java
 *
 * [167] Two Sum II - Input Array Is Sorted
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;

        int sum;

        while(l < r) {
            sum = numbers[l] + numbers[r];

            if(sum == target) {
                return new int[]{l + 1, r + 1};
            }
            else if(sum < target) {
                l++;
            }
            else {
                r--;
            }
        }

        return null;
    }
}
// @lc code=end

