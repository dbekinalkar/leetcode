/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue();

        for(int i = 0; i < k; i++) {
            pq.add(num);
            if(pq.size() > k) pq.poll();
        }

        return pq.poll();
    }
}
// @lc code=end

