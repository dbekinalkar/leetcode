/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Deque<Integer> q = new ArrayDeque();
        List<List<Integer>> res = new ArrayList();

        Arrays.sort(nums);

        buildSubset(nums, res, q, -1);

        return res;
    }

    public void buildSubset(int[] nums, List<List<Integer>> res, Deque<Integer> q, int i) {
        res.add(new ArrayList(q));

        for(int j = i + 1; j < nums.length; j++) {
            if(j > i + 1 && nums[j] == nums[j - 1]) {
                continue;
            }
            q.addLast(nums[j]);
            buildSubset(nums, res, q, j);
            q.removeLast();
        }
    }
}
// @lc code=end

