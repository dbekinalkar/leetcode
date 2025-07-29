/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 */

// @lc code=start
class Solution {
    public Map<Integer, Integer> parents = new HashMap<>();
    public Map<Integer, Integer> size = new HashMap<>();

    public int longestConsecutive(int[] nums) {
        if(nums.length == 0 || nums.length == 1) return nums.length;
        int max = 1;

        int sizeX;
        for(int num : nums) {
            if(parents.get(num) != null) continue;

            parents.put(num, num);
            size.put(num, 1);
            sizeX = 1;

            if(parents.get(num - 1) != null) {
                sizeX = union(num, sizeX, num - 1);
                max = Math.max(max, sizeX);

            }

            if(parents.get(num + 1) != null) {
                sizeX = union(num, sizeX, num + 1);
                max = Math.max(max, sizeX);

            }
        }

        return max;
    }

    public int union(int x, int sizeX, int y) {
        int rootX = find(x);
        int rootY = find(y);

        int sizeY = size.get(rootY);
        int ret;
        if(sizeX > sizeY) {
            parents.put(rootY, rootX);
            ret = size.merge(rootX, sizeY, Integer::sum);
        }
        else {
            parents.put(rootX, rootY);
            ret = size.merge(rootY, sizeX, Integer::sum);
        }


        return ret;
    }

    public int find(int x) {
        int parent = parents.get(x);
        if(parent == x) return x;

        int ret = find(parent);
        parents.put(x, ret); 
        
        return ret;
    }
}
// @lc code=end
