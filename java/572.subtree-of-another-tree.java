/*
 * @lc app=leetcode id=572 lang=java
 *
 * [572] Subtree of Another Tree
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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null) {
            return true;
        }

        if(root == null) {
            return false;
        }

        return isEqual(root, subRoot)
            || isSubtree(root.left, subRoot)
            || isSubtree(root.right, subRoot);
    }

    public boolean isEqual(TreeNode root, TreeNode root2) {
        if(root == null && root2 == null) {
            return true;
        }

        if(root == null || root2 == null) {
            return false;
        }

        return root.val == root2.val 
            && isEqual(root.left, root2.left) 
            && isEqual(root.right, root2.right);
        
    }
}
// @lc code=end

