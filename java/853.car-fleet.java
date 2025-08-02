/*
 * @lc app=leetcode id=853 lang=java
 *
 * [853] Car Fleet
 */

// @lc code=start
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Integer[] idx = new Integer[position.length];

        for(int i = 0; i < idx.length; i++) {
            idx[i] = i;
        }

        Arrays.sort(idx, Comparator.comparingInt(i -> position[i]));

        Deque<Double> stk = new ArrayDeque();

        for(int i : idx) {
            double arrival = (double) (target - position[i]) / speed[i];

            while(!stk.isEmpty() && arrival >= stk.peek()) {
                stk.pop();
            }

            stk.push(arrival);
        }

        return stk.size();
    }
}
// @lc code=end

