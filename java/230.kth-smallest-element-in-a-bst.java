/*
 * @lc app=leetcode id=230 lang=java
 *
 * [230] Kth Smallest Element in a BST
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
    int count = 0;
    TreeNode res = null;

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return res.val;
    }

    private void dfs(TreeNode root, int k) {
        if (root == null) return;

        dfs(root.left, k);
        count++;
        if (count == k) {
            res = root;
            return;
        }
        else if (count < k) {
            dfs(root.right, k);
        }
    }
}
// @lc code=end

