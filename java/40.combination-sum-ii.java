/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
        Deque<Integer> q = new ArrayDeque();

        Arrays.sort(candidates);

        build(candidates, target, res, q, 0);

        return res;
    }

    public void build(int[] candidates, int target, List<List<Integer>> res, Deque<Integer> q, int i) {
        if(target == 0) {
            res.add(new ArrayList(q));
            return;
        }

        if(target < 0 || i >= candidates.length) {
            return;
        }

        for(int j = i; j < candidates.length; j++) {
            if(j > i && candidates[j] == candidates[j - 1]) continue;
            if(candidates[j] > target) return;

            q.addLast(candidates[j]);
            build(candidates, target - candidates[j], res, q, j + 1);
            q.removeLast();
        }
    }
}
// @lc code=end

