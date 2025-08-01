/*
 * @lc app=leetcode id=739 lang=java
 *
 * [739] Daily Temperatures
 */

// @lc code=start
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> idx = new ArrayDeque();

        int[] res = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++) {
            while(!idx.isEmpty() && temperatures[i] > temperatures[idx.peek()]) {
                int j = idx.pop(); 
                res[j] = i - j;
            }

            idx.push(i);
        }

        return res;
    }
}
// @lc code=end

