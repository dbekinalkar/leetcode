/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Deque<Integer> q = new ArrayDeque();
        List<List<Integer>> res = new ArrayList();

        buildSubset(nums, res, q, -1);

        return res;
    }

    public void buildSubset(int[] nums, List<List<Integer>> res, Deque<Integer> q, int i) {
        res.add(new ArrayList(q));

        for(int j = i + 1; j < nums.length; j++) {
            q.addLast(nums[j]);
            buildSubset(nums, res, q, j);
            q.removeLast();
        }
    }
}
// @lc code=end

