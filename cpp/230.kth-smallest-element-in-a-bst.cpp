/*
 * @lc app=leetcode id=230 lang=cpp
 *
 * [230] Kth Smallest Element in a BST
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int element;
    int kthSmallest(TreeNode* root, int k) {
        dfs(root, k, 0);
        return element;
    }

    int dfs(TreeNode* root, int k, int left) {
        if(!root) return 0;

        int ret = 1;

        ret += dfs(root->left, k, left);

        if(left + ret == k) {
            element = root->val;
            return k;
        }
        else if(left + ret > k) {
            return ret;
        }

        return ret + dfs(root->right, k, ret + left);
    }
};
// @lc code=end

