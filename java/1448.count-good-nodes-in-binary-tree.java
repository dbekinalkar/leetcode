/*
 * @lc app=leetcode id=1448 lang=java
 *
 * [1448] Count Good Nodes in Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }
    
    public int dfs(TreeNode root, int max) {
        if(root == null) return 0;

        int res = 0;
        if(root.val >= max) {
            max = root.val;
            res++;
        }

        res += dfs(root.left, max);
        res += dfs(root.right, max);

        return res;
    }
}
// @lc code=end

