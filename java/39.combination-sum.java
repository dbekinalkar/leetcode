/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
        Deque<Integer> q = new ArrayDeque();

        build(candidates, target, res, q, 0, 0);

        return res;
    }

    public void build(int[] candidates, int target, List<List<Integer>> res, Deque<Integer> q, int i, int sum) {
        if(sum == target) {
            res.add(new ArrayList(q));
            return;
        }

        if(sum > target || i >= candidates.length) {
            return;
        }

        build(candidates, target, res, q, i+1, sum);

        q.addLast(candidates[i]);
        build(candidates, target, res, q, i, sum + candidates[i]);
        q.removeLast();
    }
}
// @lc code=end

