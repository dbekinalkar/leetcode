/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList();
        
        ArrayDeque<TreeNode> q = new ArrayDeque();
        List<List<Integer>> res = new ArrayList();
        List<Integer> currLevel = new ArrayList();

        q.push(root);
        int levelCount = 1;
        int nextLevelCount = 0;

        while(!q.isEmpty()) {
            if(levelCount == 0) {
                res.add(currLevel);
                currLevel = new ArrayList();
                levelCount = nextLevelCount;
                nextLevelCount = 0;
            }

            levelCount--;
            root = q.pollLast();

            currLevel.add(root.val);

            if(root.left != null) {
                q.push(root.left);
                nextLevelCount++;
            }
            if(root.right != null) {
                q.push(root.right);
                nextLevelCount++;
            }
        }

        res.add(currLevel);

        return res;
    }
}
// @lc code=end

