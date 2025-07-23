/*
 * @lc app=leetcode id=217 lang=java
 *
 * [217] Contains Duplicate
 */

// @lc code=start
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> contained = new HashSet<>();

        for(int num: nums) {
            if(contained.contains(num)) {
                return true;
            }
            contained.add(num);
        }

        return false;
    }
}
// @lc code=end

