/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap();

        for(int num : nums) {
            map.merge(num, 1, Integer::sum);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = 
            new PriorityQueue<Map.Entry<Integer, Integer>>(
                Comparator.comparingInt((Map.Entry<Integer, Integer> e) -> -e.getValue()));

        pq.addAll(map.entrySet());

        int[] res = new int[k];

        for(int i = 0; i < k; i++) {
            res[i] = pq.poll().getKey();
        }

        return res;
    }
}
// @lc code=end

