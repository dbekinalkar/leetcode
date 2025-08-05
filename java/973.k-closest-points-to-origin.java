/*
 * @lc app=leetcode id=973 lang=java
 *
 * [973] K Closest Points to Origin
 */

// @lc code=start
class Solution {
    class PointDistance {
        int[] point;
        int distance;

        PointDistance(int[] point, int distance) {
            this.point = point;
            this.distance = distance;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][];

        PriorityQueue<PointDistance> pq = new PriorityQueue<PointDistance>(
            Comparator.comparingInt((PointDistance pd) -> pd.distance)
        );

        for(int[] p : points) {
            pq.add(new PointDistance(p, p[0] * p[0] + p[1] * p[1]));
        }

        for(int i = 0; i < k; i++) {
            res[i] = pq.poll().point;
        }

        return res;
    }
}
// @lc code=end

